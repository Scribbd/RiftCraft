package nl.scribblon.riftcraft.event.rift;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.Entity;

/**
 * Created by Peter on 09-08-14.
 */
@Cancelable
public class RiftEnteringEvent extends RiftEvent{

    public final Entity entity;

}
