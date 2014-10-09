package nl.scribblon.riftcraft.manager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import nl.scribblon.riftcraft.entity.EntityRift;
import nl.scribblon.riftcraft.event.entity.player.PlayerFocusEvent;
import nl.scribblon.riftcraft.event.entity.rift.EntityRiftFormationEvent;
import nl.scribblon.riftcraft.reference.Settings;
import nl.scribblon.riftcraft.util.IRiftConductable;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.helper.LocationHelper;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 05-09-14
 *
 * An active rift (aka teleport). A rift contains a source, destination, subject and a few other do-dats.
 * Not to be confused with the EntityRift which is the entity spawned in the world.
 * Does not handle teleportation through rifts made in the Rift Well structure.
 * Meta-class it doesn't really fit in any kind of package at the moment.
 * But basically this is a Rift managing tickHandler on the individual level.
 */
public class Rift implements IRiftConductable {
    //The internal clock
    private EnumMap<Stage, Stage.Status> stageStatus;

    //The three stars of the show
    private EntityRift departingRift;
    private EntityRift exitRift;
    private EntityPlayer subject;

    //Where from, where to, ma'am.
    private ILocationRC source;
    private ILocationRC destination;

    //Your ticks are ours
    private int ticksActive;
    private int targetFocusTicks;
    private int targetShiftTicks;

    private boolean fauxCancel;

    //Set to private as these are independent initializations no matter what the input is.
    private Rift(){
        this.ticksActive = -1;
        this.targetFocusTicks = Settings.Shards.defaultFocusTime;
        this.targetShiftTicks = Settings.Shards.defaultShiftTime;
        this.fauxCancel = false;

        //Initialize all values of the enumMap.
        this.stageStatus = new EnumMap<Stage, Stage.Status>(Rift.Stage.class);
        for(Map.Entry<Stage, Stage.Status> entry : stageStatus.entrySet()) {
            entry.setValue(Stage.Status.NOT_INITIATED);
        }
    }

    public Rift (EntityPlayer subject, ILocationRC source, ILocationRC destination) {
        this();

        this.subject = subject;
        this.source = source;
        this.destination = destination;

        this.init();
    }

    public Rift (EntityPlayer subject, ILocationRC source, IRelativeLocationRC relativeLocation) {
        this();

        this.subject = subject;
        this.source = source;
        this.destination = relativeLocation.getILocationRelativelyFrom(source);

        this.init();
    }

    //@formatter:off
    //Needed as forward referencing in the private constructor will make this go bad.
    private void init() {
        this.departingRift = new EntityRift(this.source, EntityRift.RiftType.RIFT_SHARD_ENTER);
        this.exitRift = new EntityRift(this.destination, EntityRift.RiftType.RIFT_SHARD_EXIT);
    }
    //@formatter:on

    @Override
    public boolean receiveConductorTick(int tick) {
        this.ticksActive += tick;
        //Whenever a stage hasn't ended give it the tick
        if(this.stageStatus.get(Stage.FOCUS) != Stage.Status.ENDED)
            this.tickFocus(this.ticksActive);
        if(this.stageStatus.get(Stage.SHIFTED) != Stage.Status.ENDED )
            this.tickShift(this.ticksActive);
        if(this.stageStatus.get(Stage.FINALIZING) != Stage.Status.ENDED)
            this.tickFinalization(this.ticksActive);

        if(this.stageStatus.get(Stage.FINALIZING) == Stage.Status.ENDED && this.fauxCancel) {
            //TODO Fizzle that Dizzle
        }

        return this.stageStatus.get(Stage.FINALIZING) == Stage.Status.ENDED;
    }

    private void tickFocus(int currentTick) {
        //Setup. Is fired once
        if(this.stageStatus.get(Stage.FOCUS) == Stage.Status.NOT_INITIATED) {
            //Post event to get final Focus time
            PlayerFocusEvent event = new PlayerFocusEvent(this.subject, this.source, this.targetFocusTicks);
            MinecraftForge.EVENT_BUS.post(event);
            //Whenever the player is fauxed, animations will finish but will fizzle out before actual shift-stage
            this.fauxCancel = event.fauxCancel;
            if(event.isCanceled() && !this.fauxCancel) {
                this.abortRift();
                return;
            } else
                this.targetShiftTicks = event.departureTime;

            //This event is in progress as soon as the first tick fires and is initiated.
            this.stageStatus.put(Stage.FOCUS, Stage.Status.IN_PROGRESS);
        }

        //Check if player has moved
        if(this.hasPlayerMoved() || this.hasPlayerLostFocus() || this.hasEntityBeenHurt() || this.exitRift.hasBeenAttacked())
            this.abortRift();

        //TODO tell players client to animate Focus.

        if(currentTick >= targetFocusTicks) {
            //Spawn DepartingRift
            this.departingRift.worldObj.spawnEntityInWorld(departingRift);
            this.stageStatus.put(Stage.FOCUS, Stage.Status.ENDED);
            //Shift will only happen when Focus is done.
            this.stageStatus.put(Stage.SHIFTED, Stage.Status.IN_PROGRESS);
        }
    }

