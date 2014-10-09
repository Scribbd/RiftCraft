package nl.scribblon.riftcraft.item.crystalic;

import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 08-09-14
 *
 * An upgrade from a rift-note. Will never lose the location imprint, but isn't able to 'imprint in the wild'.
 *
 * Planned Features:
 *  - Cannot imprint 'in the wild'.
 *  - Can imprint crystals, but will lose its focus.
 */
public class ItemImprintMatrix extends RCItem {

    public static final int MAX_STACK_SIZE = 1;

    public ItemImprintMatrix() {
        super();
        this.setMaxStackSize(MAX_STACK_SIZE);
        this.setUnlocalizedName(Names.Items.IMPRINT_MATRIX);
    }
}
