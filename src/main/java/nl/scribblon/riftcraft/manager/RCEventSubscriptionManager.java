package nl.scribblon.riftcraft.manager;

import net.minecraftforge.common.MinecraftForge;
import nl.scribblon.riftcraft.util.ISubscribable;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 04-09-14
 *
 * Manager for the old implementation of the SubscriptionManager.
 */
@Deprecated
public class RCEventSubscriptionManager {

    /*
     * Singleton Design Pattern
     */
    private static RCEventSubscriptionManager instance = new RCEventSubscriptionManager();

    private RCEventSubscriptionManager() {
    }

    public static RCEventSubscriptionManager getInstance(){
        return instance;
    }
    /*
     * End Singleton Design Pattern
     */

    public void registerSubscribeable(ISubscribable subscribeable) {
        MinecraftForge.EVENT_BUS.register(subscribeable);
    }

    public void unregisterSubscribeable(ISubscribable subscribeable) {
        MinecraftForge.EVENT_BUS.unregister(subscribeable);
    }
}
