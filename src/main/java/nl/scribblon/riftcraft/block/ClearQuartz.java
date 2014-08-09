package nl.scribblon.riftcraft.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.tileentity.TileEntityClearQuartz;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class ClearQuartz extends RCBlock{

    public ClearQuartz(){
        super();
        this.setBlockName(Names.Blocks.CLEAR_QUARTZ);
        this.setBlockTextureName(Names.Blocks.CLEAR_QUARTZ);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityClearQuartz();
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }


}
