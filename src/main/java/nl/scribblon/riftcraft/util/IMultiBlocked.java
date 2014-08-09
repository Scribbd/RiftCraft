package nl.scribblon.riftcraft.util;

import net.minecraft.tileentity.TileEntity;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 */
public interface IMultiBlocked {

    public TileEntity getMasterBlock();

    public boolean isActive();
}
