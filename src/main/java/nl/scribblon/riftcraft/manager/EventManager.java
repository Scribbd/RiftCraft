package nl.scribblon.riftcraft.manager;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import nl.scribblon.riftcraft.event.RiftCraftEvent;
import nl.scribblon.riftcraft.util.ISubscribable;

import java.util.EnumMap;
import java.util.HashSet;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 05-09-14
 *
 * The manager class to which all (Tile)Entities need to subscribe to, to receive a RiftCraft-Event.
 */
public class EventManager {
    /*
     * Singleton Design Pattern
     */
    private static EventManager instance = new EventManager();

    private EventManager() {
        this.subscribers = new EnumMap<RiftCraftEvent.EventType, HashSet<ISubscribable>>(RiftCraftEvent.EventType.class);
        for(RiftCraftEvent.EventType type : RiftCraftEvent.EventType.values()) {
            this.subscribers.put(type, new HashSet<ISubscribable>());
        }
    }

    public static EventManager getInstance(){
        return instance;
    }
    /*
     * End Singleton Design Pattern
     */


    private EnumMap<RiftCraftEvent.EventType, HashSet<ISubscribable>> subscribers;

    @SubscribeEvent
    public void onEvent(RiftCraftEvent event){
        HashSet<ISubscribable> eventSubscribers = this.subscribers.get(RiftCraftEvent.EventType.valueOf(event));

        for (ISubscribable eventSubscriber: eventSubscribers) {
            eventSubscriber.onEvent(event);
            //TODO probably will go wrong, test this.
        }
    }

    public void registerSubscribable(ISubscribable subscribable, RiftCraftEvent.EventType type) {
        if(!this.subscribers.containsKey(type)) return;

        if(this.subscribers.get(type).contains(subscribable)) return;

        this.subscribers.get(type).add(subscribable);
    }

    public void unregisterSubscribable(ISubscribable subscribable, RiftCraftEvent.EventType type) {
        if(!this.subscribers.containsKey(type)) return;

        if(!this.subscribers.get(type).contains(subscribable)) return;

        this.subscribers.get(type).remove(subscribable);
    }

}
