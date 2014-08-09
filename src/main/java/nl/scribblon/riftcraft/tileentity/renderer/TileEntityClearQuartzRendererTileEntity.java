package nl.scribblon.riftcraft.tileentity.renderer;

import net.minecraft.tileentity.TileEntity;
import nl.scribblon.riftcraft.tileentity.TileEntityClearQuartz;

/**
 * Created by Peter on 09-08-14.
 */
public class TileEntityClearQuartzRendererTileEntity extends RCTileEntitySpecialRenderer {
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
        if(tileEntity == null) return;
        if(!(tileEntity instanceof TileEntityClearQuartz)) return;


    }
}
