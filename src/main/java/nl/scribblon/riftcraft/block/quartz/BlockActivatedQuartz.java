package nl.scribblon.riftcraft.block.quartz;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.block.RCBlock;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.tileentity.TileEntityActivatedQuartz;
import nl.scribblon.riftcraft.util.helper.nbt.NBTItemStackHelper;

import java.util.ArrayList;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 02-09-14
 *
 * This block is whenever vanilla quartz enter the realm of RiftCraft. They suddenly become simple batteries...
 */
public class BlockActivatedQuartz extends RCBlock {

    public BlockActivatedQuartz() {
        super();
        this.setBlockName(Names.Blocks.ACTIVATED_QUARTZ);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityActivatedQuartz();
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        TileEntityActivatedQuartz activatedQuartz = (TileEntityActivatedQuartz) world.getTileEntity(x, y, z);

        ItemStack itemStack = new ItemStack(this);
        //NBTItemStackHelper.setDouble(itemStack, TileEntityActivatedQuartz.STORED_ENERGY_TAG, activatedQuartz.storedEnergy);

        world.spawnEntityInWorld(new EntityItem(world, x, y, z, itemStack));
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if(!NBTItemStackHelper.hasTagKey(itemStack, TileEntityActivatedQuartz.STORED_ENERGY_TAG)) return;

        TileEntityActivatedQuartz activatedQuartz = (TileEntityActivatedQuartz) world.getTileEntity(x, y, z);
        activatedQuartz.storedEnergy = NBTItemStackHelper.getDouble(itemStack, TileEntityActivatedQuartz.STORED_ENERGY_TAG);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        return null;
    }
}
