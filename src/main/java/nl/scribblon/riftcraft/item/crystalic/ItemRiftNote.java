package nl.scribblon.riftcraft.item.crystalic;

import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 1-8-2014
 *
 * Rift notes are the early game mechanic to store locations. They can maintain an imprint longer than a Rift Crystal.
 * It can also be used in machines.
 *
 * Planned features:
 *  - Destabilization time *4.
 *      > Upon imprint transfer
 *  - Upon imprinting a rift-shard 'in the wild' the note will be consumed.
 *      > Resetting in the wild does not consume the note.
 *  - Upon imprinting within a imprinting device it will only lose its 'sacrificing material' (micro item)
 *      > This micro item can be applied to the rift note in the inventory of the player.
 *  - Cannot rift
 */
public class ItemRiftNote extends RCItem {

    public static final int MAX_STACK_SIZE = 32;

    public ItemRiftNote() {
        super();
        this.setMaxStackSize(MAX_STACK_SIZE);
        this.setUnlocalizedName(Names.Items.RIFT_NOTE);
    }


}
