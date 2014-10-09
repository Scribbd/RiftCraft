package nl.scribblon.riftcraft.block.stone;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.block.RCBlock;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.tileentity.TileEntityDisruptionStone;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 03-09-14
 *
 * Acts the opposite to
 */
public class BlockDisruptionStone extends RCBlock {

    public BlockDisruptionStone() {
        super();
        this.setBlockName(Names.Blocks.DISRUPTION_STONE);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityDisruptionStone();
    }
}
