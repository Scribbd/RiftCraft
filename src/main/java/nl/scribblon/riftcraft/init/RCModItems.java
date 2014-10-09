package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import nl.scribblon.riftcraft.item.RCItem;
import nl.scribblon.riftcraft.item.crystalic.ItemImprintMatrix;
import nl.scribblon.riftcraft.item.crystalic.ItemImprintedRiftNote;
import nl.scribblon.riftcraft.item.crystalic.ItemRiftCrystal;
import nl.scribblon.riftcraft.item.crystalic.ItemRiftNote;
import nl.scribblon.riftcraft.item.crystalic.shard.ItemEndericShard;
import nl.scribblon.riftcraft.item.crystalic.shard.ItemImprintedRiftShard;
import nl.scribblon.riftcraft.item.crystalic.shard.ItemRiftShard;
import nl.scribblon.riftcraft.item.glittering.*;
import nl.scribblon.riftcraft.item.micro.*;
import nl.scribblon.riftcraft.reference.Names;
import nl.scribblon.riftcraft.reference.Reference;
//@formatter:off
/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 *
 * All the items.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class RCModItems {

    //Crystalic family
    public static final RCItem endericShard = new ItemEndericShard();
    public static final RCItem riftShard = new ItemRiftShard();
    public static final RCItem imprintedRiftShard = new ItemImprintedRiftShard();
    public static final RCItem riftCrystal = new ItemRiftCrystal();
    public static final RCItem riftNote = new ItemRiftNote();
    public static final RCItem imprintedRiftNote = new ItemImprintedRiftNote();
    public static final RCItem imprintMatrix = new ItemImprintMatrix();

    //Glittering family
    public static final RCItem glitteringDust = new ItemGlitteringDust();
    public static final RCItem glitteringOrb = new ItemGlitteringOrb();
    public static final RCItem glitteringWrench = new ItemGlitteringWrench();
    public static final RCItem glitteringFork = new ItemGlitteringFork();
    public static final RCItem glitteringTorch = new ItemGlitteringTorch();

    //Micro family
    public static final RCItem quartzRod = new ItemQuartzRod();
    public static final RCItem quartzPlate = new ItemQuartzPlate();
    public static final RCItem bareToolHead = new ItemBareToolHead();
    public static final RCItem wrenchToolHead = new ItemWrenchToolHead();
    public static final RCItem forkToolHead = new ItemForkToolHead();
    public static final RCItem energyIsolator = new ItemEnergyIsolator();
    public static final RCItem energyIsolationUnit = new ItemEnergyIsolationUnit();
    public static final RCItem isolatedShard = new ItemIsolatedShard();
    public static final RCItem isolatedMatrix = new ItemIsolatedMatrix();
    public static final RCItem energyExchanger = new ItemEnergyExchanger();

    public static void init() {
    //Crystalic family
        GameRegistry.registerItem(endericShard, Names.Items.ENDERIC_SHARD);
        GameRegistry.registerItem(riftShard, Names.Items.RIFT_SHARD);
        GameRegistry.registerItem(imprintedRiftShard, Names.Items.IMPRINTED_RIFT_SHARD);
        GameRegistry.registerItem(riftCrystal, Names.Items.RIFT_CRYSTAL);
        GameRegistry.registerItem(riftNote, Names.Items.RIFT_NOTE);
        GameRegistry.registerItem(imprintedRiftNote, Names.Items.IMPRINTED_RIFT_NOTE);
        GameRegistry.registerItem(imprintMatrix, Names.Items.IMPRINT_MATRIX);

    //Glittering family
        GameRegistry.registerItem(glitteringDust, Names.Items.GLITTERING_DUST);
        GameRegistry.registerItem(glitteringOrb, Names.Items.GLITTERING_ORB);
        GameRegistry.registerItem(glitteringWrench, Names.Items.GLITTERING_WRENCH);
        GameRegistry.registerItem(glitteringFork, Names.Items.GLITTERING_FORK);
        GameRegistry.registerItem(glitteringTorch, Names.Items.GLITTERING_TORCH);

    //Micro family
        GameRegistry.registerItem(quartzRod, Names.Items.QUARTZ_ROD);
        GameRegistry.registerItem(quartzPlate, Names.Items.QUARTZ_PLATE);
        GameRegistry.registerItem(bareToolHead, Names.Items.BARE_TOOL_HEAD);
        GameRegistry.registerItem(wrenchToolHead, Names.Items.WRENCH_TOOL_HEAD);
        GameRegistry.registerItem(forkToolHead, Names.Items.FORK_TOOL_HEAD);
        GameRegistry.registerItem(energyIsolator, Names.Items.ENERGY_ISOLATOR);
        GameRegistry.registerItem(energyIsolationUnit, Names.Items.ENERGY_ISOLATION_UNIT);
        GameRegistry.registerItem(isolatedShard, Names.Items.ISOLATED_SHARD);
        GameRegistry.registerItem(isolatedMatrix, Names.Items.ISOLATED_MATRIX);
        GameRegistry.registerItem(energyExchanger, Names.Items.ENERGY_EXCHANGER);
    }
}
//@formatter:on
