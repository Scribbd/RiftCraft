package nl.scribblon.riftcraft.util.istructure;

import net.minecraft.block.Block;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Created by Scribblon for project RiftCraft.
 * Date Creation: 9-10-2014
 *
 * Interface for a class to be a part of a structure.
 */
public interface IStructurePart {

    boolean isPartValid(Block block);

    boolean isPartValidAt(ILocationRC rootLocation);
}
