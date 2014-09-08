package nl.scribblon.riftcraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 08-09-14
 *
 * Base Entity used for RiftCraft.
 */
public abstract class RCEntity extends Entity {

    public RCEntity(ILocationRC location) {
        super(location.getWorld());
        this.posX = location.getX();
        this.posY = location.getY();
        this.posZ = location.getZ();
    }

    public void updateLocation(ILocationRC newLocation) {
        this.setWorld(newLocation.getWorld());
        this.setPosition(newLocation.getX(), newLocation.getY(), newLocation.getZ());
    }

    @Override
    protected void entityInit() {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {

    }
}
