package nl.scribblon.riftcraft.handler;

import com.google.common.eventbus.Subscribe;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import nl.scribblon.riftcraft.init.ModItems;

/**
 * Created by Peter on 09-08-14.
 */
public class EnderShardHandler {

    @Subscribe
    public void onItemExpiration(ItemExpireEvent event){
        //Standard remote checks
        if(event.entity.worldObj.isRemote) return;
        //check if this concerns EnderShard
        if(!event.entityItem.getEntityItem().getItem().getUnlocalizedName().equals(ModItems.enderShard)) return;

        event.entity.worldObj.spawnParticle("smoke", event.entity.posX, event.entity.posY, event.entity.posZ, 0.0D, 0.0D, 0.0D);
        event.entity.worldObj.spawnEntityInWorld(createShardEntity(event.entity.worldObj, event.entityItem));
    }

    private EntityItem createShardEntity(World world, EntityItem entityItem){
        return new EntityItem(world, entityItem.posX, entityItem.posY, entityItem.posZ, new ItemStack(ModItems.riftShard, entityItem.getEntityItem().stackSize));
    }

}
