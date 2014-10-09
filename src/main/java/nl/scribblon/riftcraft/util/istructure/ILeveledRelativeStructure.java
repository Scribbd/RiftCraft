package nl.scribblon.riftcraft.util.istructure;

import nl.scribblon.riftcraft.util.RelativeStructureBlock;

import java.util.Map;
import java.util.Set;

/**
 * Created by Scribblon for project RiftCraft.
 * Date Creation: 29-08-14
 */
public interface ILeveledRelativeStructure extends IRelativeStructure {

    int ROOT_LEVEL = 0;
    int INVALID = -1;
    int INVALID_LEVEL = -1;

    Set<RelativeStructureBlock> getParts(int fromLevel, int toLevel);

    Set<RelativeStructureBlock> getParts(int level);

    boolean isStructureCorrectFrom(IStructureTileMaster master, int level);

    int getLevel(IStructureTileMaster master);

    Map<RelativeStructureBlock, Integer> getLevelMap(int fromLevel, int toLevel);
}
