package nl.scribblon.riftcraft.util.istructure;

import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 */
public interface IStructureTileMaster extends IStructureTile {

    IRelativeStructure.StructureType DEFAULT_TYPE = IRelativeStructure.StructureType.NONE;

    /**
     * Forces implementations to have a list of its slaves.
     * @return A list of IMultiTiledSlave implementations
     */
    IStructureTileSlave[] getTileEntitySlaveList();

    /**
     * A check to see if structure is ready to be constructed.
     * @return the structure type which is valid. IRelativeStructure.StructureType.NONE if none has been found.
     */
    IRelativeStructure.StructureType isStructureComplete();

    /**
     * The setup implementation.
     * @return The resulting IMultiTiledSlave list that should be saved.
     */
    void setupStructureAsMaster();

    /**
     * The deconstruct implementation.
     * @return A boolean describing if the overall process was successful.
     */
    boolean deconstructStructureAsMaster();

    ILocationRC[] getStructureLocations();

}
