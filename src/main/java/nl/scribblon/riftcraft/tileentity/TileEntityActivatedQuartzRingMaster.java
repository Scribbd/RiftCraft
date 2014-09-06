package nl.scribblon.riftcraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import nl.scribblon.riftcraft.tileentity.multiimpl.TileEntityMultiImpl;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledSlave;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 * This block is a faux block in the center of the ring. The top block will always have this master block.
 * When this master-block is missing
 */
public class TileEntityActivatedQuartzRingMaster extends TileEntityMultiImpl {

    public static final String LEVEL_TAG = "quartzRingLevel";

    public static final int INVALID_LEVEL = -1;

    private int level;

    public TileEntityActivatedQuartzRingMaster(){
        super();
        this.level = INVALID_LEVEL;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        if (isMaster) {
            nbtTagCompound.setInteger(LEVEL_TAG, level);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        if (isMaster)
            this.level = nbtTagCompound.getInteger(LEVEL_TAG);
    }

    @Override
    public IMultiTiledSlave[] getTileEntitySlaveList() {
        return new IMultiTiledSlave[0];
    }

    @Override
    public boolean isStructureComplete() {
        return false;
    }

    @Override
    public IMultiTiledSlave[] setupStructureAsMaster() {
        return new IMultiTiledSlave[0];
    }

    @Override
    public boolean deconstructStructureAsMaster() {
        return false;
    }

    @Override
    public ILocationRC[] getStructureLocations() {
        return new ILocationRC[0];
    }
}
