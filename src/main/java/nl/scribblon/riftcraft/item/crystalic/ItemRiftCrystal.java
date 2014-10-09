package nl.scribblon.riftcraft.item.crystalic;

import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 *
 * The upgraded version of RiftShards. Isn't consumed upon consumption. Is rechargeable.
 */
public class ItemRiftCrystal extends RCItem {

    public static final int MAX_STACK_SIZE = 1;

    public ItemRiftCrystal() {
        super();
        this.setMaxStackSize(this.MAX_STACK_SIZE);
        this.setUnlocalizedName(Names.Items.RIFT_CRYSTAL);
    }
}
