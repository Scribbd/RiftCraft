package nl.scribblon.riftcraft.util;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 6-9-2014
 */
public interface IRiftConductable {

    /**
     * Updates ticksActive with the given tick amount
     * @param tick amount of ticks
     * @return if the target has been reached
     */
     boolean receiveConductorTick(int tick);
}
