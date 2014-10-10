package nl.scribblon.riftcraft.util;

import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;
import nl.scribblon.riftcraft.util.istructure.IStructure;

import java.util.TreeSet;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 07-09-14
 *
 * A substructure is basically a container class for interesting locations in a structure. Uses IRelativeLocationRC instead
 * of SubstructureBlocks.
 * This way you can check up on different parts of a larger structure without needing to iterate through the whole list.
 */
public class RelativeSubStructure {

    private IStructure masterStructure;
    private SubType type;
    private TreeSet<IRelativeLocationRC> subLocations;

    public RelativeSubStructure(SubType type, IStructure masterStructure, IRelativeLocationRC... relativeLocations) {
        this.type = type;
        this.masterStructure = masterStructure;

        this.subLocations = new TreeSet<IRelativeLocationRC>();
        for (IRelativeLocationRC relativeLocation : relativeLocations) {
            this.subLocations.add(relativeLocation);
        }
    }

    public SubType getType() {
        return type;
    }

    public IStructure getMasterStructure() {
        return masterStructure;
    }

    public TreeSet<IRelativeLocationRC> getSubLocations() {
        return subLocations;
    }

    public static enum SubType {
        NORMAL, //Can be anything
        MODIFIER, //Locations are modify the behaviour of the master structure.
        BLOCK, //All locations are blocks.
        TILE_ENTITY, //All locations are TileEntities. Still caution advised assuming.
        ADD_ON, //All locations are part of an add-on.
        SPECIAL; //All locations are Special. Not part of the original structure. More an Addition.
    }
}
