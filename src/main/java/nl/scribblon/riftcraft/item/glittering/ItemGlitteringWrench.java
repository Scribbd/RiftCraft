package nl.scribblon.riftcraft.item.glittering;

import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.reference.Reference;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 09-08-14
 *
 * The tool for mid to late game. When used for removal of blocks it will not consume durability.
 * Activation will use 1 durability as usual.
 * Upon breaking it will return the shards used.
 *
 * Planned Feature:
 *  -
 */
public class ItemGlitteringWrench extends RCItem {

    public static final int MAX_DAMAGE = 50;

    public ItemGlitteringWrench(){
        super();
        this.setUnlocalizedName(Names.Items.GLITTERING_WRENCH);
        this.setMaxStackSize(Reference.MAX_STACK_SIZE_TOOL);
        this.setMaxDamage(this.MAX_DAMAGE);
    }
}
