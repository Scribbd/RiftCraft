package nl.scribblon.riftcraft.item.shard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.item.RCItem;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 */
public abstract class Shard extends RCItem {

    protected float throwStrength;

    public Shard(){
        super();
        this.throwStrength = 1.0F;
        this.setMaxStackSize(32);
    }

    public ItemStack onRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        //Whenever player is sneaking the change throw Strength
        if(entityPlayer.isSneaking()){
            this.throwStrength = throwStrength - 0.1F <= 0.1 ? throwStrength : throwStrength - 0.1F;
            return itemStack;
        }

        if(entityPlayer.capabilities.isCreativeMode){
            return itemStack;
        } else {
            --itemStack.stackSize;
            world.playSoundAtEntity(entityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if(!world.isRemote){
                world.spawnEntityInWorld(this.getEntityType(world, entityPlayer));
            }

            return itemStack;
        }
    }

    public ItemStack onLeftClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        //Whenever player is sneaking the change throw Strength
        if(entityPlayer.isSneaking()){
            this.throwStrength = throwStrength + 0.1F >= 1.5F ? throwStrength : throwStrength + 0.1F;
        }

        return itemStack;
    }

    abstract public Entity getEntityType(World word, EntityPlayer player);
}
