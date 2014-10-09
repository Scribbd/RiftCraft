package nl.scribblon.riftcraft.item.crystalic.shard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.init.RCModItems;
import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.manager.Rift;
import nl.scribblon.riftcraft.manager.RiftCraftConductor;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.reference.Settings;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.helper.LogHelper;
import nl.scribblon.riftcraft.util.helper.nbt.NBTBasicsHelper;
import nl.scribblon.riftcraft.util.helper.nbt.NBTItemStackHelper;
import nl.scribblon.riftcraft.util.helper.nbt.NBTLocationHelper;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 25-08-14
 *
 * The imprinted version of the RiftShard. Should maybe be integrated as a something with metadata in the
 */
public class ItemImprintedRiftShard extends RCItem {

    public static final String IMPRINTED_LOCATION_PREFIX = "rcImprintedShard";
    public static final String IMPRINTED_STABLE_TIME = "rcImprintedStableTime";

    public static final int STABILITY_EDGE = 0;

    // Default reference stuff
    public static final int MAX_STACK_SIZE = 1;

    public ItemImprintedRiftShard() {
        super();
        this.setMaxStackSize(MAX_STACK_SIZE);
        this.setUnlocalizedName(Names.Items.IMPRINTED_RIFT_SHARD);
    }

    /*
     * When player right clicks item it will start focusing.
     * Debating if I want this to be limited to sneaking or not.
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        // Either the player has to be sneaking to do this, or not. DECISIONS!
        if(entityPlayer.isSneaking()) {
            //Clear

            return itemStack;
        }
        // Check if a location is present in the itemStack data
        if(!NBTLocationHelper.hasLocationNBT(itemStack.getTagCompound(), this.IMPRINTED_LOCATION_PREFIX)) {
            LogHelper.reportWhenDebugging("Something went wrong with an ImprintedRiftShard, it should have a Location bu none was found");
            return itemStack;
        }

        // Create rift
        Rift rift = new Rift(entityPlayer, new Location(entityPlayer), NBTLocationHelper.getLocationNBT(itemStack.getTagCompound(), this.IMPRINTED_LOCATION_PREFIX));

        // Register Rift
        RiftCraftConductor.getInstance().seatMusician(rift);

        return itemStack;
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean isInHand) {
        // Check if itemstack is right stack
        if(!itemStack.getUnlocalizedName().equals(RCModItems.imprintedRiftShard.getUnlocalizedName())) return;

        // Minus stability
        NBTBasicsHelper.setInteger(itemStack.getTagCompound(),
                this.IMPRINTED_STABLE_TIME,
                NBTItemStackHelper.getInteger(itemStack, this.IMPRINTED_STABLE_TIME) - Settings.Shards.defaultStableDecrement
        );
    }

    public boolean isStable(ItemStack itemStack) {
        if(!itemStack.getUnlocalizedName().equals(RCModItems.imprintedRiftShard.getUnlocalizedName())) return false;
        return NBTBasicsHelper.getInteger(itemStack.getTagCompound(), this.IMPRINTED_STABLE_TIME) > this.STABILITY_EDGE;
    }

    public ItemStack setStableTime(ItemStack itemStack, int stableTime) {
        if(!itemStack.getUnlocalizedName().equals(RCModItems.imprintedRiftShard.getUnlocalizedName())) return itemStack;
        NBTItemStackHelper.setInteger(itemStack, this.IMPRINTED_STABLE_TIME, stableTime);
        return  itemStack;
    }

    public ItemStack extendStableTie(ItemStack itemStack, int extendTime) {
        if(!itemStack.getUnlocalizedName().equals(RCModItems.imprintedRiftShard.getUnlocalizedName())) return itemStack;
        return this.setStableTime(itemStack, NBTItemStackHelper.getInteger(itemStack, this.IMPRINTED_STABLE_TIME) + extendTime);
    }

    private ItemStack clearImprint(ItemStack itemStack) {
        return itemStack;
    }
}
