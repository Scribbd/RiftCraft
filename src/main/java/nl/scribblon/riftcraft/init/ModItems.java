package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import nl.scribblon.riftcraft.item.ItemGlitteringDust;
import nl.scribblon.riftcraft.item.ItemGlitteringOrb;
import nl.scribblon.riftcraft.item.ItemGlitteringWrench;
import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.item.shard.ItemEnderShard;
import nl.scribblon.riftcraft.item.shard.ItemRiftShard;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.reference.Reference;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

    public static final RCItem enderShard = new ItemEnderShard();
    public static final RCItem riftShard = new ItemRiftShard();
    public static final RCItem glitteringDust = new ItemGlitteringDust();
    public static final RCItem glitteringOrb = new ItemGlitteringOrb();
    public static final RCItem glitteringWrench = new ItemGlitteringWrench();

    public static void init(){
        GameRegistry.registerItem(enderShard, Names.Items.ENDER_SHARD);
        GameRegistry.registerItem(riftShard, Names.Items.RIFT_SHARD);
        GameRegistry.registerItem(glitteringDust, Names.Items.GLITTERING_DUST);
        GameRegistry.registerItem(glitteringOrb, Names.Items.GLITTERING_ORB);
        GameRegistry.registerItem(glitteringWrench, Names.Items.GLITTERING_WRENCH);
    }
}
