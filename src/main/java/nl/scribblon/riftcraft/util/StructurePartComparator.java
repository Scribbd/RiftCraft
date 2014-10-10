package nl.scribblon.riftcraft.util;

import nl.scribblon.riftcraft.util.istructure.IRelativeStructurePart;

import java.util.Comparator;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 13-10-2014
 */
public class StructurePartComparator implements Comparator<IRelativeStructurePart> {
    @Override
    public int compare(IRelativeStructurePart onePart, IRelativeStructurePart otherPart) {
        if(onePart.getRelativeLocation().getYShift() < otherPart.getRelativeLocation().getYShift()) return -1;

        if(onePart.getRelativeLocation().getYShift() > otherPart.getRelativeLocation().getYShift()) return +1;

        if(onePart.getRelativeLocation().getZShift() < otherPart.getRelativeLocation().getZShift()) return -1;

        if(onePart.getRelativeLocation().getZShift() > otherPart.getRelativeLocation().getZShift()) return +1;

        if(onePart.getRelativeLocation().getXShift() > otherPart.getRelativeLocation().getXShift()) return -1;

        if(onePart.getRelativeLocation().getXShift() < otherPart.getRelativeLocation().getXShift()) return +1;

        return 0;
    }
}
