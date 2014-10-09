package nl.scribblon.riftcraft.util.istructure;

import nl.scribblon.riftcraft.util.RelativeStructureBlock;

import java.util.Set;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-08-14
 */
public interface IRelativeStructure {

    /*_*********************************************************************************************************
     * Functions to determine if a location is fit for use
     */
    boolean structureSupportsMaster(IStructureTileMaster master);

    boolean isStructureCorrectFrom(IStructureTileMaster master);

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
        NONE(1), //When no structure is active.
        QUARTZ_RING (8), //Per Level
        ENERGY_DESTABILIZER(5),
        RIFT_STONE_WELL(9),
        DISRUPT_STONE_WELL(9),
        RIFT_WELL (12),
        DISRUPT_WELL (12);

        public static final String STRUCTURE_TYPE_TAG = "multiEntityType";

        private int arraySize;

        private StructureType(int arraySize){
            this.arraySize = arraySize;
        }

        public int getArraySize(){
            return arraySize;
        }
    }
}
