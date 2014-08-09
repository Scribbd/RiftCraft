package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import nl.scribblon.riftcraft.block.ActivatedQuartz;
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
    //Modified Vanilla Blocks
    public static final Block activatedQuarts = new ActivatedQuartz();

    //RiftCraft Blocks
    public static final RCBlock clearQuartz = new ClearQuartz();

    public static void init(){
        //Register Vanilla Block
        GameRegistry.registerBlock(activatedQuarts, Names.Blocks.ACTIVATED_QUARTS);

        //RiftCraft Blocks
        GameRegistry.registerBlock(clearQuartz, Names.Blocks.CLEAR_QUARTZ);
    }
}
