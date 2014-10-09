package nl.scribblon.riftcraft.tileentity;

import nl.scribblon.riftcraft.reference.Energy;
import nl.scribblon.riftcraft.tileentity.structuretileimpl.StructureTileSlaveImpl;
import nl.scribblon.riftcraft.util.helper.RandomHelper;
import nl.scribblon.riftcraft.util.istructure.IStructureTileMaster;
import nl.scribblon.riftcraft.util.istructure.IStructureTileSlave;
import nl.scribblon.riftcraft.util.istructure.IRelativeStructure;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 *
 * The tile entity which comes with activated quartz.
 */
public class TileEntityActivatedQuartz extends StructureTileSlaveImpl {

    public static final String TILE_ENTITY_ID = "rcTEClearQuartz";

    public static final double MAX_ENERGY = 50.0; //arbitrary number, may change in the future
    public static final double CHARGE_CHANCE_RING = 50.0; //percent chance to increase charge on usage in string structure
    public static final double CHARGE_INCREMENT = 1.0; //arbitrary charge number, might add a similar system like the ender shards.

    public static final String STORED_ENERGY_TAG = "storedRiftEnergy";

    public double storedEnergy;

    public TileEntityActivatedQuartz(double charge){
        super();
        this.storedEnergy = charge;
    }

    public TileEntityActivatedQuartz(){
        this(Energy.MIN_ENERGY);
    }

    @Override
    public boolean receiveMultiTileUpdateFromMaster(IStructureTileMaster master) {

        if(master.getActiveStructureType() == IRelativeStructure.StructureType.QUARTZ_RING) {
            RandomHelper rnd = RandomHelper.getInstance();

            if(rnd.rollD100(this.CHARGE_CHANCE_RING)) {
                if(this.storedEnergy + this.CHARGE_INCREMENT >= this.MAX_ENERGY)
                    this.storedEnergy = this.MAX_ENERGY;
                else
                    this.storedEnergy += this.CHARGE_INCREMENT;
            }

            return this.isFull();
        }

        return false;
    }

    @Override
    public boolean canConstructAsSlave(IStructureTileMaster master) {
        return !this.isFull();
    }

    @Override
    public IStructureTileSlave setupAsSlave(IStructureTileMaster master) {
        return this;
    }

    @Override
    public boolean deconstructAsSlave(IStructureTileMaster master) {

        return true;
    }

    public boolean isFull() {
        return this.storedEnergy >= this.MAX_ENERGY;
    }
}
