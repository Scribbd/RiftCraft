package nl.scribblon.riftcraft.block.quartz;

import net.minecraft.block.BlockQuartz;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.init.RCModBlocks;
import nl.scribblon.riftcraft.reference.Names;

import java.util.Random;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 *
 * The initial state of a Quartz block when converted to the RiftCraft kind.
 * This block will be replace the normal quartz when placed inside a certain structure.
 * The player must hit it with something glittering to fully unlock its potential.
 */
public class BlockDormantQuartz extends BlockQuartz{

    public BlockDormantQuartz(){
        super();
        this.setCreativeTab(null);
        this.setBlockName(Names.Blocks.DORMANT_QUARTZ);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer,
                                    int side, float hitX, float hitY, float hitZ) {
        //Standard check
        if(entityPlayer == null) return false;
        if(world.isRemote) return false;
        //Check if Something Glittering is used
        if(!entityPlayer.getHeldItem().getItem().getUnlocalizedName().contains(Names.SOMETHING_GLITTERING)) return false;

        //Whenever dust is used, the player just throws the pile on the item and will be consumed.
        if(entityPlayer.getHeldItem().getItem().getUnlocalizedName().equals(Names.Items.GLITTERING_DUST)) {
            --entityPlayer.getHeldItem().stackSize;
        }

        //Whenever the orb or tool is used, the player just rubs it enough to activate, thus losing durability.
        if(entityPlayer.getHeldItem().getItem().getUnlocalizedName().equals(Names.Items.GLITTERING_WRENCH)
                || entityPlayer.getHeldItem().getItem().getUnlocalizedName().equals(Names.Items.GLITTERING_ORB)) {
            entityPlayer.getHeldItem().damageItem(1, entityPlayer);
        }

        //TODO Particles!.

        world.setBlock(x, y, z, RCModBlocks.activatedQuartz);

        return false;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(Blocks.quartz_block);
    }
}
