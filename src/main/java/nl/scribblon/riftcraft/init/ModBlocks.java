package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import nl.scribblon.riftcraft.block.BlockActivatedQuartz;
import nl.scribblon.riftcraft.block.BlockClearQuartz;
import nl.scribblon.riftcraft.block.BlockRiftStone;
import nl.scribblon.riftcraft.block.RCBlock;
import nl.scribblon.riftcraft.block.crystalcluster.EnderShardCluster;
import nl.scribblon.riftcraft.block.crystalcluster.RiftShardCluster;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.reference.Reference;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
    //Modified Vanilla Blocks
    public static final Block activatedQuarts = new BlockActivatedQuartz();

    //RiftCraft Blocks
    public static final RCBlock clearQuartz = new BlockClearQuartz();
    public static final RCBlock enderShardCluster = new EnderShardCluster();
    public static final RCBlock riftShardCluster = new RiftShardCluster();
    public static final RCBlock riftStone = new BlockRiftStone();

    public static void init(){
        //Register Vanilla Block
        GameRegistry.registerBlock(activatedQuarts, Names.Blocks.ACTIVATED_QUARTS);

        //RiftCraft Blocks
        GameRegistry.registerBlock(clearQuartz, Names.Blocks.CLEAR_QUARTZ);
        GameRegistry.registerBlock(enderShardCluster, Names.Blocks.ENDERSHARD_CLUSTER);
        GameRegistry.registerBlock(riftShardCluster, Names.Blocks.RIFTSHARD_CLUSTER);
        GameRegistry.registerBlock(riftStone, Names.Blocks.RIFT_STONE);
    }
}
