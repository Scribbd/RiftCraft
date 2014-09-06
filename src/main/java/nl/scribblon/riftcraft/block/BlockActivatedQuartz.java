package nl.scribblon.riftcraft.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.tileentity.TileEntityActivatedQuartz;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 02-09-14
 *
 * This block is whenever vanilla quartz enter the realm of RiftCraft. They suddenly become simple batteries...
 */
public class BlockActivatedQuartz extends RCBlock{

    public BlockActivatedQuartz() {
        super();
        this.setBlockName(Names.Blocks.ACTIVATED_QUARTS);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityActivatedQuartz();
    }
}
