package nl.scribblon.riftcraft.util;

import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;
import nl.scribblon.riftcraft.util.iplace.ILeveledRelativeStructure;

import java.util.*;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-8-2014
 */
public class LeveledRelativeStructure implements ILeveledRelativeStructure {

    private ArrayList<RelativeStructure> levels;
    private StructureType type;

    public LeveledRelativeStructure(StructureType type, RelativeStructure... levels){
        this.type = type;
        this.levels = new ArrayList<RelativeStructure>(levels.length);
        for(RelativeStructure level : levels)
            this.levels.add(level);
    }

    @Override
    public Set<RelativeStructureBlock> getParts(int level) {
        return this.levels.get(level).getParts();
    }

    @Override
    public Set<RelativeStructureBlock> getParts(int fromLevel, int toLevel) {
        TreeSet<RelativeStructureBlock> results = new TreeSet<RelativeStructureBlock>();

        for(int level = fromLevel; level < toLevel; ++level) {
            results.addAll(levels.get(level).getParts());
        }

        return results;
    }

    @Override
    public Set<RelativeStructureBlock> getParts() {
        TreeSet<RelativeStructureBlock> all = new TreeSet<RelativeStructureBlock>();
        for(RelativeStructure structureLevel : this.levels)
            all.addAll(structureLevel.getParts());
        return all;
    }

    @Override
    public boolean isStructureCorrectFrom(IMultiTiledMaster master, int toLevel) {
        return this.getLevel(master) == toLevel;
    }

    @Override
    public int getLevel(IMultiTiledMaster master) {
        if(!this.structureSupportsMaster(master)) return INVALID;

        for(Map.Entry<RelativeStructureBlock, Integer> set : this.getLevelMap(ROOT_LEVEL, levels.size()).entrySet()) {
            if(!set.getKey().isBlockSupportedRelativeTo(master))
                return set.getValue() - 1;
        }
        return INVALID;
    }

    @Override
    public Map<RelativeStructureBlock, Integer> getLevelMap(int fromLevel, int toLevel) {
        LinkedHashMap<RelativeStructureBlock, Integer> levelMap = new LinkedHashMap<RelativeStructureBlock, Integer>();

        for(int levelValue = fromLevel; levelValue < toLevel && levelValue < this.levels.size(); ++levelValue) {
            for(RelativeStructureBlock block : this.getParts(levelValue)) {
                levelMap.put(block, levelValue);
            }
        }

        return levelMap;
    }

    @Override
    public RelativeStructureBlock getRoot() {
        return this.levels.get(ROOT_LEVEL).getRoot();
    }

    @Override
    public StructureType getStructureType() {
        return this.type;
    }

    @Override
    public boolean structureSupportsMaster(IMultiTiledMaster master) {
        return this.levels.get(ROOT_LEVEL).structureSupportsMaster(master);
    }

    @Override
    public boolean isStructureCorrectFrom(IMultiTiledMaster master) {
        return this.isStructureCorrectFrom(master, levels.size());
    }
}
