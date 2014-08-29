package nl.scribblon.riftcraft.util;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 28-8-2014
 */
public interface IRelativeLocationRC {

    /**
     * This is the amount of fields expected to be in an implementation.
     */
    public static final int FIELD_COUNT = 4; //TODO could go for "getClass().getDeclaredFields().length;" ?

    IRelativeLocationRC sum(IRelativeLocationRC relativeLocation);

    IRelativeLocationRC subtract(IRelativeLocationRC relativeLocation);

    /*
         * Shift functions
         */
    public double getXShift();

    public double getYShift();

    public double getZShift();

    public int getIntXShift();

    public int getIntYShift();

    public int getIntZShift();

    public boolean isInterDimensional();

    /*
     * Relative functions
     */
    public double getShiftedXTo(ILocationRC location);

    public double getShiftedYTo(ILocationRC location);

    public double getShiftedZTo(ILocationRC location);

    public int getShiftedIntXTo(ILocationRC location);

    public int getShiftedIntYTo(ILocationRC location);

    public int getShiftedIntZTo(ILocationRC location);

    public ILocationRC getRelativeILocationFrom(ILocationRC location);

    public Block getBlockRelativeTo(ILocationRC location);

    public TileEntity getTileEntityRelativeTo(ILocationRC location);

    /*
     * Vector functions
     * Realized these are just vectors
     */

    public IRelativeLocationRC getInverse();
}
