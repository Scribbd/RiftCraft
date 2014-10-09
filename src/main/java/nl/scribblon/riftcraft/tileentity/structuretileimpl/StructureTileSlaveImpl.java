package nl.scribblon.riftcraft.tileentity.structuretileimpl;

import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.istructure.IStructureTileMaster;
import nl.scribblon.riftcraft.util.istructure.IStructureTileSlave;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-8-2014
 *
 * Implementation of IMultiTiledSlave for blocks which can only be a slave
 */
public abstract class StructureTileSlaveImpl extends StructureTileImpl implements IStructureTileSlave {

    public StructureTileSlaveImpl() {
        super();
    }

    @Override
    public IStructureTileSlave setupAsSlave(IStructureTileMaster master) {
        //set booleans to correct value
        this.isMaster = false;
        this.hasMaster = true;

        //Set masterLocation
        this.masterLocation = master.getLocation();

        //Force write of values
        this.markDirty();

        return this;
    }

    @Override
    public boolean deconstructAsSlave(IStructureTileMaster master) {

        //Reset to default values
        this.isMaster = false;
        this.hasMaster = false;

        //Invalidate Location
        this.masterLocation = Location.INVALID_LOCATION;

        //Force write of values (removal)
        this.markDirty();

        return true;
    }
}
