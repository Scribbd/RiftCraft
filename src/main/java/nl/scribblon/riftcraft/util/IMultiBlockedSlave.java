package nl.scribblon.riftcraft.util;

import net.minecraft.tileentity.TileEntity;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 */
public interface IMultiBlockedSlave extends IMultiBlocked{

    public boolean receiveMasterTick();

    public TileEntity setup(TileEntity master);

    public TileEntity reset(TileEntity master);
}
