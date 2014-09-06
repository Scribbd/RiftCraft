package nl.scribblon.riftcraft.block;

import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 10-8-2014
 *
 * RiftStone is the base block for many items or structures in this mod. This stone has been infused with strange energies.
 * The stone seems to make the air seem still around the player. And whenever holding something ender-ish it is drawn towards it.
 *
 * PLANNED:
 * Riftstones interacts with incoming and outgoing rifts.
 * Outgoing is not an issue, but incoming is...
 * Debating if I should make a tileEntity which just listens to the RiftFormation Events?
 * Or can I do something more clever... (probably there is a way)
 *
 * INTERACTIONS:
 * Whenever a formation happens withing x -amount of blocks away from this stone. It will draw in the formation event.
 * When multiple (non-stacked) stones are present, the closest gets the price.
 *
 * Whenever a shard is focused on top of a stone, it will reduce the focus time by a tbd factor
 *
 * Multi-Block:
 * The rifstone forms the basis for the following structures:
 *  - The basic rifting well
 *  -
 */
public class BlockRiftStone extends RCBlock {

    public BlockRiftStone(){
        super();
        this.setBlockName(Names.Blocks.RIFT_STONE);
    }


}
