package nl.scribblon.riftcraft.util;

import net.minecraft.block.Block;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;
import nl.scribblon.riftcraft.util.istructure.IRelativeStructurePart;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 14-10-2014
 *
 * A Structure Part that specifically tests if a specific TileEntity to be there.
 */
public class RelativeStructureTileBlock implements IRelativeStructurePart{

    private RelativeLocation relativeLocation;
    private Block tileBlock;

    public RelativeStructureTileBlock(Block tileBlock, RelativeLocation relativeLocation) {
        this.tileBlock = tileBlock;
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
        if(!block.hasTileEntity(0)) return false;
        if(!this.tileBlock.getUnlocalizedName().equals(block.getUnlocalizedName())) return false;

        return true;
    }

    @Override
    public boolean isPartValidAt(ILocationRC root) {
        return this.isPartValid(this.getAbsoluteLocation(root).getBlockAtLocation());
    }
}
