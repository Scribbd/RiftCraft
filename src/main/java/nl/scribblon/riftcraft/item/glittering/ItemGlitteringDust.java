package nl.scribblon.riftcraft.item.glittering;

import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 09-08-14
 *
 * Item used to activate properties
 *
 * Planned Features:
 *  - Can be used as redstone.
 *      - Each traversed block gives strength -2.
 *      - Lights surrounding with weak light.
 */
public class ItemGlitteringDust extends RCItem {

    public ItemGlitteringDust(){
        super();
        this.setUnlocalizedName(Names.Items.GLITTERING_DUST);
    }
}
