package nl.scribblon.riftcraft.util;

import nl.scribblon.riftcraft.event.RiftCraftEvent;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 04-09-14
 *
 * Interface which needs to be implemented to
 */
public interface ISubscribable<T extends RiftCraftEvent> {

    void onEvent(T t);

}
