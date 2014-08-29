package nl.scribblon.riftcraft.util.helper;

import net.minecraft.tileentity.TileEntity;
import nl.scribblon.riftcraft.util.ILocationRC;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.imulti.IMultiTiled;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledSlave;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class with methods usable surrounding Locations.
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-8-2014
 *
 */
public class LocationHelper {

    /**
     * Converts Location Lists to Tile entities. Then to IMultiSlave Implementations.
     * Not in public domain due to possible bugs.
     * @param locationList A List with an implementation or subclass of ILocationRC .
     * @return The List with IMultiTiledSlaves.
     */
    public static ArrayList<IMultiTiledSlave> convertLocationToSlave(List<? extends ILocationRC> locationList) {
        ArrayList<IMultiTiledSlave> blockList = new ArrayList<IMultiTiledSlave>(locationList.size());

        int index = 0;
        for(ILocationRC location : locationList){
            try {
                blockList.set(index++, (IMultiTiledSlave) location.getTileEntityAtLocation());
            } catch(ClassCastException e){
                LogHelper.fatal("SOMETHING WENT WRONG CASTING! \n" + e);
                return blockList;
            }
        }

        return blockList;
    }

    /**
     * Converts IMultiTiledSlave Lists to their base Locations.
     * Not in public domain due to possible bugs.
     * @param blockList A list with implementations of IMultiTiledSlave
     * @return The List with Locations
     */
    public static ArrayList<Location> convertSlaveToLocation(List<? extends IMultiTiledSlave> blockList) {
        ArrayList<Location> locationList = new ArrayList<Location>(blockList.size());

        int index = 0;

        try {
            for(IMultiTiled tile : blockList){
                TileEntity entity = (TileEntity) tile;
                if (entity == null){
                    LogHelper.fatal("SOMETHING WENT WRONG. TILEENTITY (NULL) NOT FOUND WHILE CONVERTING.");
                    return locationList;
                }
                locationList.set(index++, new Location(entity));
            }
        } catch (ClassCastException e){
            LogHelper.fatal("SOMETHING WENT WRONG CASTING! \n" + e);
        } finally {
            return locationList;
        }
    }
}
