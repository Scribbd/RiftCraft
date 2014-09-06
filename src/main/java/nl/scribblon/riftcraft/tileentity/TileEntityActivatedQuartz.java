package nl.scribblon.riftcraft.tileentity;

import net.minecraft.init.Blocks;
import nl.scribblon.riftcraft.tileentity.multiimpl.TileEntityMultiImpl;
import nl.scribblon.riftcraft.util.helper.RandomHelper;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledSlave;
import nl.scribblon.riftcraft.util.iplace.IRelativeStructure;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 8-8-2014
 *
 * The tile entity which comes with activated quartz.
 */
public class TileEntityActivatedQuartz extends TileEntityMultiImpl implements IMultiTiledSlave {

    public static final String TILE_ENTITY_ID = "rcTEClearQuartz";

    public static final double MAX_ENERGY = 50; //arbitrary number, may change in the future
    public static final double CHARGE_CHANCE_RING = 50.0; //percent chance to increase charge on usage in string structure
    public static final double CHARGE_INCREMENT = 1.0; //arbitrary charge number, might add a similar system like the ender shards.

    public static final String STORED_ENERGY_TAG = "storedRiftEnergy";

    public double storedEnergy;

    public TileEntityActivatedQuartz(double charge){
        super();
        this.storedEnergy = charge;
    }

    public TileEntityActivatedQuartz(){
        this(MAX_ENERGY);
    }

    @Override
    public boolean receiveMultiTileUpdateFromMaster(IMultiTiledMaster master) {

        if(master.getActiveStructureType() == IRelativeStructure.StructureType.QUARTZ_RING) {
            RandomHelper rnd = RandomHelper.getInstance();

            if(rnd.rollD100(this.CHARGE_CHANCE_RING)) {
                if(this.storedEnergy + this.CHARGE_INCREMENT >= this.MAX_ENERGY)
                    this.storedEnergy = this.MAX_ENERGY;
                else
                    this.storedEnergy += this.CHARGE_INCREMENT;
            }

            return this.storedEnergy >= this.MAX_ENERGY;
        }

        return false;
    }

    @Override
    public boolean canConstructAsSlave(IMultiTiledMaster master) {
        return false;
    }

    @Override
    public IMultiTiledSlave setupAsSlave(IMultiTiledMaster master) {
        return this;
    }

    @Override
    public boolean deconstructAsSlave(IMultiTiledMaster master) {
        this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, Blocks.quartz_block);
        this.invalidate();
        return true;
    }
}
