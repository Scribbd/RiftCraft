package nl.scribblon.riftcraft.util.istructure;

import java.util.Map;
import java.util.Set;

/**
 * Created by Scribblon for project RiftCraft.
 * Date Creation: 29-08-14
 */
public interface ILeveledStructure extends IStructure {

    int ROOT_LEVEL = 0;
    int INVALID = -1;
    int INVALID_LEVEL = -1;

    Set<IStructurePart> getParts(int fromLevel, int toLevel);

    Set<IStructurePart> getParts(int level);

    boolean isStructureCorrectFrom(IStructureTileMaster master, int level);

    int getLevel(IStructureTileMaster master);

    Map<IStructurePart, Integer> getLevelMap(int fromLevel, int toLevel);
}
