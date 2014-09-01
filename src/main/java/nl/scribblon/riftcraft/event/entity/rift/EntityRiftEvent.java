package nl.scribblon.riftcraft.event.entity.rift;

import nl.scribblon.riftcraft.entity.EntityRift;
import nl.scribblon.riftcraft.event.entity.RiftCraftEntityEvent;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 09-08-2014
 *
 * The base event which is fired for all rift entities.
 */
public abstract class EntityRiftEvent extends RiftCraftEntityEvent {

    public final EntityRift subject;

    public EntityRiftEvent(EntityRift subject) {
        super(subject);
        this.subject = subject;
    }
}
