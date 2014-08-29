package nl.scribblon.riftcraft.util;

import net.minecraft.block.Block;
import nl.scribblon.riftcraft.util.imulti.IMultiTiledMaster;

import java.util.Arrays;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-8-2014
 */
public class RelativeStructureBlock extends RelativeLocation implements Comparable {

    public static final RelativeStructureBlock ROOT = new RelativeStructureBlock(0,0,0);

    private Block[] allowedStructureParts;

    private RelativeStructureBlock(boolean isInterDimensional, double x, double y, double z) {
        super(isInterDimensional, x,y,z);
        this.allowedStructureParts = null;
    }


    public RelativeStructureBlock(boolean isInterDimensional, double x, double y, double z, Block... allowedStructureParts) {
        super(isInterDimensional, x, y, z);
        this.allowedStructureParts = allowedStructureParts;
    }

    public RelativeStructureBlock(double x, double y, double z, Block... allowedStructureParts) {
        super(x, y, z);
        this.allowedStructureParts = allowedStructureParts;
    }

    public Block[] getAllowedStructureParts(){
        return this.allowedStructureParts;
    }

    public boolean isBlockSupported(Block block) {
        if (allowedStructureParts.length <= 0) return false;

        for (Block allowedPart : allowedStructureParts) {
            if (allowedPart.equals(block))
                return true;
        }

        return false;
    }

    public boolean isBlockSupportedRelativeTo(IMultiTiledMaster master) {
        return this.isBlockSupported(this.getBlockRelativeTo(master.getLocation()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelativeStructureBlock)) return false;
        if (!super.equals(o)) return false;

        RelativeStructureBlock that = (RelativeStructureBlock) o;

        if (!Arrays.equals(allowedStructureParts, that.allowedStructureParts)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(allowedStructureParts);
        return result;
    }

    @Override
    public int compareTo(Object o) throws ClassCastException {
        if(!(o instanceof RelativeStructureBlock))
            throw new ClassCastException("A Relative Structure Part was expected.");

        RelativeStructureBlock that = (RelativeStructureBlock) o;

        if(this.getYShift() < that.getYShift()) return -1;

        if(this.getYShift() > that.getYShift()) return +1;

        if(this.getZShift() < that.getZShift()) return -1;

        if(this.getZShift() > that.getZShift()) return +1;

        if(this.getXShift() > that.getXShift()) return -1;

        if(this.getXShift() < that.getXShift()) return +1;

        return 0;

    }
}