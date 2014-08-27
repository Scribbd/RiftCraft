package nl.scribblon.riftcraft.event.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.item.ItemEvent;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 30-7-2014
 *
 * Event for when an EntityItem is not picked up, has not expired, but has been destroyed by other means.
 */
public class EntityItemHurtEvent extends ItemEvent {

    public final DamageSource damageSource;
    public final float amount;

    public EntityItemHurtEvent(EntityItem entity, DamageSource damageSource, float amount) {
        super(entity);
        this.damageSource = damageSource;
        this.amount = amount;
    }
}
