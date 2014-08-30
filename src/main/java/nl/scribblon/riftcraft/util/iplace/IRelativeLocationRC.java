package nl.scribblon.riftcraft.util.iplace;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 28-8-2014
 */
public interface IRelativeLocationRC {

    /**
     * This is the amount of fields expected to be in an implementation.
     * Used in NBTHelpers
     */
    int FIELD_COUNT = 4; //TODO could go for "getClass().getDeclaredFields().length;" ?

    /*_*********************************************************************************************************
     * Normal getters
     */
    double getXShift();

    double getYShift();

    double getZShift();

    int getIntXShift();

    int getIntYShift();

    int getIntZShift();

    boolean isInterDimensional();

    /*_*********************************************************************************************************
     * Relative functions
     */
    double getShiftedXTo(ILocationRC location);

    double getShiftedYTo(ILocationRC location);

    double getShiftedZTo(ILocationRC location);

    int getShiftedIntXTo(ILocationRC location);

    int getShiftedIntYTo(ILocationRC location);

    int getShiftedIntZTo(ILocationRC location);

    ILocationRC getILocationRelativelyFrom(ILocationRC location);

    Block getBlockRelativelyFrom(ILocationRC location);

    TileEntity getTileEntityRelativelyFrom(ILocationRC location);

    /*_*********************************************************************************************************
     * Vector functions
     * Realized these are just vectors
     */
    IRelativeLocationRC getInverse();

    IRelativeLocationRC sum(IRelativeLocationRC relativeLocation);

    IRelativeLocationRC subtract(IRelativeLocationRC relativeLocation);
}
