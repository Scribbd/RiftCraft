package nl.scribblon.riftcraft.event.entity.player;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.player.EntityPlayer;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 08-09-14
 * Whenever player focuses his crystal to depart. This event is fired to see if the departure time must be modified.
 * On cancel player will not depart.
 *
 * Integer will be used as tick taken.
 * FauxCancel is used for the check if the used material will be consumed.
 */
@Cancelable
public class PlayerFocusEvent extends RiftPlayerEvent {

    public final ILocationRC departureLocation;
    public int departureTime;
    public boolean fauxCancel;

    public PlayerFocusEvent(EntityPlayer player, ILocationRC departureLocation, int departureTime) {
        super(player);
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
        this.fauxCancel = false;
    }
}
