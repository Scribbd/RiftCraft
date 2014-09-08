package nl.scribblon.riftcraft.event.entity;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.Entity;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 09-08-2014
 *
 * This event is fired when an entity (player, tile, etc) is focusing a location into a riftShard.
 * The double (rounded down to an integer) returned are the ticks needed to complete focus.
 *
 * When canceled, focus will not occur.
 */
@Cancelable
public class ShardImprintEvent extends RiftCraftEntityEvent {

    public static final EventType type = EventType.SHARD_FOCUS_EVENT;

    /**
     * The resulting double will determine how long the focus will take (in ticks)
     */
    public double resultingDuration;

    /**
     * A faux cancel will make the player still focus all the way, but the shard will just 'fizzle' upon 'completion'.
     */
    public boolean fauxCancel;

    public ShardImprintEvent(Entity entity, double baseDuration){
        super(entity);
        this.resultingDuration = baseDuration;
        this.fauxCancel = false;
    }
}
