package nl.scribblon.riftcraft.block.multi;

import net.minecraft.block.material.Material;
import nl.scribblon.riftcraft.block.RCBlock;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 09-09-14
 *
 * Abstract class for all things Mutli Blocky
 * (Can be removed if it keeps like this)
 */
public abstract class RCMultiBlock extends RCBlock {

    public RCMultiBlock(Material material) {
        super(material);
    }

    public RCMultiBlock() {
        super();
    }
}
