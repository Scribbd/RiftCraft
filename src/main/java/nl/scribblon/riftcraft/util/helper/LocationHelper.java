package nl.scribblon.riftcraft.util.helper;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkCoordIntPair;
import nl.scribblon.riftcraft.util.Location;
import nl.scribblon.riftcraft.util.imulti.IMultiTiled;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledSlave;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class with methods usable surrounding Locations.
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-8-2014
 *
 */
public final class LocationHelper {


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

    public static ILocationRC[] convertRelativeToAbsolute(IRelativeLocationRC[] relativeLocations, ILocationRC fromLocation){
        ILocationRC[] results = new ILocationRC[relativeLocations.length];
        for(int index = 0; index < relativeLocations.length; ++index)
            results[index] = relativeLocations[index].getILocationRelativelyFrom(fromLocation);

        return results;
    }

    public static boolean isInterDimensional(ILocationRC location1, ILocationRC location2) {
        return location1.getDimensionID() != location2.getDimensionID();
    }

    public static void teleportEntity(Entity entity, ILocationRC location) {
        if(entity.worldObj.isRemote) return;

        entity.setWorld(location.getWorld());
        entity.setPosition(location.getX(), location.getY(), location.getZ());
    }

    public static boolean loadChunk(ILocationRC location) {
        if(!location.getWorld().isRemote) return false;
        if(!location.getWorld().checkChunksExist(location.getIntX(), location.getIntY(), location.getIntZ(),
                location.getIntX(), location.getIntY(), location.getIntZ())) return false;

        //TODO load chunk at location

        return true;

    }

    public static ChunkCoordIntPair getChunkCoordPairAt(ILocationRC location) {
        if(!location.getWorld().checkChunksExist(location.getIntX(), location.getIntY(), location.getIntZ(),
                location.getIntX(), location.getIntY(), location.getIntZ())) return null;

        return location.getWorld().getChunkFromBlockCoords(location.getIntX(), location.getIntZ()).getChunkCoordIntPair();
    }
}
