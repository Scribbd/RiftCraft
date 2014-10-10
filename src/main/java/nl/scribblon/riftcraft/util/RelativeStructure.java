package nl.scribblon.riftcraft.util;

import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.istructure.IRelativeStructurePart;
import nl.scribblon.riftcraft.util.istructure.IStructure;
import nl.scribblon.riftcraft.util.istructure.IStructurePart;

import java.util.TreeSet;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-8-2014
 *
 * A structure containing subblocks
 */
public class RelativeStructure implements IStructure {

    protected StructureType type;

    protected IRelativeStructurePart[] parts;
    protected IRelativeStructurePart masterPart;

    public RelativeStructure(StructureType type, IRelativeStructurePart masterPart, IRelativeStructurePart... parts){
        this.type = type;
        this.masterPart = masterPart;

        TreeSet<IRelativeStructurePart> sortedParts =  new TreeSet<IRelativeStructurePart>(new StructurePartComparator());

        for(IRelativeStructurePart part : parts)
            sortedParts.add(part);

        this.parts = sortedParts.toArray(new IRelativeStructurePart[sortedParts.size()]);
    }

    @Override
    public boolean structureSupportsMaster(ILocationRC root) {
        return this.masterPart.isPartValidAt(root);
    }

    @Override
    public boolean isStructureCorrectFrom(ILocationRC root) {
        if(!this.structureSupportsMaster(root)) return false;

        for(IStructurePart structureBlock : this.parts) {
            if(!structureBlock.isPartValidAt(root))
                return false;
        }
        return true;
    }

    @Override
    public StructureType getStructureType() {
        return this.type;
    }

    @Override
    public IStructurePart[] getParts() {
        return this.parts;
    }

    @Override
    public IStructurePart getMasterPart() {
        return this.masterPart;
    }
}