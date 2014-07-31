package nl.scribblon.riftcraft.handler;


import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import nl.scribblon.riftcraft.event.EntityItemHurtEvent;
import nl.scribblon.riftcraft.util.LogHelper;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class TestHandler {

    @SubscribeEvent
    public void onItemTossEvent(ItemTossEvent event){
        LogHelper.info("Just dropped " + event.entityItem.getEntityItem().getDisplayName());
        LogHelper.info("The itemEntity has " + event.entity.toString());
    }

    @SubscribeEvent
    public void onPlayerHurtsEvent(AttackEntityEvent event){
        LogHelper.info("Player just hurt " + event.target);
    }

    @SubscribeEvent
    public void onEntityHurt(LivingHurtEvent event){
        LogHelper.info("Ouch! " + event.entity.toString() + " got hurt!");
    }

    @SubscribeEvent
    public void onEntityHurt(LivingAttackEvent event){
        LogHelper.info("Help! " + event.entity.toString() + " is attacked!");
    }

    @SubscribeEvent
    public void onEntityHurt(LivingDeathEvent event){
        LogHelper.info("Aw! " + event.entity.toString() + " has died!");
    }

    @SubscribeEvent
    public void onEntityHurt(LivingDropsEvent event){
        LogHelper.info("Oeh! " + event.entity.toString() + " is something shiny!");
    }

    @SubscribeEvent
    public void onItemHurt(EntityItemHurtEvent event){
        LogHelper.info("Wow! " + event.entity + " was hurt by " + event.damageSource + "how is that possible!");
    }

}
