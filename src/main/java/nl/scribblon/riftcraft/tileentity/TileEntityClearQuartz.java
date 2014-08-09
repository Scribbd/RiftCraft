package nl.scribblon.riftcraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import nl.scribblon.riftcraft.util.IMultiBlockedSlave;
import nl.scribblon.riftcraft.util.RandomHelper;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 */
public class TileEntityClearQuartz extends TileEntityMultiBlock implements IMultiBlockedSlave {

    public static final String TILE_ENTITY_ID = "rcTEClearQuartz";

    public static final double MAX_ENERGY = 50; //arbitrary number, may change in the future
    public static final double CHARGE_CHANCE_RING = 50.0; //percent chance to increase charge on usage in string structure
    public static final double CHARGE_INCREMENT = 1.0; //arbitrary charge number, might add a similar system like the ender shards.

    public static final String STORED_ENERGY_TAG = "storedRiftEnergy";

    public double storedEnergy;

    public TileEntityClearQuartz(double charge){
        super();
        this.storedEnergy = charge;
    }

    public TileEntityClearQuartz(){
        this(MAX_ENERGY);
    }

    @Override
    public boolean receiveMasterTick() {
        if(RandomHelper.rollD100(CHARGE_CHANCE_RING)) this.storedEnergy =+ CHARGE_INCREMENT;

        return this.storedEnergy >= MAX_ENERGY;
    }

    @Override
    public TileEntity setup(TileEntity master) {
        this.isActive = true;
        this.masterX = master.xCoord;
        this.masterY = master.yCoord;
        this.masterZ = master.zCoord;

        return this;
    }

    @Override
    public TileEntity reset(TileEntity master) {
        this.isActive = false;

        this.masterX = 0;
        this.masterY = 0;
        this.masterZ = 0;

        return this;
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setDouble(STORED_ENERGY_TAG, this.storedEnergy);
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        this.storedEnergy = tagCompound.getDouble(STORED_ENERGY_TAG);
    }
}
