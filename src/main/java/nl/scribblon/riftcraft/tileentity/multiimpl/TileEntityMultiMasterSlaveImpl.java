package nl.scribblon.riftcraft.tileentity.multiimpl;

import net.minecraft.nbt.NBTTagCompound;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledSlave;

/**
 * For those Tile Entities that could function as both.
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-8-2014
 *
 * Implementation for TileEntities which can be both a master and a slave.
 * (Investigate if I should use Meta-Data instead.)
 */
public abstract class TileEntityMultiMasterSlaveImpl extends TileEntityMultiMasterImpl implements IMultiTiledSlave {

    public TileEntityMultiMasterSlaveImpl() {
        super();
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
    }

    @Override
    public boolean canConstructAsSlave(IMultiTiledMaster master) {
        return !isMaster();
    }

    @Override
    public IMultiTiledSlave setupAsSlave(IMultiTiledMaster master) {
        this.isMaster = false;
        this.hasMaster = true;
        this.masterLocation = master.getLocation();
        return this;
    }

    @Override
    public boolean deconstructAsSlave(IMultiTiledMaster master) {
        this.isMaster = false;
        this.hasMaster = false;
        this.masterLocation = Location.INVALID_LOCATION;

        return true;
    }
}