    private void tickShift(int currentTick) {
        //Whenever Status is set on PENDING skip this
        if(this.stageStatus.get(Stage.SHIFTED) == Stage.Status.PENDING) return;

        //Whenever Status is set to NOT_INITIATED setup.
        if(this.stageStatus.get(Stage.SHIFTED) == Stage.Status.NOT_INITIATED) {
            //Post event
            EntityRiftFormationEvent event = new EntityRiftFormationEvent(this.exitRift, this.destination, EntityRift.RiftType.RIFT_SHARD_EXIT);
            MinecraftForge.EVENT_BUS.post(event);
            this.destination = event.location;
            //Update exit position of exit Rift
            this.exitRift.updateLocation(this.destination);
            //Spawn exit
            this.exitRift.worldObj.spawnEntityInWorld(this.exitRift);

            this.stageStatus.put(Stage.SHIFTED, Stage.Status.PENDING);
        } else if (this.stageStatus.get(Stage.SHIFTED) == Stage.Status.IN_PROGRESS) {
            //Check if either entity has been hurt
            if (this.exitRift.hasBeenAttacked() || this.departingRift.hasBeenAttacked()) {
                this.abortRift();
                return;
            }

            //TODO tell player client to animate shift

            if(currentTick >= this.targetFocusTicks + this.targetShiftTicks) {
                this.stageStatus.put(Stage.SHIFTED, Stage.Status.ENDED);
                this.stageStatus.put(Stage.FINALIZING, Stage.Status.IN_PROGRESS);
            }
        }
    }

    private void tickFinalization(int currentTick) {
        //Whenever Status is set to NOT_INITIATED setup.
        if(this.stageStatus.get(Stage.FINALIZING) == Stage.Status.NOT_INITIATED) {
            //This stage will probably not have an init phase.
            this.stageStatus.put(Stage.FINALIZING, Stage.Status.PENDING);
        } else if (this.stageStatus.get(Stage.FINALIZING) == Stage.Status.IN_PROGRESS) {

            LocationHelper.teleportEntity(this.subject, this.destination);

            //TODO animate arrival of player.
            this.exitRift.invokeSuccessfulClosing();
            this.departingRift.invokeSuccessfulClosing();

            //Unlike other stages this one will only run once.
            this.stageStatus.put(Stage.FINALIZING, Stage.Status.ENDED);
        }
    }

    private boolean hasPlayerMoved() {
        return new Location(this.subject).equals(this.source);
    }

    private boolean hasPlayerLostFocus() {
        return subject.isUsingItem();
    }

    private boolean hasEntityBeenHurt() {
        //lastAttackerTime() is not initialized and by default 0 when it got never hurt ever since it spawned.
        if (this.subject.getLastAttackerTime() == 0) return false;
        return this.ticksActive <= (this.subject.ticksExisted - this.subject.getLastAttackerTime());
    }

    private void abortRift() {
        this.exitRift.invokeSuddenClosing();

        if(this.stageStatus.get(Stage.SHIFTED) == Stage.Status.IN_PROGRESS) {
            this.departingRift.invokeSuddenClosing();
        }

        //Set everything to ENDED to let the conductor know this Rift will not receive his swings anymore.
        for(Map.Entry<Stage, Stage.Status> stage : this.stageStatus.entrySet())
            stage.setValue(Stage.Status.ENDED);
    }

    public enum Stage {
        FOCUS,              // This is the stadium where the player still is in the world.
                            // Stadium needs to check if the player has moved from its original location.
        SHIFTED,            // Player has left the world to Probability Space. Two Entities are now on the spot where the player
                            // has left and is to enter the world.
                            // Damage done to these entities cancels the rift.
        FINALIZING;         // Player has left Probability Space. No checks needed. Used to invoke deaths of entities.

        public enum Status {
            NOT_INITIATED,  // Fresh from the constructor
            PENDING,        // Is up next, functionality is initiated
            IN_PROGRESS,    // Currently in progress
            ENDED;          // Has passed.
        }
    }
}
