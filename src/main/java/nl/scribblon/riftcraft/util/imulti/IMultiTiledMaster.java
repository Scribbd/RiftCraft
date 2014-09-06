package nl.scribblon.riftcraft.util.imulti;

import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeStructure;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 */
public interface IMultiTiledMaster extends IMultiTiled {

    IRelativeStructure.StructureType DEFAULT_TYPE = IRelativeStructure.StructureType.UNSET;

    /**
     * Forces implementations to have a list of its slaves.
     * @return A list of IMultiTiledSlave implementations
     */
    IMultiTiledSlave[] getTileEntitySlaveList();

    /**
     * A check to see if structure is ready to be constructed.
     * @return true if structure is ready to be constructed, false if not.
     */
    boolean isStructureComplete();

    /**
     * The setup implementation.
     * @return The resulting IMultiTiledSlave list that should be saved.
     */
    IMultiTiledSlave[] setupStructureAsMaster();

    /**
     * The deconstruct implementation.
     * @return A boolean describing if the overall process was successful.
     */
    boolean deconstructStructureAsMaster();

    ILocationRC[] getStructureLocations();

}
