package nl.scribblon.riftcraft.tileentity.structuretileimpl;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import nl.scribblon.riftcraft.tileentity.RCTileEntity;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.helper.LogHelper;
import nl.scribblon.riftcraft.util.helper.nbt.NBTLocationHelper;
import nl.scribblon.riftcraft.util.istructure.IStructure;
import nl.scribblon.riftcraft.util.istructure.IStructureTile;
import nl.scribblon.riftcraft.util.istructure.IStructureTileMaster;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 *
 * Implementation of IMultiTiled interface.
 */
public abstract class StructureTileImpl extends RCTileEntity implements IStructureTile {

    public static final String IS_MASTER_TAG = "isMaster";
    public static final String HAS_MASTER_TAG = "hasMaster";

    protected boolean hasMaster; //Is persistent
    protected boolean isMaster; //Is persistent

    //For the NBTLocationHelper (Should be purged when no master is set.
    private static final String LOCATION_TAG_PREFIX = "master";
    protected ILocationRC masterLocation;

    public StructureTileImpl(){
        super();
        this.hasMaster = false;
        this.isMaster = false;
        this.masterLocation = Location.INVALID_LOCATION;
    }

    /*_*********************************************************************************************************
     * NBT Stuff
     */
    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setBoolean(IS_MASTER_TAG, isMaster);
        nbtTagCompound.setBoolean(HAS_MASTER_TAG, hasMaster);

        if (hasStatusChanged(nbtTagCompound))
            this.purgeNBTTagCompound(nbtTagCompound);

        if(hasMaster)
            NBTLocationHelper.setLocationNBT(nbtTagCompound, this.LOCATION_TAG_PREFIX, this.masterLocation);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        this.isMaster = nbtTagCompound.getBoolean(IS_MASTER_TAG);
        this.hasMaster = nbtTagCompound.getBoolean(HAS_MASTER_TAG);

        if(hasMaster)
            this.masterLocation = NBTLocationHelper.getLocationNBT(nbtTagCompound, LOCATION_TAG_PREFIX);
    }

    /**
     * Check if the status of the TileEntity has changed in comparison to the NBT-data.
     * @param nbtTagCompound
     * @return
     */
    protected boolean hasStatusChanged(NBTTagCompound nbtTagCompound) {
        return !(nbtTagCompound.getBoolean(IS_MASTER_TAG) && isMaster) || !(nbtTagCompound.getBoolean(HAS_MASTER_TAG) && hasMaster);
    }

    /**
     * Purges NBTTagCompound of data which aren't needed anymore.
     * @param nbtTagCompound
     * @return
     */
    protected NBTTagCompound purgeNBTTagCompound(NBTTagCompound nbtTagCompound) {
        NBTLocationHelper.removeLocationNBT(nbtTagCompound, LOCATION_TAG_PREFIX);
        return nbtTagCompound;
    }

    /*_*********************************************************************************************************
     * Getters + Setters for this Object
     */
    @Override
    public boolean isMaster() {
        return isMaster;
    }

    @Override
    public void setIsMaster(boolean isMaster){
        this.isMaster = isMaster;
    }

    @Override
    public boolean hasMaster() {
        return hasMaster;
    }

    @Override
    public void setHasMaster(boolean hasMaster) {
        this.hasMaster = hasMaster;
    }

    @Override
    public ILocationRC getLocation() {
        return new Location(this);
    }

    @Override
    public boolean isInMultiStructure() {
        return this.isMaster || this.hasMaster;
    }

    /*_*********************************************************************************************************
     * Getters for the Master
     */
    @Override
    public ILocationRC getMasterLocation() {
        return masterLocation;
    }

    @Override
    public TileEntity getMasterTileEntity() {
        return masterLocation.getTileEntityAtLocation();
    }

    @Override
    public Block getMasterBlock() {
        return masterLocation.getBlockAtLocation();
    }

    @Override
    public IStructureTileMaster getMaster() {
        try {
            return (IStructureTileMaster) masterLocation.getTileEntityAtLocation();
        } catch (ClassCastException e){
            LogHelper.fatal("Slave: " + this + ". Has invalid master Block! \n" + e);
            return null;
        }
    }

    @Override
    public IStructure.StructureType getActiveStructureType() {
        return this.getMaster().getActiveStructureType();
    }
}
