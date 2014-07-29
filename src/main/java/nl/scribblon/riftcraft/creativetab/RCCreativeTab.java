package nl.scribblon.riftcraft.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nl.scribblon.riftcraft.init.ModItems;
import nl.scribblon.riftcraft.reference.Reference;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class RCCreativeTab {

    public static final CreativeTabs RC_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return ModItems.riftShard;
        }

        @Override
        public String getTranslatedTabLabel(){
            return Reference.MOD_NAME;
        }
    };
}
