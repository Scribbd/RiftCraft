package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import nl.scribblon.riftcraft.block.ClearQuartz;
import nl.scribblon.riftcraft.block.RCBlock;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.reference.Reference;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

    public static final RCBlock clearQuartz = new ClearQuartz();

    public static void init(){
        GameRegistry.registerBlock(clearQuartz, Names.Blocks.CLEARQUARTZ);
    }
}
