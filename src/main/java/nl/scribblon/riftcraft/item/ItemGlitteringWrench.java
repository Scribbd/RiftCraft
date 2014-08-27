package nl.scribblon.riftcraft.item;

import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Peter on 09-08-14.
 */
public class ItemGlitteringWrench extends RCItem{

    public static final int MAX_DAMAGE = 50;

    public ItemGlitteringWrench(){
        super();
        this.setUnlocalizedName(Names.Items.GLITTERING_WRENCH);
        this.setMaxStackSize(1);
        this.setMaxDamage(MAX_DAMAGE);
    }
}
