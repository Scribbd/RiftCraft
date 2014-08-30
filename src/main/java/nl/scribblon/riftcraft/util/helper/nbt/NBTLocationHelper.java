package nl.scribblon.riftcraft.util.helper.nbt;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.helper.LogHelper;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Utility class for writing a location to NBT-Data.
 *
 * Created by Scribblon for RiftCraft.
 * Date Creation: 24-08-14
 */
final public class NBTLocationHelper {

    public static final String WORLD_TAG_POSTFIX = "worldDimensionID";

    public static final String X_TAG_POSTFIX = "LocationX";
    public static final String Y_TAG_POSTFIX = "LocationY";
    public static final String Z_TAG_POSTFIX = "LocationZ";

    /**
     * Writes a ILocationRC implementation to a NBT-Compound of four tags.
     *  - Integer with the dimensionID of the world (prefix + WORLD_TAG_POSTFIX)
     *  - Double with the X-Position (prefix + X_TAG_POSTFIX)
     *  - Double with the Y-Position (prefix + Y_TAG_POSTFIX)
     *  - Double with the Z-Position (prefix + Z_TAG_POSTFIX)
     *  The presence of the dimensionID is used as identifier if dimension is present.
     * @param nbtTagCompound
     * @param location
     * @param prefix
     * @return
     */
    public static NBTTagCompound writeLocationNBT(NBTTagCompound nbtTagCompound, ILocationRC location, String prefix){
        //TODO should check if dimensionID is the best way of doing this.
        nbtTagCompound.setInteger(prefix + WORLD_TAG_POSTFIX, location.getDimensionID());

        nbtTagCompound.setDouble(prefix + X_TAG_POSTFIX, location.getX());
        nbtTagCompound.setDouble(prefix + Y_TAG_POSTFIX, location.getY());
        nbtTagCompound.setDouble(prefix + Z_TAG_POSTFIX, location.getZ());
        return nbtTagCompound;
    }

    /**
     * Reads the following NBTTags and makes a LocationRC of it. Which can be used further to extract block or tileEntity.
     *  - Integer with the dimensionID of the world (prefix + WORLD_TAG_POSTFIX)
     *  - Double with the X-Position (prefix + X_TAG_POSTFIX)
     *  - Double with the Y-Position (prefix + Y_TAG_POSTFIX)
     *  - Double with the Z-Position (prefix + Z_TAG_POSTFIX)
     *  The presence of the dimensionID is used as identifier if dimens
     * @param nbtTagCompound
     * @param prefix
     * @return
     */
    public static Location readLocationNBT(NBTTagCompound nbtTagCompound, String prefix){
        if (NBTBasicsHelper.hasTagKey(nbtTagCompound, prefix + WORLD_TAG_POSTFIX)) return Location.INVALID_LOCATION;

        //TODO is World a superclass of WorldServer?
        World world = DimensionManager.getWorld(nbtTagCompound.getInteger(prefix + WORLD_TAG_POSTFIX));

        double x = nbtTagCompound.getDouble(prefix + X_TAG_POSTFIX);
        double y = nbtTagCompound.getDouble(prefix + Y_TAG_POSTFIX);
        double z = nbtTagCompound.getDouble(prefix + Z_TAG_POSTFIX);

        return new Location(world, x, y, z);
    }

    /**
     * Removes tags related to this Helper-Class
     * @param nbtTagCompound
     * @param prefix
     * @return
     */
    public static boolean removeLocationNBT(NBTTagCompound nbtTagCompound, String prefix) {
        boolean success = true;

        success &= NBTBasicsHelper.removeTag(nbtTagCompound, prefix + WORLD_TAG_POSTFIX);
        success &= NBTBasicsHelper.removeTag(nbtTagCompound, prefix + X_TAG_POSTFIX);
        success &= NBTBasicsHelper.removeTag(nbtTagCompound, prefix + Y_TAG_POSTFIX);
        success &= NBTBasicsHelper.removeTag(nbtTagCompound, prefix + Z_TAG_POSTFIX);

        if(!success)
            LogHelper.error("LocationHelper was asked to remove a location though none was present in " + nbtTagCompound + " with prefix " + prefix);

        return  success;
    }
}
