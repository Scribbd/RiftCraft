package nl.scribblon.riftcraft.block;

import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 *
 * Clear Quartz is a dormant tile-entity less block. Renders like an empty clear quartz block. Can be safely used as decoration.
 */
public class BlockClearQuartz extends RCBlock{

    public BlockClearQuartz(){
        super();
        this.setBlockName(Names.Blocks.CLEAR_QUARTZ);
        this.setBlockTextureName(Names.Blocks.CLEAR_QUARTZ);
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }


}
