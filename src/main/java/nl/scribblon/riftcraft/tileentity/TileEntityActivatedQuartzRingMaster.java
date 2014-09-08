package nl.scribblon.riftcraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import nl.scribblon.riftcraft.tileentity.multiimpl.TileEntityMultiMasterImpl;
import nl.scribblon.riftcraft.util.helper.nbt.NBTBasicsHelper;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledSlave;
import nl.scribblon.riftcraft.util.iplace.ILeveledRelativeStructure;
import nl.scribblon.riftcraft.util.iplace.IRelativeStructure;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 * This block is a faux block in the center of the ring. The top block will always have this master block.
 * When this master-block is missing it should be
 */
public class TileEntityActivatedQuartzRingMaster extends TileEntityMultiMasterImpl {

    public static final String LEVEL_TAG = "quartzRingLevel";

    private int level;

    public TileEntityActivatedQuartzRingMaster(){
        super();
        this.level = ILeveledRelativeStructure.INVALID_LEVEL;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        if (isMaster) {
            NBTBasicsHelper.setInteger(nbtTagCompound, LEVEL_TAG, level);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        if (isMaster) {
            this.level = NBTBasicsHelper.getInteger(nbtTagCompound, LEVEL_TAG);
        }
    }

    @Override
    protected NBTTagCompound purgeNBTTagCompound(NBTTagCompound nbtTagCompound) {
        super.purgeNBTTagCompound(nbtTagCompound);
        NBTBasicsHelper.removeTag(nbtTagCompound, LEVEL_TAG);
        return nbtTagCompound;
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
    public IRelativeStructure.StructureType isStructureComplete() {
        return IRelativeStructure.StructureType.NONE;
    }

    @Override
    public IRelativeStructure getStructure() {
        return null;
    }
}
