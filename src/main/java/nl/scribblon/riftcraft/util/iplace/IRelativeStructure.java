package nl.scribblon.riftcraft.util.iplace;

import nl.scribblon.riftcraft.util.RelativeStructureBlock;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;

import java.util.Set;

/**
 * Created by Peter on 29-08-14.
 */
public interface IRelativeStructure {

    /*_*********************************************************************************************************
     * Functions to determine if a location is fit for use
     */
    boolean structureSupportsMaster(IMultiTiledMaster master);

    boolean isStructureCorrectFrom(IMultiTiledMaster master);

    /*_*********************************************************************************************************
     * Normal (simple) getters
     */
    Set<RelativeStructureBlock> getParts();

    RelativeStructureBlock getRoot();
}
