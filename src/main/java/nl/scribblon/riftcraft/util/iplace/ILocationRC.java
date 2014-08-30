package nl.scribblon.riftcraft.util.iplace;

import net.minecraft.block.Block;
import net.minecraft.dispenser.ILocation;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Coen on 26-8-2014.
 * Implements getting the X, Y, Z to integers. Saves me some hassle with casting later on.
 * Also putting in methods for getting blocks and tile entities in here.
 */
public interface ILocationRC extends ILocation {

    /**
     * This is the amount of fields expected to be in an implementation.
     * Used in NBTHelpers
     */
    int FIELD_COUNT = 4; //TODO could go for "getClass().getDeclaredFields().length;" ?

    /*_*********************************************************************************************************
     * Normal getters
     */
    int getIntX();

    int getIntY();

    int getIntZ();

    int getDimensionID();

    Block getBlockAtLocation();

    TileEntity getTileEntityAtLocation();
}
