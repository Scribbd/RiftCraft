package nl.scribblon.riftcraft.tileentity.multiimpl;

import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledSlave;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-8-2014
 */
public abstract class TileEntityMultiSlaveImpl extends TileEntityMultiImpl implements IMultiTiledSlave {

    public TileEntityMultiSlaveImpl() {
        super();
    }

    @Override
    public IMultiTiledSlave setupAsSlave(IMultiTiledMaster master) {
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
    public boolean deconstructAsSlave(IMultiTiledMaster master) {

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
