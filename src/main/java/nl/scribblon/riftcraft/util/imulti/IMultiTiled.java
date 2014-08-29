package nl.scribblon.riftcraft.util.imulti;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import nl.scribblon.riftcraft.util.ILocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 */
public interface IMultiTiled {

    /**
     * Forces implementation to keep track of their Master Status.
     * @return boolean when true the implementation is the master, false it isn't. This does not mean that this block is a slave.
     */
    public boolean isMaster();

    /**
     * Forces implementation to keep track of their Master Status.
     * @param isMaster boolean
     */
    public void setIsMaster(boolean isMaster);

    /**
     * Forces implementaion to keep track of their Slave Status.
     * @return boolean when true the implementation is the slave, false it isn't. This does not mean that this block is a master.
     */
    public boolean hasMaster();

    /**
     * Forces implementation to keep track of their Slave Status.
     * @param hasMaster boolean
     */
    public void setHasMaster(boolean hasMaster);

    /**
     * Get the master.
     * @return IMultiTiledMaster implementation of the master.
     */
    public IMultiTiledMaster getMaster();

    /**
     * Get the Master Location.
     * @return LocationRC implementation of the master.
     */
    public ILocationRC getMasterLocation();

    /**
     * Get the Master TileEntity.
     * @return TileEntity implementation of the master.
     */
    public TileEntity getMasterTileEntity();

    /**
     * Get the Block of the IMultiTiledImplementation
     * @return Block blockType of the thing
     */
    public Block getBlockType();

    /**
     * Get Location of current entity.
     * @return ILocationRC of current entity
     */
    public ILocationRC getLocation();

    /**
     * Simple function to check if entity is already in a structure.
     * @return
     */
    public boolean isInMultiStructure();

    /**
     * Allows (and forces) all blocks of an MultiEntity to identify what kind of structure it is part of.
     * @return MultiEntityType, MultiEntityType.UNSET when not present.
     */
    public IMultiTiledMaster.MultiEntityType getMultiEntityType();
}
