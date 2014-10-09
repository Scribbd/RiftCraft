package nl.scribblon.riftcraft.block.stone;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.block.RCBlock;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.tileentity.TileEntityRiftStone;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 10-8-2014
 *
 * RiftStone is the base block for many items or structures in this mod. This stone has been infused with strange energies.
 * The stone seems to make the air stand still where ever it is placed.
 *
 * PLANNED:
 * A riftstone needs to stabilize itself before it is useful. Planned time is 1 minute.
 *
 * Whenever the location is imprinted it will provide a focus bonus.
 * Riftstones interacts with incoming and outgoing rifts.
 * Outgoing rifts benefit from a stability bonus.
 * Whenever an incoming rift is stabilizing above this block it will provide a focus + stability bonus.
 * Incoming rifts are attracted by this block. Forcing to repositioning itself above it. Requires the rift to stabilize longer, (tell for the incoming rifter their rift is modified).
 * Requirements: Incoming rift hasn't been affected yet by disruption stones. Unless it is linked to a Energy Manipulation Field.
 *  Exceptions: Whenever a disruption stone is placed underneath the stone. The riftstone doesn't draw in the incoming rift.
 *
 * INTERACTIONS:
 * Whenever a formation happens withing x -amount of blocks away from this stone. It will draw in the formation event.
 * When multiple (non-stacked) stones are present, the closest gets the price.
 *
 * Whenever a shard is focused on top of a stone, it will reduce the focus time by a tbd factor
 *
 * Multi-Block:
 * The rifstone forms the basis for the following structures:
 *  - The RiftStone well
 *  - Any block that needs to stabilize something.
 */
public class BlockRiftStone extends RCBlock {

    public BlockRiftStone(){
        super();
        this.setBlockName(Names.Blocks.RIFT_STONE);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityRiftStone();
    }
}
