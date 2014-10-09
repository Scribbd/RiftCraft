package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class RCModRecipes {

    public static void init(){
    //Micro Family

    //Quartz Family

    //Stones Family

    //Crystalic Family


    //Glittering Family
        //Glittering Dust
        GameRegistry.addShapelessRecipe(new ItemStack(RCModItems.glitteringDust, 2),
                new ItemStack(Items.redstone),
                new ItemStack(Items.redstone),
                new ItemStack(Items.redstone),
                new ItemStack(Items.glowstone_dust));
        //Glittering Orb
        GameRegistry.addShapedRecipe(new ItemStack(RCModItems.glitteringOrb, 1),
                "xyx",
                "yzy",
                "xyx",
                'x', new ItemStack(Items.gold_nugget), 'y', new ItemStack(RCModItems.glitteringDust), 'z', new ItemStack(RCModItems.riftShard));

    //Multi Family

    }
}
