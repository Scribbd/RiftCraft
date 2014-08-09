package nl.scribblon.riftcraft.util;

import net.minecraft.dispenser.ILocation;
import net.minecraft.world.World;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 */
public class Location implements ILocation{
    private World world;
    private double x,y,z;

    public Location(World world, double x, double y, double z){
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public double getZ() {
        return this.z;
    }

    public int getIntX() {
        return (int) Math.floor(x);
    }

    public int getIntY() {
        return (int) Math.floor(y);
    }

    public int getIntZ() {
        return (int) Math.floor(z);
    }

}
