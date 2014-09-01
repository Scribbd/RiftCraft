package nl.scribblon.riftcraft.event.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import nl.scribblon.riftcraft.event.entity.RiftCraftEntityEvent;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 30-8-2014
 *
 * The main event surround the player interaction with this mod
 */
public abstract class RiftPlayerEvent extends RiftCraftEntityEvent {

    public final EntityPlayer player;

    public RiftPlayerEvent(EntityPlayer player){
        super(player);
        this.player = player;
    }
}
