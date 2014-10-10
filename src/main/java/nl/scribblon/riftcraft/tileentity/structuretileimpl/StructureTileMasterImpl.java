package nl.scribblon.riftcraft.tileentity.structuretileimpl;

import net.minecraft.nbt.NBTTagCompound;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.RelativeStructureBlockArray;
import nl.scribblon.riftcraft.util.helper.LocationHelper;
import nl.scribblon.riftcraft.util.helper.LogHelper;
import nl.scribblon.riftcraft.util.helper.StructureHelper;
import nl.scribblon.riftcraft.util.helper.nbt.NBTBasicsHelper;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;
import nl.scribblon.riftcraft.util.istructure.ILeveledStructure;
import nl.scribblon.riftcraft.util.istructure.IStructure;
import nl.scribblon.riftcraft.util.istructure.IStructureTileMaster;
import nl.scribblon.riftcraft.util.istructure.IStructureTileSlave;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-8-2014
 *
 * Implementation of the IMultiTiledMaster for blocks which are only going to be masterBlocks.
 */
public abstract class StructureTileMasterImpl extends StructureTileImpl implements IStructureTileMaster {

    //Tag stored in Structure. Shows which structure is active.
    protected IStructure.StructureType activeStructureType;

    public StructureTileMasterImpl(){
        super();
        this.activeStructureType = IStructure.StructureType.NONE;
        this.masterLocation = new Location(this);
    }

    /*_*********************************************************************************************************
     * NBT Stuff
     */
    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        if(isMaster) {
            NBTBasicsHelper.setInteger(nbtTagCompound, IStructure.StructureType.STRUCTURE_TYPE_TAG, activeStructureType.ordinal());
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        if (isMaster) {
            this.activeStructureType = IStructure.StructureType.values()[NBTBasicsHelper.getInteger(nbtTagCompound, IStructure.StructureType.STRUCTURE_TYPE_TAG)];
        }
    }

    @Override
    protected NBTTagCompound purgeNBTTagCompound(NBTTagCompound nbtTagCompound) {
        super.purgeNBTTagCompound(nbtTagCompound);

        NBTBasicsHelper.removeTag(nbtTagCompound, IStructure.StructureType.STRUCTURE_TYPE_TAG);

        return nbtTagCompound;
    }

    /*_*********************************************************************************************************
     * Master construct/deconstruct stuff and such
     */
    @Override
    abstract public void setupStructureAsMaster();

    @Override
    public boolean deconstructStructureAsMaster() {
        if (this.activeStructureType == IStructure.StructureType.NONE) return true;

        for(IStructureTileSlave slave : this.getTileEntitySlaveList()) {
            if(!slave.deconstructAsSlave(this)){
                LogHelper.reportWhenDebugging("ERROR: " + this + " encountered a slave that couldn't deconstruct itself!");
                return false;
            }
        }
        this.activeStructureType = IStructure.StructureType.NONE;

        return true;
    }

    @Override
    abstract public IStructure.StructureType isStructureComplete();

    /*_*********************************************************************************************************
     * Various (Simple) getters
     */
    @Override
    public IStructure.StructureType getActiveStructureType() {
        return this.activeStructureType;
    }

    public IStructure getStructure() {
        return StructureHelper.getStructure(this.activeStructureType);
    }

    /*_*********************************************************************************************************
         * Various (Complex) getters
         */
    @Override
    public IStructureTileSlave[] getTileEntitySlaveList() {
        if (this.activeStructureType == IStructure.StructureType.NONE) return null;

        ArrayList<IStructureTileSlave> slaves= new ArrayList<IStructureTileSlave>();
        for(ILocationRC location: this.getStructureLocations()) {
            if(location.getBlockAtLocation().hasTileEntity(0))
                if(location.getTileEntityAtLocation() instanceof IStructureTileSlave)
                    slaves.add((IStructureTileSlave) location.getTileEntityAtLocation());
        }

        return slaves.toArray(new IStructureTileSlave[slaves.size()]);
    }

    @Override
    public ILocationRC[] getStructureLocations() {
        if (this.getActiveStructureType() == IStructure.StructureType.NONE) return null;

        Set<RelativeStructureBlockArray> set = this.getStructureSet();

        return LocationHelper.convertRelativeToAbsolute(set.toArray(new RelativeStructureBlockArray[set.size()]), this.getLocation());
    }


    /*_*********************************************************************************************************
     * Methods which needs to be implemented by concrete subclass
     */

    abstract boolean needToDeconstructStructureOnBreak(IRelativeLocationRC relativeLocationRC);

    /*_*********************************************************************************************************
     * basic functions which are needed. Should not be part of public domain! These functions assume structure is correct
     */
    protected Set<RelativeStructureBlockArray> getStructureSet(){
        if(getStructure() instanceof ILeveledStructure) {
            ILeveledStructure structure = (ILeveledStructure) this.getStructure();
            return structure.getParts(ILeveledStructure.ROOT_LEVEL, structure.getLevel(this));
        }
        return this.getStructure().getParts();
    }
}
