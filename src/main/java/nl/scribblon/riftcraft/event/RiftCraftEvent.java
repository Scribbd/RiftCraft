package nl.scribblon.riftcraft.event;

import cpw.mods.fml.common.eventhandler.Event;
import nl.scribblon.riftcraft.event.entity.ShardFocusEvent;
import nl.scribblon.riftcraft.event.entity.rift.EntityRiftFormationEvent;
import nl.scribblon.riftcraft.event.entity.rift.EntityRiftTeleportEvent;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 *
 * The main main main event that accumulates all other. Does nothing special, your really want to focus down on the subclasses.
 */
public abstract class RiftCraftEvent extends Event {

    public static final EventType type = EventType.DEFAULT;

    public RiftCraftEvent() {
        super();
    }

    public enum EventType {
        DEFAULT,
        RIFT_FORMATION_EVENT,
        RIFT_TELEPORT_EVENT,
        SHARD_FOCUS_EVENT;

        public static EventType valueOf(Event event) {
            if(event instanceof EntityRiftFormationEvent) return RIFT_FORMATION_EVENT;
            if(event instanceof EntityRiftTeleportEvent) return RIFT_TELEPORT_EVENT;
            if(event instanceof ShardFocusEvent) return SHARD_FOCUS_EVENT;
            if(event instanceof RiftCraftEvent) return DEFAULT;

            return null;
        }
    }
}
