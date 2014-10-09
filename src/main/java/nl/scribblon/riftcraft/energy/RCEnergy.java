package nl.scribblon.riftcraft.energy;

import nl.scribblon.riftcraft.util.ienergy.IRCEnergyBlock;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 28-09-14
 *
 * Energy system.
 * Planned to be flow based. A liquid that needs to reach its destination.
 */
public class RCEnergy {

    public double riftEnergy, voidEnergy;

    public RCEnergy() {
        this.riftEnergy = 0;
        this.voidEnergy = 0;
    }

    public RCEnergy(double riftEnergy, double voidEnergy) {
        this.riftEnergy = riftEnergy;
        this.voidEnergy = voidEnergy;
    }

    public boolean isEnderic() {
        return this.riftEnergy >= 0 && this.voidEnergy >= 0;
    }

    public double getTotalEnergy() {
        if(this.isEnderic()) {
            return (riftEnergy + voidEnergy) * IRCEnergyBlock.ENERGY_PADDING;
        } else {
            return (riftEnergy + voidEnergy);
        }
    }
}
