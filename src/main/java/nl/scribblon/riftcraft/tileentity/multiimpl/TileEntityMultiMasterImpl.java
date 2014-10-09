package nl.scribblon.riftcraft.tileentity.multiimpl;

import net.minecraft.nbt.NBTTagCompound;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.RelativeStructureBlock;
import nl.scribblon.riftcraft.util.helper.LocationHelper;
import nl.scribblon.riftcraft.util.helper.LogHelper;
import nl.scribblon.riftcraft.util.helper.StructureHelper;
import nl.scribblon.riftcraft.util.helper.nbt.NBTBasicsHelper;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledSlave;
import nl.scribblon.riftcraft.util.iplace.ILeveledRelativeStructure;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeStructure;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-8-2014
 *
 * Implementation of the IMultiTiledMaster for blocks which are only going to be masterBlocks.
 */
public abstract class TileEntityMultiMasterImpl extends TileEntityMultiImpl implements IMultiTiledMaster{

    //Tag stored in Structure. Shows which structure is active.
    protected IRelativeStructure.StructureType activeStructureType;

    public TileEntityMultiMasterImpl(){
        super();
        this.activeStructureType = IRelativeStructure.StructureType.NONE;
        this.masterLocation = new Location(this);
    }

    /*_*********************************************************************************************************
     * NBT Stuff
     */
    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        if(isMaster) {
            NBTBasicsHelper.setInteger(nbtTagCompound, IRelativeStructure.StructureType.STRUCTURE_TYPE_TAG, activeStructureType.ordinal());
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        if (isMaster) {
            this.activeStructureType = IRelativeStructure.StructureType.values()[NBTBasicsHelper.getInteger(nbtTagCompound, IRelativeStructure.StructureType.STRUCTURE_TYPE_TAG)];
        }
    }

    @Override
    protected NBTTagCompound purgeNBTTagCompound(NBTTagCompound nbtTagCompound) {
        super.purgeNBTTagCompound(nbtTagCompound);

        NBTBasicsHelper.removeTag(nbtTagCompound, IRelativeStructure.StructureType.STRUCTURE_TYPE_TAG);

        return nbtTagCompound;
    }

    /*_*********************************************************************************************************
     * Master construct/deconstruct stuff and such
     */
    @Override
    abstract public void setupStructureAsMaster();

    @Override
    public boolean deconstructStructureAsMaster() {
        if (this.activeStructureType == IRelativeStructure.StructureType.NONE) return true;

        for(IMultiTiledSlave slave : this.getTileEntitySlaveList()) {
            if(!slave.deconstructAsSlave(this)){
                LogHelper.reportWhenDebugging("ERROR: " + this + " encountered a slave that couldn't deconstruct itself!");
                return false;
            }
        }
        this.activeStructureType = IRelativeStructure.StructureType.NONE;

        return true;
    }

    @Override
    abstract public IRelativeStructure.StructureType isStructureComplete();

    /*_*********************************************************************************************************
     * Various (Simple) getters
     */
    @Override
    public IRelativeStructure.StructureType getActiveStructureType() {
        return this.activeStructureType;
    }

    public IRelativeStructure getStructure() {
        return StructureHelper.getStructure(this.activeStructureType);
    }

    /*_*********************************************************************************************************
         * Various (Complex) getters
         */
    @Override
    public IMultiTiledSlave[] getTileEntitySlaveList() {
        if (this.activeStructureType == IRelativeStructure.StructureType.NONE) return null;

        ArrayList<IMultiTiledSlave> slaves= new ArrayList<IMultiTiledSlave>();
        for(ILocationRC location: this.getStructureLocations()) {
            if(location.getBlockAtLocation().hasTileEntity(0))
                if(location.getTileEntityAtLocation() instanceof IMultiTiledSlave)
                    slaves.add((IMultiTiledSlave) location.getTileEntityAtLocation());
        }

        return slaves.toArray(new IMultiTiledSlave[slaves.size()]);
    }

    @Override
    public ILocationRC[] getStructureLocations() {
        if (this.getActiveStructureType() == IRelativeStructure.StructureType.NONE) return null;

        Set<RelativeStructureBlock> set = this.getStructureSet();

        return LocationHelper.convertRelativeToAbsolute(set.toArray(new RelativeStructureBlock[set.size()]), this.getLocation());
    }


    /*_*********************************************************************************************************
     * Methods which needs to be implemented by concrete subclass
     */

    abstract boolean needToDeconstructStructureOnBreak(IRelativeLocationRC relativeLocationRC);

    /*_*********************************************************************************************************
     * basic functions which are needed. Should not be part of public domain! These functions assume structure is correct
     */
    protected Set<RelativeStructureBlock> getStructureSet(){
        if(getStructure() instanceof ILeveledRelativeStructure) {
            ILeveledRelativeStructure structure = (ILeveledRelativeStructure) this.getStructure();
            return structure.getParts(ILeveledRelativeStructure.ROOT_LEVEL, structure.getLevel(this));
        }
        return this.getStructure().getParts();
    }
}
