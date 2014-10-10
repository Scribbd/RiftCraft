package nl.scribblon.riftcraft.util.istructure;

import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 13-10-2014
 *
 * Relative Structure parts need to be able to convert their
 */
public interface IRelativeStructurePart extends IStructurePart {

    IRelativeLocationRC getRelativeLocation();

    ILocationRC getAbsoluteLocation(ILocationRC rootLocation);
}
