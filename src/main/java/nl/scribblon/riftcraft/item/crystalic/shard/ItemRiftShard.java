package nl.scribblon.riftcraft.item.crystalic.shard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import nl.scribblon.riftcraft.event.entity.ShardImprintEvent;
import nl.scribblon.riftcraft.init.RCModItems;
import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.reference.Reference;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.helper.LogHelper;
import nl.scribblon.riftcraft.util.helper.nbt.NBTBasicsHelper;
import nl.scribblon.riftcraft.util.helper.nbt.NBTItemStackHelper;
import nl.scribblon.riftcraft.util.helper.nbt.NBTLocationHelper;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 *
 * The normal RiftShard has two functions. Being imprinted, and use providing a small chance on a natural rift.
 */
public class ItemRiftShard extends RCItem {

    public static final String IMPRINT_IN_PROGRESS_TAG = "rcInImprint";
    public static final String IMPRINT_TIME_TAG = "rcImprintTime";
    public static final String FAUX_CANCEL_TAG = "rcFauxImprint";
    public static final String TEMP_STABILITY_TAG = "tmpStability";

    public static final int MAX_STACK_SIZE = 16;

    public ItemRiftShard() {
        super();
        this.setUnlocalizedName(Names.Items.RIFT_SHARD);
        this.setMaxStackSize(MAX_STACK_SIZE);
    }

    /*
     * When player is sneaking and holding right click, it will imprint the shard.
     * Otherwise throw/drop the Rift Shard to get a chance on spawning a natural rift
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if(!entityPlayer.isSneaking()) {
            //TODO throw!
            return reduceItemStack(entityPlayer, itemStack);
        }

        return itemStack;
    }

    /*
     * When player keeps still focus will tick down else it will deconstruct.
     */
    @Override
    public void onUsingTick(ItemStack itemStack, EntityPlayer entityPlayer, int count) {
        //Check on sneaking
        if(!entityPlayer.isSneaking()) {
            //Purge
            this.purgeItemStack(itemStack);
            //TODO tell player it failed imprinting.
            return;
        }

        // Set Focus tag item.
        if(!NBTItemStackHelper.hasTagKey(itemStack, this.IMPRINT_IN_PROGRESS_TAG))
            NBTItemStackHelper.setBoolean(itemStack, this.IMPRINT_IN_PROGRESS_TAG, true);
        else
            LogHelper.reportWhenDebugging("Something went wrong in a focus. A RiftShard was in focus while it shouldn't (RIGHTCLICK)");

        // Check if itemStack has a set duration. SETUP the duration if not present.
        if(!NBTItemStackHelper.hasTagKey(itemStack, IMPRINT_TIME_TAG)) {
            ShardImprintEvent event = new ShardImprintEvent(entityPlayer);
            MinecraftForge.EVENT_BUS.post(event);
            NBTItemStackHelper.setInteger(itemStack, this.IMPRINT_TIME_TAG, (int) Math.floor(event.resultingDuration));
            NBTItemStackHelper.setBoolean(itemStack, this.FAUX_CANCEL_TAG, event.fauxCancel);
            NBTItemStackHelper.setInteger(itemStack, this.TEMP_STABILITY_TAG, (int) Math.floor(event.resultingStability));
        }

        if(NBTItemStackHelper.getInteger(itemStack, this.IMPRINT_TIME_TAG) < count) {
            //TODO show progress to player
        } else {
            if(!NBTItemStackHelper.getBoolean(itemStack, this.FAUX_CANCEL_TAG)) {
                // Imprint complete!
                Location imprintedLocation = new Location(entityPlayer);
                int stabilityTime = NBTBasicsHelper.getInteger(itemStack.getTagCompound(), this.TEMP_STABILITY_TAG);

                // Purge current stack of NBT
                this.purgeItemStack(itemStack);

                // Split stack, add to inventory. When not possible drop it.
                if (!entityPlayer.inventory.addItemStackToInventory(itemStack.splitStack(this.reduceItemStackInt(entityPlayer, itemStack))))
                    entityPlayer.dropItem(this, this.reduceItemStackInt(entityPlayer, itemStack));

                //Prepare new ItemStack
                ItemStack imprintedCrystal = new ItemStack(RCModItems.imprintedRiftShard, ItemImprintedRiftShard.MAX_STACK_SIZE);
                NBTLocationHelper.setLocationNBT(itemStack.getTagCompound(),
                        ItemImprintedRiftShard.IMPRINTED_LOCATION_PREFIX,
                        imprintedLocation);
                NBTItemStackHelper.setInteger(imprintedCrystal,
                        ItemImprintedRiftShard.IMPRINTED_STABLE_TIME,
                        stabilityTime);

                // Set current itemStack being held by player.
                entityPlayer.setCurrentItemOrArmor(Reference.CURRENTLY_HELD_ITEM, imprintedCrystal);

            } else {
                //TODO animate faux
            }

            // And as always mark dirty upon modification
            entityPlayer.inventory.markDirty();
        }
    }

    /*
     * When the player stops using the item
     */
    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int finalCount) {
        //Check if item is the correct type to be purged.
        if(!itemStack.getItem().getUnlocalizedName().equals(RCModItems.riftShard.getUnlocalizedName())) return;

        // Check for the IMPRINT_IN_PROGRESS-Tag before going
        if(NBTItemStackHelper.hasTagKey(itemStack, this.IMPRINT_IN_PROGRESS_TAG)) {
            if(NBTItemStackHelper.getBoolean(itemStack, this.IMPRINT_IN_PROGRESS_TAG)) {
                if(finalCount < NBTItemStackHelper.getInteger(itemStack, this.IMPRINT_TIME_TAG)) {
                    //TODO tell player imprint has failed
                    //And maybe something about this if-stack?
                }
            }
        }

        // No matter what, end always purge the NBT-data from stack.
        this.purgeItemStack(itemStack);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack itemStack, EntityPlayer entityPlayer) {
        this.purgeItemStack(itemStack);
        return true;
    }

    private ItemStack reduceItemStack(EntityPlayer entityPlayer, ItemStack itemStack) {
        if(!entityPlayer.capabilities.isCreativeMode)
            --itemStack.stackSize;
        return itemStack;
    }

    private int reduceItemStackInt(EntityPlayer entityPlayer, ItemStack itemStack) {
        if(!entityPlayer.capabilities.isCreativeMode)
            return itemStack.stackSize;
        else
            return itemStack.stackSize - 1;
    }

    private ItemStack purgeItemStack(ItemStack itemStack) {
        NBTItemStackHelper.removeTag(itemStack, this.IMPRINT_IN_PROGRESS_TAG);
        NBTItemStackHelper.removeTag(itemStack, this.IMPRINT_TIME_TAG);
        NBTItemStackHelper.removeTag(itemStack, this.FAUX_CANCEL_TAG);
        NBTItemStackHelper.removeTag(itemStack, this.TEMP_STABILITY_TAG);
        return itemStack;
    }


}
