package nl.scribblon.riftcraft.util.ienergy;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 28-09-14
 */
public interface IRCEnergyBlock {

    /**
     * Arbitrary number Subject to change. Factor of energy that is there when left in the Enderic State.
     */
    double ENERGY_PADDING = 1.2;

    double getTotalEnergy();

    double getVoidEnergy();

    double getRiftEnergy();

    boolean isEnderic();
}
