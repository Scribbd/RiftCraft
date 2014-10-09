package nl.scribblon.riftcraft.util.istructure;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 */
public interface IStructureTileSlave extends IStructureTile {

    /**
     * This method is to allow slaves of multi-entity structures to update their own status. Whenever the structure is used.
     * @param master the master block should be given to the slaves. This way the slave can decide how to behave on the type of block it is.
     * @return boolean, true when update could be made and structure is still able to continue operating. False if it can't.
     */
    boolean receiveMultiTileUpdateFromMaster(IStructureTileMaster master);

    /**
     * Checks if the entity, in its current condition, can be part of the multi-entity structure.
     * @param master should be given to the potential slave, to decide on the type of master if it can be part of the structure.
     * @return boolean, true if it can be part of the structure. False if it can't.
     */
    boolean canConstructAsSlave(IStructureTileMaster master);

    /**
     * Constructs the IMultiTiledSlave implementation. Allows to set values, for the slave.
     * @param master allows the new slave to determine what values to set to the type of multi-entity structure it will be part off.
     * @return Should be the implementation itself (this) to keep it recorded in the master block.
     */
    IStructureTileSlave setupAsSlave(IStructureTileMaster master);

    /**
     * Deconstructs the IMultiTiledSlave implementation. Allows to set values for the slaves.
     * @param master
     * @return
     */
    boolean deconstructAsSlave(IStructureTileMaster master);
}
