package nl.scribblon.riftcraft.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.ChunkEvent;
import nl.scribblon.riftcraft.manager.RCEventSubscriptionManager;
import nl.scribblon.riftcraft.util.ISubscribable;

import java.util.Collection;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 04-09-14
 * Do not use this. Not needed. But you know coders and their code ;P
 */
@Deprecated
public class ChunkHandler {

    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event) {
        Collection values = event.getChunk().chunkTileEntityMap.values();
        RCEventSubscriptionManager manager = RCEventSubscriptionManager.getInstance();

        for(Object value : values) {
            if (!(value instanceof ISubscribable)) continue;
            manager.registerSubscribeable((ISubscribable) value);
        }
    }

    @SubscribeEvent
    public void onChunkUnload(ChunkEvent.Unload event) {
        Collection values = event.getChunk().chunkTileEntityMap.values();
        RCEventSubscriptionManager manager = RCEventSubscriptionManager.getInstance();

        for(Object value : values) {
            if (!(value instanceof ISubscribable)) continue;
            manager.unregisterSubscribeable((ISubscribable) value);
        }
    }
}
