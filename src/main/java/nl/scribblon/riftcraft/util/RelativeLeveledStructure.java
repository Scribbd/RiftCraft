package nl.scribblon.riftcraft.util;

import nl.scribblon.riftcraft.util.istructure.ILeveledStructure;
import nl.scribblon.riftcraft.util.istructure.IStructureTileMaster;

import java.util.*;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-8-2014
 */
public class RelativeLeveledStructure implements ILeveledStructure {

    private ArrayList<RelativeStructure> levels;
    private StructureType type;

    public RelativeLeveledStructure(StructureType type, RelativeStructure... levels){
        this.type = type;
        this.levels = new ArrayList<RelativeStructure>(levels.length);
        for(RelativeStructure level : levels)
            this.levels.add(level);
    }

    @Override
    public Set<RelativeStructureBlockArray> getParts(int level) {
        return this.levels.get(level).getParts();
    }

    @Override
    public Set<RelativeStructureBlockArray> getParts(int fromLevel, int toLevel) {
        TreeSet<RelativeStructureBlockArray> results = new TreeSet<RelativeStructureBlockArray>();

        for(int level = fromLevel; level < toLevel; ++level) {
            results.addAll(levels.get(level).getParts());
        }

        return results;
    }

    @Override
    public Set<? extends nl.scribblon.riftcraft.util.istructure.IStructurePart> getParts() {
        TreeSet<RelativeStructureBlockArray> all = new TreeSet<RelativeStructureBlockArray>();
        for(RelativeStructure structureLevel : this.levels)
            all.addAll(structureLevel.getParts());
        return all;
    }

    @Override
    public boolean isStructureCorrectFrom(IStructureTileMaster master, int toLevel) {
        return this.getLevel(master) == toLevel;
    }

    @Override
    public int getLevel(IStructureTileMaster master) {
        if(!this.structureSupportsMaster(master)) return INVALID;

        for(Map.Entry<RelativeStructureBlockArray, Integer> set : this.getLevelMap(ROOT_LEVEL, levels.size()).entrySet()) {
            if(!set.getKey().isBlockSupportedRelativeTo(master))
                return set.getValue() - 1;
        }
        return INVALID;
    }

    @Override
    public Map<RelativeStructureBlockArray, Integer> getLevelMap(int fromLevel, int toLevel) {
        LinkedHashMap<RelativeStructureBlockArray, Integer> levelMap = new LinkedHashMap<RelativeStructureBlockArray, Integer>();

        for(int levelValue = fromLevel; levelValue < toLevel && levelValue < this.levels.size(); ++levelValue) {
            for(RelativeStructureBlockArray block : this.getParts(levelValue)) {
                levelMap.put(block, levelValue);
            }
        }

        return levelMap;
    }

    @Override
    public RelativeStructureBlockArray getMasterPart() {
        return this.levels.get(ROOT_LEVEL).getMasterPart();
    }

    @Override
    public StructureType getStructureType() {
        return this.type;
    }

    @Override
    public boolean structureSupportsMaster(IStructureTileMaster master) {
        return this.levels.get(ROOT_LEVEL).structureSupportsMaster(master);
    }

    @Override
    public boolean isStructureCorrectFrom(IStructureTileMaster master) {
        return this.isStructureCorrectFrom(master, levels.size());
    }
}
