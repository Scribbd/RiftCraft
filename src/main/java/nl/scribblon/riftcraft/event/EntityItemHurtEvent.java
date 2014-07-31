package nl.scribblon.riftcraft.event;


import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityEvent;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 30-7-2014
 *
 * Event for when an EntityItem is not picked up, has not expired, but has been destroyed by other means.
 */
public class EntityItemHurtEvent extends EntityEvent {

    public final DamageSource damageSource;


    public EntityItemHurtEvent(Entity entity, DamageSource damageSource) {
        super(entity);
        this.damageSource = damageSource;
    }
}
