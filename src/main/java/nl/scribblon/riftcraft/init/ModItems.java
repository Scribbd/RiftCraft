package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import nl.scribblon.riftcraft.item.EnderShard;
import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.item.RiftShard;
import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class ModItems {

    public static final RCItem enderShard = new EnderShard();
    public static final RCItem riftShard = new RiftShard();

    public static void init(){
        GameRegistry.registerItem(enderShard, Names.Items.ENDERSHARD);
        GameRegistry.registerItem(riftShard, Names.Items.RIFTSHARD);
    }
}
