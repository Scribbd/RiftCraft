package nl.scribblon.riftcraft.tileentity.multiimpl;

import net.minecraft.nbt.NBTTagCompound;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.RelativeStructureBlock;
import nl.scribblon.riftcraft.util.helper.LocationHelper;
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
 * Implementation of the IMultiTiledMaster for blocks which are only going to be masterBlocks.
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-8-2014
 */
public abstract class TileEntityMultiMasterImpl extends TileEntityMultiImpl implements IMultiTiledMaster{

    //Tag stored in MultiEntityType.enum
    protected MultiEntityType type;

    public TileEntityMultiMasterImpl(){
        super();
        this.type = MultiEntityType.UNSET;
        this.masterLocation = new Location(this);
    }

    /*_*********************************************************************************************************
     * NBT Stuff
     */
    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        if(isMaster) {
            NBTBasicsHelper.setInteger(nbtTagCompound, MultiEntityType.MULTI_ENTITY_TYPE_TAG, type.ordinal());
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        if (isMaster) {
            this.type = MultiEntityType.values()[NBTBasicsHelper.getInteger(nbtTagCompound, MultiEntityType.MULTI_ENTITY_TYPE_TAG)];
        }
    }

    @Override
    protected NBTTagCompound purgeNBTTagCompound(NBTTagCompound nbtTagCompound) {
        super.purgeNBTTagCompound(nbtTagCompound);

        NBTBasicsHelper.removeTag(nbtTagCompound, MultiEntityType.MULTI_ENTITY_TYPE_TAG);

        return nbtTagCompound;
    }

    /*_*********************************************************************************************************
     * Master construct/deconstruct stuff and such
     */
    @Override
    abstract public IMultiTiledSlave[] setupStructureAsMaster();

    @Override
    abstract public boolean deconstructStructureAsMaster();

    @Override
    abstract public boolean isStructureComplete();

    /*_*********************************************************************************************************
     * Various (Simple) getters
     */
    @Override
    public MultiEntityType getMultiEntityType() {
        return this.type;
    }

    /*_*********************************************************************************************************
     * Various (Complex) getters
     */
    @Override
    public IMultiTiledSlave[] getTileEntitySlaveList() {
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
        Set<RelativeStructureBlock> set = this.getStructureSet();

        return LocationHelper.convertRelativeToAbsolute(set.toArray(new RelativeStructureBlock[set.size()]), this.getLocation());
    }


    /*_*********************************************************************************************************
     * Methods which needs to be implemented by concrete subclass
     */
    abstract public IRelativeStructure getStructure();

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
