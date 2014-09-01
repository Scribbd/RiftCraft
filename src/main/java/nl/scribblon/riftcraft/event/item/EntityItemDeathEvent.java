package nl.scribblon.riftcraft.event.item;


import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.item.ItemEvent;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 31-7-2014
 *
 * Event launched whenever an ItemEntityRC dies
 */
public class EntityItemDeathEvent extends ItemEvent{

    public final DamageSource damageSource;

    public EntityItemDeathEvent(EntityItem itemEntity, DamageSource damageSource) {
        super(itemEntity);
        this.damageSource = damageSource;
    }
}
