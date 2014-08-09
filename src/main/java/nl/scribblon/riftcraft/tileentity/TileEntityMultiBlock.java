package nl.scribblon.riftcraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import nl.scribblon.riftcraft.util.IMultiBlocked;
import nl.scribblon.riftcraft.util.Location;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 *
 * TODO delete note
 * x w > e
 * z s > n
 * Y d > u
 */
public abstract class TileEntityMultiBlock extends RCTileEntity implements IMultiBlocked{

    public static final String IS_ACTIVE_TAG = "isActive";
    public static final String X_TAG = "masterLocationX";
    public static final String Y_TAG = "masterLocationY";
    public static final String Z_TAG = "masterLocationZ";

    public boolean isActive;
    public int masterX;
    public int masterY;
    public int masterZ;

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setBoolean(IS_ACTIVE_TAG, isActive);
        tagCompound.setInteger(X_TAG, masterX);
        tagCompound.setInteger(Y_TAG, masterY);
        tagCompound.setInteger(Z_TAG, masterZ);
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        this.isActive = tagCompound.getBoolean(IS_ACTIVE_TAG);
        this.masterX = tagCompound.getInteger(X_TAG);
        this.masterY = tagCompound.getInteger(Y_TAG);
        this.masterZ = tagCompound.getInteger(Z_TAG);
    }

    @Override
    public Packet getDescriptionPacket() {
        return super.getDescriptionPacket();
    }

    @Override
    public TileEntity getMasterBlock() {
        return this.getWorldObj().getTileEntity(masterX, masterY, masterZ);
    }

    @Override
    public boolean isActive() {
        return isActive;
    }
}
