package nl.scribblon.riftcraft.event.shardfocus;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.player.EntityPlayer;
import nl.scribblon.riftcraft.event.RiftCraftEvent;

/**
 * Created by Peter on 25-08-14.
 *
 * This event is fired when a player is focusing a location into a riftShard.
 * The integer returned are the ticks needed to completely focus the crystal.
 *
 * When canceled, focus will not occur.
 */
@Cancelable
public class ShardFocusEvent extends RiftCraftEvent {

    public double resultingDuration;

    public final EntityPlayer entityPlayer;

    public ShardFocusEvent(EntityPlayer entityPlayer, double baseDuration){
        this.entityPlayer = entityPlayer;
        resultingDuration = baseDuration;
    }
}
