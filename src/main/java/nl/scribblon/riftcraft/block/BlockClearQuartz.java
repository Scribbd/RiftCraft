package nl.scribblon.riftcraft.block;

import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class BlockClearQuartz extends RCBlock{

    public BlockClearQuartz(){
        super();
        this.setBlockName(Names.Blocks.CLEAR_QUARTZ);
        this.setBlockTextureName(Names.Blocks.CLEAR_QUARTZ);
    }

//    @Override
//    public TileEntity createTileEntity(World world, int metadata) {
//        return new TileEntityClearQuartz();
//    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }


}
