package nl.scribblon.riftcraft.item.glittering;

import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.reference.Reference;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 08-09-14
 *
 * Not a weapon, more the end-game wrench that doesn't lose durability upon of activation of anything.
 *
 * Planned Features:
 *  - Repairs itself when it does take damage.
 */
public class ItemGlitteringFork extends RCItem {

    public static final int MAX_DAMAGE = 999; //The devil is close with this one

    public ItemGlitteringFork() {
        super();
        this.setUnlocalizedName(Names.Items.GLITTERING_FORK);
        this.setMaxStackSize(Reference.MAX_STACK_SIZE_TOOL);
        this.setMaxDamage(MAX_DAMAGE);
    }


}
