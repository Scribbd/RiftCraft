package nl.scribblon.riftcraft.util;

import net.minecraft.block.Block;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;
import nl.scribblon.riftcraft.util.istructure.IRelativeStructurePart;

import java.util.Arrays;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-8-2014
 *
 * A SubBlockArray when multiple types of blocks are accepted.
 */
public class RelativeStructureBlockArray implements IRelativeStructurePart {

    private Block[] allowedStructureParts;  //Should maybe make this dynamic... But as far as I can see this is not needed.
                                            //Might be changed to OreDictionary compatible things... Maybe it is already...
    private RelativeLocation relativeLocation;

    public RelativeStructureBlockArray(RelativeLocation relativeLocation, Block... allowedStructureParts) {
        this.relativeLocation = relativeLocation;
        this.allowedStructureParts = allowedStructureParts;
    }

    @Override
    public boolean isPartValid(Block block) {
        if (allowedStructureParts.length <= 0) return false;

        for (Block allowedPart : allowedStructureParts) {
            if (allowedPart.getUnlocalizedName().equals(block.getUnlocalizedName()))
                return true;
        }

        return false;
    }

    @Override
    public boolean isPartValidAt(ILocationRC rootLocation) {
        return this.isPartValid(this.relativeLocation.getBlockRelativelyFrom(rootLocation));
    }

    @Override
    public IRelativeLocationRC getRelativeLocation() {
        return this.relativeLocation;
    }

    @Override
    public ILocationRC getAbsoluteLocation(ILocationRC root) {
        return this.getRelativeLocation().getILocationRelativelyFrom(root);
    }

    public Block[] getAllowedStructureParts(){
        return this.allowedStructureParts;
    }

    /*_*********************************************************************************************************
     * Auto-Generated things
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelativeStructureBlockArray)) return false;
        if (!super.equals(o)) return false;

        RelativeStructureBlockArray that = (RelativeStructureBlockArray) o;

        if (!Arrays.equals(allowedStructureParts, that.allowedStructureParts)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = relativeLocation.hashCode();
        result = 31 * result + Arrays.hashCode(allowedStructureParts);
        return result;
    }
}