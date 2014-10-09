package nl.scribblon.riftcraft.event.energy;

import nl.scribblon.riftcraft.event.RiftCraftEvent;
import nl.scribblon.riftcraft.util.ienergy.IRCEnergyBlock;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 28-09-14
 *
 *
 */
public abstract class EnergyEvent extends RiftCraftEvent {

    final double voidEnergy, riftEnergy;

    final IRCEnergyBlock block;

    public EnergyEvent(IRCEnergyBlock block, double voidEnergy, double riftEnergy) {
        this.block = block;
        this.voidEnergy = voidEnergy;
        this.riftEnergy = riftEnergy;
    }
}
