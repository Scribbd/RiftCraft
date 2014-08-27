package nl.scribblon.riftcraft.item.shard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Peter on 25-08-14.
 */
public class ItemFocusedRiftShard extends RCItem {

    // Default reference stuff
    public static final int MAX_STACK_SIZE = 1;

    public ItemFocusedRiftShard() {
        super();
        this.setMaxStackSize(MAX_STACK_SIZE);
        this.setUnlocalizedName(Names.Items.FOCUSED_RIFT_SHARD);
    }

    /*
     * When player right clicks item it will start focusing.
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if(!entityPlayer.capabilities.isCreativeMode)
            --itemStack.stackSize;

        return itemStack;
    }

    /*
     * When player keeps still the rift will stabilize. Visuals will happen etc etc.
     */
    @Override
    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {

    }

    /*
     * When player stops rifting before it completes. Handle it here.
     */
    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int p_77615_4_) {

    }
}
