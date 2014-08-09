package nl.scribblon.riftcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockQuartz;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.init.ModBlocks;
import nl.scribblon.riftcraft.reference.Names;

import java.util.Random;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 *
 * Special Quartzblock, only spawns inside the enderCluster multiStructure
 */
public class ActivatedQuartz extends BlockQuartz{

    public ActivatedQuartz(){
        super();
        this.setCreativeTab(null);
        this.setBlockName(Names.Blocks.ACTIVATED_QUARTS);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        //Standard check
        if(entityPlayer == null) return false;
        if(world.isRemote) return false;
        //Check if Glittering Dust is used
        if(!entityPlayer.getHeldItem().getItem().getUnlocalizedName().equals(Names.Items.GLITTERING_DUST)) return false;

        world.setBlock(x,y,z, ModBlocks.activatedQuarts);

        return false;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(Blocks.quartz_block);
    }
}
