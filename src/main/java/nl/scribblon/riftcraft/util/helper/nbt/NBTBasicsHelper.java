package nl.scribblon.riftcraft.util.helper.nbt;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Utility class for NBT data of NBTTagCompounds. Generalized form of NBTtagCompoundHelper.
 * Inspired by https://github.com/pahimar/LetsModReboot/blob/master/src/main/java/com/pahimar/letsmodreboot/utility/NBTHelper.java
 * by Pahimar https://github.com/pahimar
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-8-2014
 */
public final class NBTBasicsHelper {

    //HasKey Test
    public static boolean hasTagKey(NBTTagCompound tagCompound, String keyName) {
        if (tagCompound == null) return false;
        return tagCompound.hasKey(keyName);
    }

    //Removal
    public static boolean removeTag(NBTTagCompound tagCompound, String keyName) {
        if (!hasTagKey(tagCompound, keyName)) return false;
        tagCompound.removeTag(keyName);
        return true;
    }

    // String
    public static String getString(NBTTagCompound tagCompound, String keyName) {
        if (!tagCompound.hasKey(keyName))
            setString(tagCompound, keyName, "");

        return tagCompound.getString(keyName);
    }

    public static void setString(NBTTagCompound tagCompound, String keyName, String keyValue) {
        tagCompound.setString(keyName, keyValue);
    }

    // boolean
    public static boolean getBoolean(NBTTagCompound tagCompound, String keyName) {
        if (!tagCompound.hasKey(keyName))
            setBoolean(tagCompound, keyName, false);

        return tagCompound.getBoolean(keyName);
    }

    public static void setBoolean(NBTTagCompound tagCompound, String keyName, boolean keyValue) {
        tagCompound.setBoolean(keyName, keyValue);
    }

    // byte
    public static byte getByte(NBTTagCompound tagCompound, String keyName) {
        if (!tagCompound.hasKey(keyName))
            setByte(tagCompound, keyName, (byte) 0);

        return tagCompound.getByte(keyName);
    }

    public static void setByte(NBTTagCompound tagCompound, String keyName, byte keyValue) {
        tagCompound.setByte(keyName, keyValue);
    }

    // short
    public static short getShort(NBTTagCompound tagCompound, String keyName) {
        if (!tagCompound.hasKey(keyName))
            setShort(tagCompound, keyName, (short) 0);

        return tagCompound.getShort(keyName);
    }

    public static void setShort(NBTTagCompound tagCompound, String keyName, short keyValue) {
        tagCompound.setShort(keyName, keyValue);
    }

    // int
    public static int getInteger(NBTTagCompound tagCompound, String keyName) {
        if (!tagCompound.hasKey(keyName))
            setInteger(tagCompound, keyName, 0);

        return tagCompound.getInteger(keyName);
    }

    public static void setInteger(NBTTagCompound tagCompound, String keyName, int keyValue) {
        tagCompound.setInteger(keyName, keyValue);
    }

    // long
    public static long getLong(NBTTagCompound tagCompound, String keyName) {
        if (!tagCompound.hasKey(keyName))
            setLong(tagCompound, keyName, 0);

        return tagCompound.getLong(keyName);
    }

    public static void setLong(NBTTagCompound tagCompound, String keyName, long keyValue) {
        tagCompound.setLong(keyName, keyValue);
    }


    // float
    public static float getFloat(NBTTagCompound tagCompound, String keyName) {
        if (!tagCompound.hasKey(keyName))
            setFloat(tagCompound, keyName, 0);

        return tagCompound.getFloat(keyName);
    }

    public static void setFloat(NBTTagCompound tagCompound, String keyName, float keyValue) {
        tagCompound.setFloat(keyName, keyValue);
    }

    // double
    public static double getDouble(NBTTagCompound tagCompound, String keyName) {
        if (!tagCompound.hasKey(keyName))
            setDouble(tagCompound, keyName, 0);

        return tagCompound.getDouble(keyName);
    }

    public static void setDouble(NBTTagCompound tagCompound, String keyName, double keyValue) {
        tagCompound.setDouble(keyName, keyValue);
    }
}
