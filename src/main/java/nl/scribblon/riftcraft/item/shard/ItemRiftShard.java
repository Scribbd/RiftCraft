package nl.scribblon.riftcraft.item.shard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class ItemRiftShard extends RCItem {

    public static final int MAX_STACK_SIZE = 32;

    public ItemRiftShard(){
        super();
        this.setUnlocalizedName(Names.Items.RIFT_SHARD);
        this.setMaxStackSize(MAX_STACK_SIZE);
    }

    /*
     * When player is sneaking and holding right click, it will focus the shard.
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if(!entityPlayer.isSneaking()) return itemStack;

        return itemStack;
    }

    /*
     * When player keeps still focus will tick down else it will deconstruct.
     */
    @Override
    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {

    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int p_77615_4_) {

    }
}
