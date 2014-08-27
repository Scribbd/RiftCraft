package nl.scribblon.riftcraft.util.imulti;

import java.util.List;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 */
public interface IMultiTiledMaster extends IMultiTiled {

    MultiEntityType DEFAULT_TYPE = MultiEntityType.UNSET;

    /**
     * Forces implementations to have a list of its slaves.
     * @return A list of IMultiTiledSlave implementations
     */
    public List<IMultiTiledSlave> getSlaveList();

    /**
     * A check to see if structure is ready to be constructed.
     * @return true if structure is ready to be constructed, false if not.
     */
    public boolean isStructureComplete();

    /**
     * The setup implementation.
     * @return The resulting IMultiTiledSlave list that should be saved.
     */
    public List<IMultiTiledSlave> setupStructureAsMaster();

    /**
     * The deconstruct implementation.
     * @return A boolean describing if the overall process was successful.
     */
    public boolean deconstructMultiStructureAsMaster();

    /**
     * This enum is for identifying which multi-block structure is active.
     * One block can be part of different kind of multi tiles. This allows for the potential slave to identify what block it should be using.
     */
    public static enum MultiEntityType {
        UNSET (1),
        RIFT_STONE (8),
        DISRUPT_STONE (8),
        /**
         * This value is per level.
         */
        QUARTZ_RING (8),
        RIFT_WELL (12),
        DISRUPT_WELL (12);

        public static final String MULTI_ENTITY_TYPE_TAG  = "multiEntityType";

        private int arraySize;

        private MultiEntityType(int arraySize){
            this.arraySize = arraySize;
        }

        public int getArraySize(){
            return arraySize;
        }
    }
}
