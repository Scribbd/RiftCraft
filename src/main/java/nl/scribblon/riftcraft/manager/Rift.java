package nl.scribblon.riftcraft.manager;

import net.minecraft.entity.Entity;
import nl.scribblon.riftcraft.entity.EntityRift;
import nl.scribblon.riftcraft.util.IRiftConductable;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 05-09-14
 *
 * An active rift (aka teleport). A rift contains a source, destination, subject and a few other do-dats.
 * Not to be confused with the EntityRift which is the entity in the world.
 * Meta-class it doesn't really fit in any kind of package at the moment.
 * But basically it is a tickHandler
 */
public class Rift implements IRiftConductable {

    private EntityRift rift;

    private EnumMap<Stage, Stage.Status> stageStatus;

    private Entity subject;
    private ILocationRC source;
    private ILocationRC destination;

    private int ticksActive;
    private int targetTicks;

    private Rift(){
        this.ticksActive = 0;
        this.stageStatus = new EnumMap<Stage, Stage.Status>(Rift.Stage.class);
        for(Map.Entry<Stage, Stage.Status> entry : stageStatus.entrySet()) {
            entry.setValue(Stage.Status.NOT_INITIATED);
        }
    }

    public Rift (EntityRift rift, Entity subject, ILocationRC source, ILocationRC destination, int targetTicks) {
        this();

        this.rift = rift;
        this.subject = subject;
        this.source = source;
        this.destination = destination;
        this.targetTicks = targetTicks;
    }

    public Rift (EntityRift rift, Entity subject, ILocationRC source, IRelativeLocationRC relativeLocation, int targetTicks) {
        this();

        this.rift = rift;
        this.subject = subject;
        this.source = source;
        this.destination = relativeLocation.getILocationRelativelyFrom(source);
        this.targetTicks = targetTicks;
    }


    @Override
    public boolean receiveConductorTick(int tick) {
        ticksActive += tick;

        //TODO implement this shit -_-'







        return ticksActive >= targetTicks;
    }

    public boolean spawnExitEntity() {
        return false;
    }

    public boolean spawnEntranceEntity(){
        return false;
    }

    private boolean hasPlayerMoved() {
        return false;
    }

    public enum Stage {
        FOCUS,
        SHIFTED,
        FINALIZING;

        public enum Status {
            NOT_INITIATED,
            IN_PROGRESS,
            ENDED;
        }
    }
}
