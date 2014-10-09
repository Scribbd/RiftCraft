package nl.scribblon.riftcraft.event;

import cpw.mods.fml.common.eventhandler.Event;
import nl.scribblon.riftcraft.event.energy.EnergyEvent;
import nl.scribblon.riftcraft.event.entity.ShardImprintEvent;
import nl.scribblon.riftcraft.event.entity.rift.EntityRiftFormationEvent;
import nl.scribblon.riftcraft.event.entity.rift.EntityRiftTeleportEvent;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 *
 * The main main main event that accumulates all other. Does nothing special, your really want to focus down on the subclasses.
 */
public abstract class RiftCraftEvent extends Event {

    public static final EventType TYPE = EventType.DEFAULT;

    public RiftCraftEvent() {
        super();
    }

    //Will probably not work, could easily test everything with instanceOff... Just curious how Java functions with statics and overriden values.
    public EventType getType() {
        return this.TYPE;
    }

    public enum EventType {
        DEFAULT,
        RIFT_FORMATION_EVENT,
        RIFT_TELEPORT_EVENT,
        SHARD_IMPRINT_EVENT,
        ENERGY_REQUEST_EVENT;

        public static EventType valueOf(Event event) {
            if(event instanceof EntityRiftFormationEvent) return RIFT_FORMATION_EVENT;
            if(event instanceof EntityRiftTeleportEvent) return RIFT_TELEPORT_EVENT;
            if(event instanceof ShardImprintEvent) return SHARD_IMPRINT_EVENT;
            if(event instanceof EnergyEvent) return ENERGY_REQUEST_EVENT;
            if(event instanceof RiftCraftEvent) return DEFAULT;

            return null;
        }
    }
}
