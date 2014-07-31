package nl.scribblon.riftcraft.handler;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnderPearl;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.oredict.OreDictionary;
import nl.scribblon.riftcraft.entity.RCEntityItem;
import nl.scribblon.riftcraft.event.EntityItemDeathEvent;
import nl.scribblon.riftcraft.reference.Settings;
import nl.scribblon.riftcraft.util.LogHelper;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 31-7-2014
 */
public class EnderPearlHandler {

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event){
        //Simple checks for quick returns, could not be memory friendly.
        if (event.world.isRemote) return;

        if (!(event.entity instanceof EntityItem)) return;

        if (event.entity instanceof RCEntityItem){
            if(Settings.Debug.isDebugging)
                LogHelper.info("RCEntityItem just entered the world! " + event.entity);
            return;
        }

        if (Settings.Debug.isDebugging)
            LogHelper.info("EntityItemJoinWorldEvent Triggered! " + event.entity);

        if(event.entity.ticksExisted < 1) return;

        //Process entityItem
        EntityItem entityItem = (EntityItem) event.entity;

        //Again checking if items has been removed since the event triggered.
        if (entityItem.getEntityItem() == null) return;

        if (Settings.Debug.isDebugging) {
            LogHelper.info("Is this an EnderPearl? " + (entityItem.getEntityItem().getItem().getUnlocalizedName().equals(Items.ender_pearl.getUnlocalizedName())));
        }

        //Check if item in question is an EnderPearl
        if (entityItem.getEntityItem().getItem().getUnlocalizedName().equals(Items.ender_pearl.getUnlocalizedName())){
            RCEntityItem rcEntityItem = RCEntityItem.convert(entityItem);
            event.world.spawnEntityInWorld(rcEntityItem);
            entityItem.setDead();
        }
    }

    @SubscribeEvent
    public void onItemDeath(EntityItemDeathEvent event){

    }

}
