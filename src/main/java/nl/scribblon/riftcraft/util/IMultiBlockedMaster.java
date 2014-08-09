package nl.scribblon.riftcraft.util;

import java.util.List;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 */
public interface IMultiBlockedMaster extends IMultiBlocked{

    public List<IMultiBlocked> getSlaveList();

    public boolean isStructureComplete();

    public List<IMultiBlocked> setupStructure();

    public boolean resetStructure();
}
