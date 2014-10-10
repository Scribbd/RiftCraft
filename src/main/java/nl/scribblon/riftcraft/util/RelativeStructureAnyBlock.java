package nl.scribblon.riftcraft.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import nl.scribblon.riftcraft.util.helper.BlockHelper;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;
import nl.scribblon.riftcraft.util.istructure.IRelativeStructurePart;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 13-10-2014
 *
 * A general class for any block except air, dirt, cobble, and wood.
 */
public class RelativeStructureAnyBlock implements IRelativeStructurePart {

    private RelativeLocation relativeLocation;

    public RelativeStructureAnyBlock(RelativeLocation relativeLocation) {
        this.relativeLocation = relativeLocation;
    }

    @Override
    public IRelativeLocationRC getRelativeLocation() {
        return this.relativeLocation;
    }

    @Override
    public ILocationRC getAbsoluteLocation(ILocationRC rootLocation) {
        return this.relativeLocation.getILocationRelativelyFrom(rootLocation);
    }

    @Override
    public boolean isPartValid(Block block) {
        if(block.isAir(null, 0, 0, 0)) return false; // The 'Null, 0, 0, 0' part 'cause the function requires these, but never actually uses them.
                                                     // Should keep an eye out for reports indicating otherwise.
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.dirt)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.torch)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.planks)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.double_wooden_slab)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.wooden_slab)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.stone_button)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.wooden_button)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.wooden_door)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.iron_door)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.lever)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.powered_repeater)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.unpowered_repeater)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.powered_comparator)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.unpowered_comparator)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.redstone_block)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.redstone_torch)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.unlit_redstone_torch)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.cobblestone)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.cobblestone_wall)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.mossy_cobblestone)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.vine)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.tripwire)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.tripwire_hook)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.mob_spawner)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.dragon_egg)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.ladder)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.lava)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.flowing_lava)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.water)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.flowing_water)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.red_flower)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.yellow_flower)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.tallgrass)) return false;
        if(BlockHelper.isBlockSameByUnlocalizedName(block, Blocks.grass)) return false;
        // Should make this ore dictionary proof...
        return true;
    }

    @Override
    public boolean isPartValidAt(ILocationRC root) {
        return this.isPartValid(this.relativeLocation.getILocationRelativelyFrom(root).getBlockAtLocation());
    }
}
