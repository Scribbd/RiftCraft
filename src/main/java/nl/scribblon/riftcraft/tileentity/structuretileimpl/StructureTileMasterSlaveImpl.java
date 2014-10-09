package nl.scribblon.riftcraft.tileentity.structuretileimpl;

import net.minecraft.nbt.NBTTagCompound;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.istructure.IStructureTileMaster;
import nl.scribblon.riftcraft.util.istructure.IStructureTileSlave;

/**
 * For those Tile Entities that could function as both.
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-8-2014
 *
 * Implementation for TileEntities which can be both a master and a slave.
 * (Investigate if I should use Meta-Data instead.)
 */
public abstract class StructureTileMasterSlaveImpl extends StructureTileMasterImpl implements IStructureTileSlave {

    public StructureTileMasterSlaveImpl() {
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
    public boolean canConstructAsSlave(IStructureTileMaster master) {
        return !isMaster();
    }

    @Override
    public IStructureTileSlave setupAsSlave(IStructureTileMaster master) {
        this.isMaster = false;
        this.hasMaster = true;
        this.masterLocation = master.getLocation();
        return this;
    }

    @Override
    public boolean deconstructAsSlave(IStructureTileMaster master) {
        this.isMaster = false;
        this.hasMaster = false;
        this.masterLocation = Location.INVALID_LOCATION;

        return true;
    }
}
