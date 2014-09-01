package nl.scribblon.riftcraft.event.entity;

import net.minecraft.entity.Entity;
import nl.scribblon.riftcraft.event.RiftCraftEvent;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 01-09-14
 *
 * The main event
 */
public abstract class RiftCraftEntityEvent extends RiftCraftEvent{
    public final Entity entity;

    public RiftCraftEntityEvent(Entity entity) {
        this.entity = entity;
    }
}
