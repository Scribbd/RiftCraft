package nl.scribblon.riftcraft.util.helper;

import nl.scribblon.riftcraft.reference.Structures;
import nl.scribblon.riftcraft.util.iplace.IRelativeStructure;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-09-14
 *
 * Helper class for Structure objects
 */
public class StructureHelper {

    public static IRelativeStructure getStructure(IRelativeStructure.StructureType type) {
        switch (type) {
        case NONE:
            return null;
        case QUARTZ_RING:
            return Structures.QUARTZ_RING;
        case ENERGY_DESTABILIZER:
            return Structures.ENERGY_DESTABILIZER;
        case RIFT_STONE_WELL:
            return Structures.RIFT_STONE_WELL;
        case DISRUPT_STONE_WELL:
            return Structures.DISRUPTION_STONE_WELL;
        case RIFT_WELL:
            return Structures.RIFTING_WELL;
        case DISRUPT_WELL:
            return Structures.DISRUPTION_WELL;
        }

        return null;
    }
}
