package nl.scribblon.riftcraft.event.entity.rift;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.entity.EntityRift;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 09-08-2014
 *
 * The event fired whenever a rift entity is created.
 * The final location will used for the formation of the entity.
 * Whenever canceled the rift entity will not form.
 */
@Cancelable
public class EntityRiftFormationEvent extends EntityRiftEvent {

    public static final EventType type = EventType.RIFT_FORMATION_EVENT;

    public final ILocationRC location;
    public final EntityRift.RiftType riftType;

    public EntityRiftFormationEvent(EntityRift entityRift, ILocationRC location, EntityRift.RiftType riftType) {
        super(entityRift);
        this.location = location;
        this.riftType = riftType;
    }

    public EntityRiftFormationEvent(EntityRift entityRift, World world, double x, double y, double z, EntityRift.RiftType riftType) {
        super(entityRift);
        this.location = new Location(world, x, y, z);
        this.riftType = riftType;
    }

}
