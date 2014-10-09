package nl.scribblon.riftcraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import nl.scribblon.riftcraft.event.RiftCraftEvent;
import nl.scribblon.riftcraft.event.entity.ShardImprintEvent;
import nl.scribblon.riftcraft.event.entity.rift.EntityRiftFormationEvent;
import nl.scribblon.riftcraft.reference.Settings;
import nl.scribblon.riftcraft.tileentity.multiimpl.TileEntityMultiMasterSlaveImpl;
import nl.scribblon.riftcraft.util.IRiftConductable;
import nl.scribblon.riftcraft.util.ISubscribable;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.RelativeLocation;
import nl.scribblon.riftcraft.util.helper.LocationHelper;
import nl.scribblon.riftcraft.util.helper.nbt.NBTBasicsHelper;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledSlave;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeStructure;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 10-8-2014
 *
 * TileEntity for RiftStone Blocks
 * Listens to RiftFormationEvent and ShardImprintEvent
 */
public class TileEntityRiftStone extends TileEntityMultiMasterSlaveImpl implements IRiftConductable, ISubscribable {

    public static final String TICK_TAG = "rcTicksActive";

    private int ticks;

    public TileEntityRiftStone() {
        super();
        this.ticks = 0;
    }

    /*_*********************************************************************************************************
     * NBT Stuff
     */
    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        NBTBasicsHelper.setInteger(nbtTagCompound, this.TICK_TAG, this.ticks);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        this.ticks = NBTBasicsHelper.getInteger(nbtTagCompound, this.TICK_TAG);
    }

    @Override
    public boolean receiveMultiTileUpdateFromMaster(IMultiTiledMaster master) {
        return false;
    }

    @Override
    protected NBTTagCompound purgeNBTTagCompound(NBTTagCompound nbtTagCompound) {
        super.purgeNBTTagCompound(nbtTagCompound);
        NBTBasicsHelper.removeTag(nbtTagCompound, this.TICK_TAG);
        return nbtTagCompound;
    }

    /*_*********************************************************************************************************
     * Events
     */
    @Override
    public boolean receiveConductorTick(int tick) {
        this.ticks += tick;
        return ticks >= Settings.Stones.defaultStableTime || this.isInMultiStructure();
    }

    @Override
    public void onEvent(RiftCraftEvent riftCraftEvent) {
        // On a ShardImprint Event
        if (riftCraftEvent.getType() == ShardImprintEvent.TYPE) {
            ShardImprintEvent imprintEvent = (ShardImprintEvent) riftCraftEvent;
            RelativeLocation relativeLocation = new RelativeLocation(new Location(imprintEvent.entity), getLocation());

            if (this.isInMultiStructure() && this.isMaster()) {
                // Whenever this tile is part of a multiblock and not a slave apply the structure's bonuses

            } else {
                if (this.isStable() && !relativeLocation.isInterDimensional() && LocationHelper.isOnTop(relativeLocation)) {
                    // Whenever this stone is stable, the location isn't interdimensional and the player is on top of this block: Apply bonus.
                    imprintEvent.resultingDuration /= 2;
                }
            }

        // On a EntityRiftFormation Event the resulting location may be influenced.
        } else if (riftCraftEvent.getType() == EntityRiftFormationEvent.TYPE) {
            EntityRiftFormationEvent riftFormationEvent = (EntityRiftFormationEvent) riftCraftEvent;

        }
    }

    /*_*********************************************************************************************************
     * MasterBlock
     */
    @Override
    public IMultiTiledSlave[] getTileEntitySlaveList() {
        return new IMultiTiledSlave[0];
    }

    @Override
    public IRelativeStructure.StructureType isStructureComplete() {
        return null;
    }

    @Override
    public void setupStructureAsMaster() {

    }


    @Override
    public boolean deconstructStructureAsMaster() {
        return false;
    }

    @Override
    public ILocationRC[] getStructureLocations() {
        return new ILocationRC[0];
    }

    private boolean isStable() {
        return this.ticks >= Settings.Stones.defaultStableTime || this.isInMultiStructure();
    }
}
