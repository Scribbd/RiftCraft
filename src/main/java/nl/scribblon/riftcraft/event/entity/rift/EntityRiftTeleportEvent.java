package nl.scribblon.riftcraft.event.entity.rift;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.Entity;
import nl.scribblon.riftcraft.entity.EntityRift;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 09-08-2014
 *
 * Whenever someone or something enters a rift entity. This is event is fired.
 * Whenever canceled the entity will just pass through the rift entity.
 */
@Cancelable
public class EntityRiftTeleportEvent extends EntityRiftEvent {

    public final EntityRift theOtherSide;
    public final Entity subject;

    public EntityRiftTeleportEvent(EntityRift departingRift, EntityRift theOtherSide, Entity subject) {
        super(departingRift);
        this.theOtherSide = theOtherSide;
        this.subject = subject;
    }
}
