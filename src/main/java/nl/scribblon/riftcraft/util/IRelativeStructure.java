package nl.scribblon.riftcraft.util;

import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;

import java.util.Set;

/**
 * Created by Peter on 29-08-14.
 */
public interface IRelativeStructure {


    Set<RelativeStructureBlock> getParts();

    RelativeStructureBlock getRoot();

    boolean structureSupportsMaster(IMultiTiledMaster master);

    boolean isStructureCorrectFrom(IMultiTiledMaster master);
}
