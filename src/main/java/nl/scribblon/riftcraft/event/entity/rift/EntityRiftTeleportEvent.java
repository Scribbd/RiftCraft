package nl.scribblon.riftcraft.event.entity.rift;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.Entity;
import nl.scribblon.riftcraft.entity.EntityRift;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 09-08-2014
 *
 * Whenever someone or something enters a rift entity, this event is fired.
 * Whenever canceled the entity will just pass through the rift entity.
 */
@Cancelable
public class EntityRiftTeleportEvent extends EntityRiftEvent {

    public static final EventType type = EventType.RIFT_TELEPORT_EVENT;

    public final EntityRift theOtherSide;
    public final Entity subject;
    public final TeleportType teleportType;

    public EntityRiftTeleportEvent(EntityRift departingRift, EntityRift theOtherSide, Entity subject, TeleportType teleportType) {
        super(departingRift);
        this.theOtherSide = theOtherSide;
        this.subject = subject;
        this.teleportType = teleportType;
    }

    /**
     * Defines what kind of teleport is invoked
     */
    public static enum TeleportType {
        DEFAULT, // All the teleports that use rift-shards, rift-crystals. The one way connections
        NATURAL, // Sometimes a natural rift can have a destination... But where?
        STABILIZED, // All teleports that use a stabilized rift. RiftWell or two way connections...
        VOID; // You really don't wanna go there.
    }
}
