package nl.scribblon.riftcraft.util.imulti;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 */
public interface IMultiTiled {

    /**
     * Forces implementation to keep track of their Master Status.
     * @return boolean when true the implementation is the master, false it isn't. This does not mean that this block is a slave.
     */
    boolean isMaster();

    /**
     * Forces implementation to keep track of their Master Status.
     * @param isMaster boolean
     */
    void setIsMaster(boolean isMaster);

    /**
     * Forces implementaion to keep track of their Slave Status.
     * @return boolean when true the implementation is the slave, false it isn't. This does not mean that this block is a master.
     */
    boolean hasMaster();

    /**
     * Forces implementation to keep track of their Slave Status.
     * @param hasMaster boolean
     */
    void setHasMaster(boolean hasMaster);

    /**
     * Get the master.
     * @return IMultiTiledMaster implementation of the master.
     */
    IMultiTiledMaster getMaster();

    /**
     * Get the Master Location.
     * @return LocationRC implementation of the master.
     */
    ILocationRC getMasterLocation();

    /**
     * Get the Master TileEntity.
     * @return TileEntity implementation of the master.
     */
    TileEntity getMasterTileEntity();

    /**
     * Get the Block of the IMultiTiledImplementation
     * @return Block blockType of the thing
     */
    Block getBlockType();

    /**
     * Get Location of current entity.
     * @return ILocationRC of current entity
     */
    ILocationRC getLocation();

    /**
     * Simple function to check if entity is already in a structure.
     * @return
     */
    boolean isInMultiStructure();

    /**
     * Allows (and forces) all blocks of an MultiEntity to identify what kind of structure it is part of.
     * @return MultiEntityType, MultiEntityType.UNSET when not present.
     */
    IMultiTiledMaster.MultiEntityType getMultiEntityType();

    /**
     * Get blocktype of the the master. Could be done through .getMasterLocation().getBlockAtLocation()... Still
     * Overimplementation FTW! \o/
     * @return
     */
    Block getMasterBlockType();
}
