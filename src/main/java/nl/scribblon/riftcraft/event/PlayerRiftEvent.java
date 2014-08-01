package nl.scribblon.riftcraft.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 */
@Cancelable
public class PlayerRiftEvent extends PlayerEvent{
    public PlayerRiftEvent(EntityPlayer player) {
        super(player);
    }
}
