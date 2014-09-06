package nl.scribblon.riftcraft.tileentity.renderer;

import net.minecraft.tileentity.TileEntity;
import nl.scribblon.riftcraft.tileentity.TileEntityActivatedQuartz;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 09-08-14
 *
 * The renderer of the Activated Quartz.
 */
public class TileEntityActivatedQuartzRenderer extends RCTileEntitySpecialRenderer {
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
        if(tileEntity == null) return;
        if(!(tileEntity instanceof TileEntityActivatedQuartz)) return;


    }
}
