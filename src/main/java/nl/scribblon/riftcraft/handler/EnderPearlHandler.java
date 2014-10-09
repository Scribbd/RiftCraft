package nl.scribblon.riftcraft.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import nl.scribblon.riftcraft.entity.RCEntityItem;
import nl.scribblon.riftcraft.event.item.EntityItemDeathEvent;
import nl.scribblon.riftcraft.init.RCModItems;
import nl.scribblon.riftcraft.util.helper.LogHelper;
import nl.scribblon.riftcraft.util.helper.RandomHelper;

/**f
 * Created by Scribblon for RiftCraft.
 * Date Creation: 31-7-2014
 * More ore less the crafting mechanic for EnderShards. A multi-block will also be added to simplify things, but that is also a 'carfting by world-interaction'- thingy
 */
public class EnderPearlHandler {

    //TODO extract to reference (?)
    public static final double EXPLOSION_FIRST_CHANCE = 80.0; //percent chance on one shard by explosion
    public static final double EXPLOSION_SECOND_CHANCE = 33.0; //percent chance on two shards by explosion
    public static final double EXPLOSION_THIRD_CHANCE = 10.0; //percent chance on three shards by explosion
    public static final double EXPLOSION_FOURTH_CHANCE = 1.0; //percent chance on fourth shard by explosion

    public static final double MULTI1_FIRST_CHANCE = 100.0; //percent chance on one shard by 1 layered multi-block
    public static final double MULTI1_SECOND_CHANCE = 70.0; //percent chance on two shards by 1 layered multi-block
    public static final double MULTI1_THIRD_CHANCE = 25.0; //percent chance on three shards by 1 layered multi-block
    public static final double MULTI1_FOURTH_CHANCE = 5.0; //percent chance on fourth shard by 1 layered multi-block

    public static final double MULTI2_FIRST_CHANCE = 100.0; //percent chance on one shard by 2 layered multi-block
    public static final double MULTI2_SECOND_CHANCE = 90.0; //percent chance on two shards by 2 layered multi-block
    public static final double MULTI2_THIRD_CHANCE = 50.0; //percent chance on three shards by 2 layered multi-block
    public static final double MULTI2_FOURTH_CHANCE = 20.0; //percent chance on fourth shard by 2 layered multi-block

    public static final double MULTI3_FIRST_CHANCE = 100.0; //percent chance on one shard by 3 layered multi-block
    public static final double MULTI3_SECOND_CHANCE = 100.0; //percent chance on two shards by 3 layered multi-block
    public static final double MULTI3_THIRD_CHANCE = 75.0; //percent chance on three shards by 3 layered multi-block
    public static final double MULTI3_FOURTH_CHANCE = 45.0; //percent chance on fourth shard by 3 layered multi-block

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event){
        //Simple checks for quick returns, could not be memory friendly.
        if (event.world.isRemote) return;

        if (!(event.entity instanceof EntityItem)) return;

        if (event.entity instanceof RCEntityItem){
            LogHelper.reportWhenDebugging("RCEntityItem just entered the world! " + event.entity);
            return;
        }

        //if (Settings.Debug.isDebugging) LogHelper.info("EntityItemJoinWorldEvent Triggered! " + event.entity);

        //if(event.entity.ticksExisted < 1) return;

        //Process entityItem
        EntityItem entityItem = (EntityItem) event.entity;

        //Again checking if items has been removed since the event triggered.
        if (entityItem.getEntityItem() == null) return;

        //if (Settings.Debug.isDebugging) LogHelper.info("Is this an EnderPearl? " + (entityItem.getEntityItem().getItem().getUnlocalizedName().equals(Items.ender_pearl.getUnlocalizedName())));

        //Check if item in question is an EnderPearl
        if (isEnderPearl(entityItem)){
            RCEntityItem rcEntityItem = RCEntityItem.convert(entityItem);
            event.setCanceled(true);
            event.world.spawnEntityInWorld(rcEntityItem);
        }
    }

    @SubscribeEvent
    public void onItemDeath(EntityItemDeathEvent event){
        LogHelper.reportWhenDebugging("ItemDeath Triggered");

        if (isEnderPearl(event.entityItem) && event.damageSource.isExplosion()){
            //Calculate chances

            int spawnTotal = 0;
            LogHelper.reportWhenDebugging("Stacksize of Exploded stack: " + event.entityItem.getEntityItem().stackSize);
            for(int i = 0; i < event.entityItem.getEntityItem().stackSize; i++) {
                if (RandomHelper.rollD100(EXPLOSION_FIRST_CHANCE)) {
                    ++spawnTotal;
                    if (RandomHelper.rollD100(EXPLOSION_SECOND_CHANCE)) {
                        ++spawnTotal;
                        if (RandomHelper.rollD100(EXPLOSION_THIRD_CHANCE)) {
                            ++spawnTotal;
                            if (RandomHelper.rollD100(EXPLOSION_FOURTH_CHANCE))
                                ++spawnTotal;
                        }
                    }
                }
            }

            LogHelper.reportWhenDebugging("Chances rolled: " + spawnTotal);

            if(spawnTotal > 0){
                event.entity.worldObj.spawnEntityInWorld(createShardEntity(event.entity.worldObj, event.entity, spawnTotal));
            }
        }
    }

    private boolean isEnderPearl(EntityItem entityItem){
        return entityItem.getEntityItem().getItem().getUnlocalizedName().equals(Items.ender_pearl.getUnlocalizedName());
    }

    private EntityItem createShardEntity(World world, Entity entity, int amount){
        return new EntityItem(world, entity.posX, entity.posY, entity.posZ, new ItemStack(RCModItems.endericShard, amount));
    }

}
