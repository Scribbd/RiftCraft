package nl.scribblon.riftcraft.util;

import net.minecraft.block.Block;
import nl.scribblon.riftcraft.util.helper.BlockHelper;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;
import nl.scribblon.riftcraft.util.istructure.IRelativeStructurePart;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 13-10-2014
 *
 * Relative Structure Block. Single Block.
 */
public class RelativeStructureBlock implements IRelativeStructurePart {

    private Block block;
    private RelativeLocation relativeLocation;

    public RelativeStructureBlock(RelativeLocation relativeLocation, Block block) {
        this.block = block;
        this.relativeLocation = relativeLocation;
    }

    @Override
    public boolean isPartValid(Block block) {
        return BlockHelper.isBlockSameByUnlocalizedName(this.block, block);
    }

    @Override
    public boolean isPartValidAt(ILocationRC rootLocation) {
        return this.isPartValid(this.relativeLocation.getBlockRelativelyFrom(rootLocation));
    }

    @Override
    public IRelativeLocationRC getRelativeLocation() {
        return this.relativeLocation;
    }

    @Override
    public ILocationRC getAbsoluteLocation(ILocationRC rootLocation) {
        return this.relativeLocation.getILocationRelativelyFrom(rootLocation);
    }
}
