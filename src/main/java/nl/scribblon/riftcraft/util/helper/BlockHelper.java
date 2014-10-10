package nl.scribblon.riftcraft.util.helper;

import net.minecraft.block.Block;

/**
 * Created by Scribblon for project RiftCraft.
 * Date Creation: 21-10-2014
 */
public class BlockHelper {

    public static boolean isBlockSameByUnlocalizedName(Block aBlock, Block otherBlock) {
        return aBlock.getUnlocalizedName().equals(otherBlock.getUnlocalizedName());
    }
}
