package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class ModRecipes {

    public static void init(){
        //Glittering Dust
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.glitteringDust, 2), new ItemStack(Items.redstone), new ItemStack(Items.redstone), new ItemStack(Items.redstone), new ItemStack(Items.glowstone_dust));

    }
}
