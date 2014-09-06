package nl.scribblon.riftcraft.tileentity;

import nl.scribblon.riftcraft.tileentity.multiimpl.TileEntityMultiImpl;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledSlave;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 10-8-2014
 */
public class TileEntityRiftStone extends TileEntityMultiImpl implements IMultiTiledMaster {

    @Override
    public IMultiTiledSlave[] getTileEntitySlaveList() {
        return new IMultiTiledSlave[0];
    }

    @Override
    public boolean isStructureComplete() {
        return false;
    }

    @Override
    public IMultiTiledSlave[] setupStructureAsMaster() {
        return new IMultiTiledSlave[0];
    }

    @Override
    public boolean deconstructStructureAsMaster() {
        return false;
    }

    @Override
    public ILocationRC[] getStructureLocations() {
        return new ILocationRC[0];
    }
}
