package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import nl.scribblon.riftcraft.block.RCBlock;
import nl.scribblon.riftcraft.block.crystalic.EndericShardCluster;
import nl.scribblon.riftcraft.block.crystalic.RiftShardCluster;
import nl.scribblon.riftcraft.block.quartz.BlockActivatedQuartz;
import nl.scribblon.riftcraft.block.quartz.BlockClearQuartz;
import nl.scribblon.riftcraft.block.quartz.BlockDormantQuartz;
import nl.scribblon.riftcraft.block.stone.BlockDisruptionStone;
import nl.scribblon.riftcraft.block.stone.BlockRiftStone;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.reference.Reference;
//@formatter:off
/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 *
 * The blocks of the fabulous RiftCraft
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class RCModBlocks {
    //Modified Vanilla Blocks
    public static final Block dormantQuartz = new BlockDormantQuartz();

    //RiftCraft Blocks
    public static final RCBlock activatedQuartz = new BlockActivatedQuartz();
    public static final RCBlock clearQuartz = new BlockClearQuartz();
    public static final RCBlock endericShardCluster = new EndericShardCluster();
    public static final RCBlock riftShardCluster = new RiftShardCluster();
    public static final RCBlock riftStone = new BlockRiftStone();
    public static final RCBlock disruptionStone = new BlockDisruptionStone();

    public static void init(){
        //Register Vanilla Block
        GameRegistry.registerBlock(dormantQuartz, Names.Blocks.ACTIVATED_QUARTZ);

        //RiftCraft Blocks
    //Quartz
        GameRegistry.registerBlock(activatedQuartz, Names.Blocks.ACTIVATED_QUARTZ);
        GameRegistry.registerBlock(clearQuartz, Names.Blocks.CLEAR_QUARTZ);
    //Crystalic
        GameRegistry.registerBlock(endericShardCluster, Names.Blocks.ENDERIC_SHARD_CLUSTER);

        GameRegistry.registerBlock(riftShardCluster, Names.Blocks.RIFT_SHARD_CLUSTER);
    //Stones
        GameRegistry.registerBlock(riftStone, Names.Blocks.RIFT_STONE);
        GameRegistry.registerBlock(disruptionStone, Names.Blocks.DISRUPTION_STONE);
    }
}
//@formatter:on
