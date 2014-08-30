package nl.scribblon.riftcraft.util;

import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;
import nl.scribblon.riftcraft.util.iplace.IRelativeStructure;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-8-2014
 */
public class RelativeStructure implements IRelativeStructure {

    private TreeSet<RelativeStructureBlock> parts;

    public RelativeStructure(RelativeStructureBlock... parts){
        this.parts = new TreeSet<RelativeStructureBlock>();
        for(RelativeStructureBlock part : parts)
            this.parts.add(part);
    }

    @Override
    public Set<RelativeStructureBlock> getParts() {
        return this.parts;
    }

    @Override
    public RelativeStructureBlock getRoot() {
        return parts.subSet(RelativeStructureBlock.ROOT, RelativeStructureBlock.ROOT).first();
    }

    @Override
    public boolean structureSupportsMaster(IMultiTiledMaster master) {
        return this.getRoot().isBlockSupported(master.getBlockType());
    }

    @Override
    public boolean isStructureCorrectFrom(IMultiTiledMaster master) {
        if(!this.structureSupportsMaster(master)) return false;

        for(RelativeStructureBlock structureBlock : this.parts) {
            if(!structureBlock.isBlockSupportedRelativeTo(master))
                return false;
        }
        return true;
    }
}