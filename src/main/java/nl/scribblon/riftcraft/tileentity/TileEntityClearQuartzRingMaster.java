package nl.scribblon.riftcraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import nl.scribblon.riftcraft.block.ClearQuartz;
import nl.scribblon.riftcraft.util.IMultiBlocked;
import nl.scribblon.riftcraft.util.IMultiBlockedMaster;

import java.util.List;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 */
public class TileEntityClearQuartzRingMaster extends TileEntityMultiBlock implements IMultiBlockedMaster{

    public static final String LEVEL_TAG = "quartzRingLevel";

    public List<IMultiBlocked> slaveList;
    private int level;


    public int getLevel(){
        return level;
    }

    @Override
    public List<IMultiBlocked> getSlaveList() {
        return slaveList;
    }

    @Override
    public boolean isStructureComplete() {

        return checkStructureLevel() > 0;
    }

    @Override
    public List<IMultiBlocked> setupStructure() {


        return null;
    }

    @Override
    public boolean resetStructure() {
        return false;
    }

    @Override
    public TileEntity getMasterBlock() {
        return this;
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setInteger(LEVEL_TAG, level);
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        this.level = tagCompound.getInteger(LEVEL_TAG);
    }

    private int checkStructureLevel(){
        int localLevel = 0;
        for(int zModifier = -1; zModifier <= 1; ++zModifier){
            if(isRingComplete(zModifier)) ++localLevel;
        }
        return localLevel;
    }

    private boolean isRingComplete(int zModifier){
        for(int localX = this.xCoord; localX <= 1; ++localX){
            for(int localY = this.yCoord; localY <= 1; ++localY){
                if(localX == 0 && localY == 0) continue;
                if(!this.getWorldObj().blockExists(localX,localY,this.zCoord - zModifier)) return false;
                Block block = this.getWorldObj().getBlock(localX,localY,this.zCoord - zModifier);
                if(!(block instanceof ClearQuartz)) return false;
            }
        }

        return true;
    }
}
