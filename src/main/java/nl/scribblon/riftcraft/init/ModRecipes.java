package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class ModRecipes {

    public static void init(){
        //Glittering Dust
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.glitteringDust, 2),
                new ItemStack(Items.redstone),
                new ItemStack(Items.redstone),
                new ItemStack(Items.redstone),
                new ItemStack(Items.glowstone_dust));
        //Glittering Orb
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.glitteringOrb, 1), "xyx", "yzy", "xyx",
                'x', new ItemStack(Items.gold_nugget),
                'y', new ItemStack(ModItems.glitteringDust),
                'z', new ItemStack(ModItems.riftShard));
        //Glittering Wrench
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.glitteringWrench, 1), "roe", "sms", " m ",
                'r', new ItemStack(ModItems.riftShard),
                'o', new ItemStack(ModItems.glitteringOrb),
                'e', new ItemStack(ModItems.enderShard),
                's', new ItemStack(Items.string),
                'm', new ItemStack(Items.iron_ingot));

        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.enderShardCluster, 1), "ses", "ene", "ses",
                's', new ItemStack(Items.string),
                'e', new ItemStack(ModItems.enderShard),
                'n', new ItemStack(Items.gold_nugget));

        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.riftShardCluster, 1), "srs", "rnr", "srs",
                's', new ItemStack(Items.string),
                'r', new ItemStack(ModItems.riftShard),
                'n', new ItemStack(Items.gold_nugget));
    }
}
