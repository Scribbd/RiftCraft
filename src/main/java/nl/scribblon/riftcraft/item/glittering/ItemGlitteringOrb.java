package nl.scribblon.riftcraft.item.glittering;

import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.reference.Reference;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 09-08-14
 *
 * Instead of throwing a pile of Glittering Dust at the item. This item allows the player to be more conservative with their dusts.
 * Only the undamaged orb can be used for further crafting.
 * Can't be placed in the world.
 *
 * Planned Features:
 *  -
 */
public class ItemGlitteringOrb extends RCItem {

    public static final int MAX_DAMAGE = 10;

    public ItemGlitteringOrb(){
        super();
        this.setUnlocalizedName(Names.Items.GLITTERING_ORB);
        this.setMaxStackSize(Reference.MAX_STACK_SIZE_TOOL);
        this.setMaxDamage(this.MAX_DAMAGE);
    }
}
