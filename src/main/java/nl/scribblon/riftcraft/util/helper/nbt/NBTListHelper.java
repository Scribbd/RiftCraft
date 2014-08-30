package nl.scribblon.riftcraft.util.helper.nbt;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.DimensionManager;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for converting lists to arrays usable in NBT-Data.
 *
 * Created by Scribblon for RiftCraft.
 * Date Creation: 24-08-14
 */
final public class NBTListHelper {

    public static final String LOCATION_TAG_POSTFIX = "LocationList";

    /**
     * Writes a list of location in the following format:
     * {loc1DimID, loc1X, loc1Y, loc1Z, loc2DimID, loc2x, loc2y, loc2z, ...}
     *
     * WARNING: will cast doubles to integers.
     * TODO investigate a way to make it accept doubles
     * @param tagCompound
     * @param list Needs to contain ILocation objects
     * @param tagPrefix Used to keep tags unique and distinguishable
     * @return the proveded NBTTagCompound object
     */
    public static NBTTagCompound writeLocationListToNBT(NBTTagCompound tagCompound, List<? extends ILocationRC> list, String tagPrefix) {

        //Chose for a simple array over a List as a reliable index can be calculated.
        int[] locationArray = new int[list.size() * Location.FIELD_COUNT]; //each Location Entry got four elements, world (dimid used), x, y, z,-coordinates.

        //Populate array
        int index = 0;
        for(ILocationRC location : list){
            Location castedLocation = new Location(location);
            locationArray[index++] = location.getWorld().provider.dimensionId;
            locationArray[index++] = castedLocation.getIntX();
            locationArray[index++] = castedLocation.getIntY();
            locationArray[index++] = castedLocation.getIntZ();
        }
        //Set Array
        tagCompound.setIntArray(tagPrefix + LOCATION_TAG_POSTFIX, locationArray);

        //Return for daisy-Chaining.
        return tagCompound;
    }

    /**
     * Reads a list of location coordinates from provided NBTTagCompound.
     *
     * WARNING: Assumes the following format {loc1DimID, loc1X, loc1Y, loc1Z, loc2DimID, loc2x, loc2y, loc2z, ...}
     *
     * TODO build in safety for when this is not present.
     * @param tagCompound
     * @param tagPrefix Used to keep tags unique and distinguishable
     * @return ArrayList of ILocation
     */
    public static List<ILocationRC> readLocationListFromNBT(NBTTagCompound tagCompound, String tagPrefix) {
        //Retrieve array from NBTTagCompound
        int[] locationArray = tagCompound.getIntArray(tagPrefix + LOCATION_TAG_POSTFIX);
        int listLength = (int) Math.floor(locationArray.length / Location.FIELD_COUNT);

        List<ILocationRC> list = new ArrayList<ILocationRC>(listLength); //Chosen for ArrayList as the length can be determined.

        //Populate ArrayList
        int arrayIndex = 0;
        for(int i=0; i<listLength; ++i) {
            list.set(i, new Location(
                    DimensionManager.getWorld(locationArray[arrayIndex++]),
                    locationArray[arrayIndex++],
                    locationArray[arrayIndex++],
                    locationArray[arrayIndex++]));
        }

        return list;
    }

    public static NBTTagCompound removeList(NBTTagCompound tagCompound, String tagPrefix) {
        tagCompound.removeTag(tagPrefix + LOCATION_TAG_POSTFIX);
        return tagCompound;
    }
}
