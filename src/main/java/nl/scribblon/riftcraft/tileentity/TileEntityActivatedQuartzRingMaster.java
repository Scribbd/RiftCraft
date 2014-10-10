package nl.scribblon.riftcraft.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import nl.scribblon.riftcraft.tileentity.structuretileimpl.StructureTileMasterImpl;
import nl.scribblon.riftcraft.util.helper.LogHelper;
import nl.scribblon.riftcraft.util.helper.nbt.NBTBasicsHelper;
import nl.scribblon.riftcraft.util.istructure.ILeveledStructure;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.istructure.IStructure;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 * This block is a faux block in the center of the ring. The top block will always have this master block.
 * When this master-block is missing it should deconstruct itself.
 *
 */
public class TileEntityActivatedQuartzRingMaster extends StructureTileMasterImpl {

    public static final String LEVEL_TAG = "quartzRingLevel";

    private int level;

    public TileEntityActivatedQuartzRingMaster(){
        super();
        this.level = ILeveledStructure.INVALID_LEVEL;
        this.setupStructureAsMaster();
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
    public void setupStructureAsMaster() {
        this.activeStructureType = this.isStructureComplete();

        if(this.activeStructureType == IStructure.StructureType.NONE) return;


    }

    @Override
    public boolean deconstructStructureAsMaster() {
        if(!super.deconstructStructureAsMaster()) return false;
        this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, Blocks.air);
        this.worldObj.removeTileEntity(this.xCoord, this.yCoord, this.zCoord);
        return true;
    }

    @Override
    public IStructure.StructureType isStructureComplete() {
        //Only for this block, whenever structure is not active, it shouldn't exist.
        if(this.getStructure() == null) {
            LogHelper.reportWhenDebugging("ERROR: A QuartzRingMaster is without ring!");
            return IStructure.StructureType.NONE;
        }

        if(!this.getStructure().isStructureCorrectFrom(this)) return IStructure.StructureType.NONE;

        return IStructure.StructureType.NONE;
    }

    private void moveMaster(ILocationRC location) {

    }
}
