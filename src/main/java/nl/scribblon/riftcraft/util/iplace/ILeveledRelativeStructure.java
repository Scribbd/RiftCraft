package nl.scribblon.riftcraft.util.iplace;

import nl.scribblon.riftcraft.util.RelativeStructureBlock;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;

import java.util.Map;
import java.util.Set;

/**
 * Created by Peter on 29-08-14.
 */
public interface ILeveledRelativeStructure extends IRelativeStructure {

    int ROOT_LEVEL = 0;
    int INVALID = -1;
    int INVALID_LEVEL = -1;

    Set<RelativeStructureBlock> getParts(int fromLevel, int toLevel);

    Set<RelativeStructureBlock> getParts(int level);

    boolean isStructureCorrectFrom(IMultiTiledMaster master, int level);

    int getLevel(IMultiTiledMaster master);

    Map<RelativeStructureBlock, Integer> getLevelMap(int fromLevel, int toLevel);
}
