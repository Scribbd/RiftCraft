package nl.scribblon.riftcraft.util;

import net.minecraft.block.Block;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;
import nl.scribblon.riftcraft.util.istructure.IRelativeStructurePart;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 14-10-2014
 *
 * TileTypes will search for a TileEntity of a specific implementation.
 * Allows to accept all kinds of ISidedInventory implementation for example.
 */
public class RelativeStructureTileTypePart implements IRelativeStructurePart {

    private RelativeLocation relativeLocation;
    private Class clazz;

    public RelativeStructureTileTypePart(RelativeLocation relativeLocation, Class clazz) {
        this.relativeLocation = relativeLocation;
        this.clazz = clazz;
    }


    @Override
    public IRelativeLocationRC getRelativeLocation() {
        return this.relativeLocation;
    }

    @Override
    public ILocationRC getAbsoluteLocation(ILocationRC rootLocation) {
        return this.relativeLocation.getILocationRelativelyFrom(rootLocation);
    }

    @Override
    public boolean isPartValid(Block block) {
        return block.hasTileEntity(0);
    }

    public boolean isTileValid(ILocationRC location) {
        return clazz.isInstance(location.getTileEntityAtLocation());
    }

    @Override
    public boolean isPartValidAt(ILocationRC rootLocation) {
        return this.isPartValid(this.getAbsoluteLocation(rootLocation).getBlockAtLocation()) && this.isTileValid(this.getAbsoluteLocation(rootLocation));
    }
}
