package nl.scribblon.riftcraft.util;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 28-8-2014
 */
public class RelativeLocation implements IRelativeLocationRC {

    public static final RelativeLocation ROOT = new RelativeLocation(0,0,0);

    private boolean isInterDimensional;
    private double x, y, z;

    public RelativeLocation(boolean isInterDimensional, double x, double y, double z) {
        this.isInterDimensional = isInterDimensional;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public RelativeLocation(double x, double y, double z) {
        this(false, x, y, z);
    }

    public RelativeLocation(ILocationRC location1, ILocationRC location2) {
        this.isInterDimensional = location1.getDimensionID() == location2.getDimensionID();
        this.x = location2.getX() - location1.getX();
        this.y = location2.getY() - location1.getY();
        this.z = location2.getZ() - location1.getZ();
    }

    /*_*********************************************************************************************************
     * Vector Functions
     */
    @Override
    public IRelativeLocationRC getInverse() {
        return new RelativeLocation(this.isInterDimensional, -this.x, -this.y, -this.z);
    }

    @Override
    public IRelativeLocationRC sum(IRelativeLocationRC relativeLocation) {
        return new RelativeLocation(
                this.x + relativeLocation.getXShift(),
                this.y + relativeLocation.getYShift(),
                this.z + relativeLocation.getZShift());
    }

    @Override
    public IRelativeLocationRC subtract(IRelativeLocationRC relativeLocation){
        return new RelativeLocation(
                this.x - relativeLocation.getXShift(),
                this.y - relativeLocation.getYShift(),
                this.z - relativeLocation.getZShift()
        );
    }

    /*_*********************************************************************************************************
     * Literal getters of various kinds
     */
    @Override
    public double getXShift() {
        return this.x;
    }

    @Override
    public double getYShift() {
        return this.y;
    }

    @Override
    public double getZShift() {
        return this.z;
    }

    @Override
    public int getIntXShift() {
        return (int) Math.floor(this.x);
    }

    @Override
    public int getIntYShift() {
        return (int) Math.floor(this.y);
    }

    @Override
    public int getIntZShift() {
        return (int) Math.floor(this.z);
    }

    @Override
    public boolean isInterDimensional() {
        return this.isInterDimensional;
    }

    /*_*********************************************************************************************************
     * Relative getters of various kinds
     */
    @Override
    public double getShiftedXTo(ILocationRC location) {
        return location.getX() + this.x;
    }

    @Override
    public double getShiftedYTo(ILocationRC location) {
        return location.getY() + this.y;
    }

    @Override
    public double getShiftedZTo(ILocationRC location) {
        return location.getZ() + this.z;
    }

    @Override
    public int getShiftedIntXTo(ILocationRC location) {
        return (int) this.getShiftedXTo(location);
    }

    @Override
    public int getShiftedIntYTo(ILocationRC location) {
        return (int) this.getShiftedYTo(location);
    }

    @Override
    public int getShiftedIntZTo(ILocationRC location) {
        return (int) this.getShiftedZTo(location);
    }

    @Override
    public ILocationRC getRelativeILocationFrom(ILocationRC location) {
        return new Location(location.getWorld(), this.getShiftedXTo(location), this.getShiftedYTo(location), this.getShiftedZTo(location));
    }

    @Override
    public Block getBlockRelativeTo(ILocationRC location) {
        return this.getRelativeILocationFrom(location).getBlockAtLocation();
    }

    @Override
    public TileEntity getTileEntityRelativeTo(ILocationRC location) {
        return this.getRelativeILocationFrom(location).getTileEntityAtLocation();
    }

    /*_*********************************************************************************************************
     * Auto-Generated things
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelativeLocation)) return false;

        RelativeLocation that = (RelativeLocation) o;

        if (isInterDimensional != that.isInterDimensional) return false;
        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;
        if (Double.compare(that.z, z) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (isInterDimensional ? 1 : 0);
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32)); //I don't understand this... -_-'
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32)); //I know these are bit shifts basically applying *2 to the value
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32)); //But the '^' part and the need to do this... I don't...
        return result;
    }
}
