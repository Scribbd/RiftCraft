package nl.scribblon.riftcraft.block;

import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class ClearQuartz extends RCBlock{

    public ClearQuartz(){
        super();
        this.setBlockName(Names.Blocks.CLEARQUARTZ);
        this.setBlockTextureName(Names.Blocks.CLEARQUARTZ);
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

}
