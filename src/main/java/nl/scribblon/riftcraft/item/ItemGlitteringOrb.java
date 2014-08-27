package nl.scribblon.riftcraft.item;

import nl.scribblon.riftcraft.reference.Names;

/**
 * Created by Peter on 09-08-14.
 */
public class ItemGlitteringOrb extends RCItem {

    public static final int MAX_DAMAGE = 10;

    public ItemGlitteringOrb(){
        super();
        this.setUnlocalizedName(Names.Items.GLITTERING_ORB);
        this.setMaxStackSize(1);
        this.setMaxStackSize(MAX_DAMAGE);
    }
}
