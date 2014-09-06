package nl.scribblon.riftcraft.util.iplace;

import nl.scribblon.riftcraft.util.RelativeStructureBlock;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;

import java.util.Set;

/**
 * Created by Peter on 29-08-14.
 */
public interface IRelativeStructure {

    /*_*********************************************************************************************************
     * Functions to determine if a location is fit for use
     */
    boolean structureSupportsMaster(IMultiTiledMaster master);

    boolean isStructureCorrectFrom(IMultiTiledMaster master);

    /*_*********************************************************************************************************
     * Normal (simple) getters
     */
    Set<RelativeStructureBlock> getParts();

    RelativeStructureBlock getRoot();

    StructureType getStructureType();

    /**
     * This enum is for identifying which multi-block structure is active.
     * One block can be part of different kind of multi tiles. This allows for the potential slave to identify what block it should be using.
     */
    enum StructureType {
        UNSET (1), //Default type set.
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

        private StructureType(int arraySize){
            this.arraySize = arraySize;
        }

        public int getArraySize(){
            return arraySize;
        }
    }
}
