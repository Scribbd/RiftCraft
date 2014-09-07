package nl.scribblon.riftcraft.reference;

import net.minecraft.init.Blocks;
import nl.scribblon.riftcraft.init.ModBlocks;
import nl.scribblon.riftcraft.util.*;
import nl.scribblon.riftcraft.util.iplace.IRelativeStructure;

//@formatter:off
/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 06-09-14
 *
 * Reference of existing structures in RiftCraft.
 *
 * Definition for game periods:
 * Zero: (Magic)
 *  Crafting mostly through world interaction.
 *  Mostly vanilla items with modified abilities.
 *  No Power Management
 *
 * Early:
 *  Crafting structures ease up the need of explosive crafting recipes.
 *  Discovery of storage function of Activated Quartz.
 *  Simple RiftStones, DisruptionStones usage.
 *  Very Low Level Management (Simple Storage)
 *
 * Mid:
 *  RiftShard.
 *  RiftStone Well, DisruptionStoneWell
 *  Low Level Power Management (Simple Storage/ Harvesting)
 *
 * Late: (TechnoMagic)
 *  RiftCrystals, FocusMatrix.
 *  Rifting/Disruption Well.
 *  High Power Management (Advanced Storage/ Harvesting/ Basic Refinement)
 *
 * End:
 *  Discovery of void energy.
 *  Intensive Power Management (Advanced Storage/ Generation/ Advanced Refinement)
 *
 * VOID: (Techno)
 *  Currently not solidified. Something with world generation etc. Will probably function more as admin machines who like to RP their bans.
 *  But one structure (not yet defined here) will be part of it: "The Infernal Machine"
 *  Very Intensive Power Management (VOID)
 */
public class Structures {
//<editor-fold desc="Crafting Structures">
    /*_****************************************************************************************************************
     * Quartz Ring (Early Game)
     * The first crafting multi block for crafting RiftCraft items in a more automated fashion.
     * Planned items:
     *  - EnderShards
     *  - Activated Quartz Pieces
     *
     *  The higher the level the bigger chance on extra (positive) effects.
     */
    public static final RelativeStructure QUARTZ_RING_LVL1 = new RelativeStructure(IRelativeStructure.StructureType.QUARTZ_RING,
            new RelativeStructureBlock(1, 0, 1, ModBlocks.activatedQuartz),     new RelativeStructureBlock(0, 0, 1, ModBlocks.activatedQuartz),     new RelativeStructureBlock(-1, 0, 1, ModBlocks.activatedQuartz),
            new RelativeStructureBlock(1, 0, 0, ModBlocks.activatedQuartz),     new RelativeStructureBlock(0, 0, 0, Blocks.air),                    new RelativeStructureBlock(-1, 0, 0, ModBlocks.activatedQuartz),
            new RelativeStructureBlock(1, 0, -1, ModBlocks.activatedQuartz),    new RelativeStructureBlock(0, 0, -1, ModBlocks.activatedQuartz),    new RelativeStructureBlock(-1, 0, -1, ModBlocks.activatedQuartz)
    );

    public static final RelativeStructure QUARTZ_RING_LVL2 = new RelativeStructure(IRelativeStructure.StructureType.QUARTZ_RING,
            new RelativeStructureBlock(1, -1, 1, ModBlocks.activatedQuartz),     new RelativeStructureBlock(0, -1, 1, ModBlocks.activatedQuartz),     new RelativeStructureBlock(-1, -1, 1, ModBlocks.activatedQuartz),
            new RelativeStructureBlock(1, -1, 0, ModBlocks.activatedQuartz),     new RelativeStructureBlock(0, -1, 0, Blocks.air),                    new RelativeStructureBlock(-1, -1, 0, ModBlocks.activatedQuartz),
            new RelativeStructureBlock(1, -1, -1, ModBlocks.activatedQuartz),    new RelativeStructureBlock(0, -1, -1, ModBlocks.activatedQuartz),    new RelativeStructureBlock(-1, -1, -1, ModBlocks.activatedQuartz)
    );

    public static final RelativeStructure QUARTZ_RING_LVL3 = new RelativeStructure(IRelativeStructure.StructureType.QUARTZ_RING,
            new RelativeStructureBlock(1, -2, 1, ModBlocks.activatedQuartz),     new RelativeStructureBlock(0, -2, 1, ModBlocks.activatedQuartz),     new RelativeStructureBlock(-1, -2, 1, ModBlocks.activatedQuartz),
            new RelativeStructureBlock(1, -2, 0, ModBlocks.activatedQuartz),     new RelativeStructureBlock(0, -2, 0, Blocks.air),                    new RelativeStructureBlock(-1, -2, 0, ModBlocks.activatedQuartz),
            new RelativeStructureBlock(1, -2, -1, ModBlocks.activatedQuartz),    new RelativeStructureBlock(0, -2, -1, ModBlocks.activatedQuartz),    new RelativeStructureBlock(-1, -2, -1, ModBlocks.activatedQuartz)
    );

    public static final LeveledRelativeStructure QUARTZ_RING = new LeveledRelativeStructure(IRelativeStructure.StructureType.QUARTZ_RING,
            QUARTZ_RING_LVL1,
            QUARTZ_RING_LVL2,
            QUARTZ_RING_LVL3
    );

    /** ***************************************************************************************************************
     * Energy Destabilizer (Early Game)
     *
     * Second crafting multi-block. Used to extract energy from items and blocks and a quicker speed than naturally possible.
     * Planned items:
     *  - Draining Full Activated Quartz (*0.25 of the stored Energy Type)
     *  - EnderShard > RiftShard (+Little Enderic Energy)
     *  - EnderPerals > EmptyEnderPearls (+Lots of Enderic Energy)
     *  - EnderStone > DrainedEnderStone (+Lots of Enderic Energy + small passive generation)
     *
     *  Can be used in mid-game as one of the first ways to get Enderic Energy from the Ender-Items
     */
    public static final RelativeStructure ENERGY_DESTABILIZER = new RelativeStructure(IRelativeStructure.StructureType.ENERGY_DESTABILIZER,
            //+1
            new RelativeStructureBlock(1, 1, 1), new RelativeStructureBlock(1, 1, -1),
            new RelativeStructureBlock(-1, 1, 1), new RelativeStructureBlock(-1, 1, -1),
            //root
            new RelativeStructureBlock(0, 0, 0)
    );

    public static final RelativeSubStructure ENERGY_EXTRACTOR = new RelativeSubStructure(RelativeSubStructure.SubType.SPECIAL, ENERGY_DESTABILIZER,
            //+3
            new RelativeLocation(0, 3, 0)
    );

//</editor-fold>

//<editor-fold desc="Rift Interaction Structures">
    /** ***************************************************************************************************************
     * RiftStone Well (Mid Game)
     *
     * Planned to be the first Rift related multi-block the player gets.
     * RiftShards which are stabilized in this structure has increased 'stats'.
     * Default Behaviour:
     * The focus time is halved,
     * destabilization time increased *1.5,
     * safe Distance boundary *2.
     * Incoming rifts which are stabilized in this structure will not be affected by disrupting effects, unless the modifier says otherwise.
     *
     * With different type of stones on modification spots of the multi-block this default behaviour can be changed.
     */
    public static final RelativeStructure RIFT_STONE_WELL = new RelativeStructure(IRelativeStructure.StructureType.RIFT_STONE_WELL,
            // Top Level +2
            new RelativeStructureBlock(2, 2, 2),    new RelativeStructureBlock(2, 2, -2),
            new RelativeStructureBlock(-2, 2, 2),   new RelativeStructureBlock(-2, 2, -2),

            // Root Level +1
            new RelativeStructureBlock(2, 1, 2),    new RelativeStructureBlock(2, 1, -2),
            new RelativeStructureBlock(-2, 1, 2),   new RelativeStructureBlock(-2, 1, -2),

            // Root Level
            new RelativeStructureBlock(0, 0, 0),

            // Below Root -1
            new RelativeStructureBlock(0, -1, 0)
    );

    public static final RelativeSubStructure RIFT_STONE_WELL_MODIFIERS = new RelativeSubStructure(RelativeSubStructure.SubType.MODIFIER, RIFT_STONE_WELL,
            // +1
            new RelativeLocation(2, 1, 2),          new RelativeLocation(2, 1, -2),
            new RelativeLocation(-2, 1, 2),         new RelativeLocation(-2, 1, -2),
            // -1
            new RelativeLocation(0, -1, 0)
    );

    public static final RelativeSubStructure RIFT_STONE_WELL_TILES = new RelativeSubStructure(RelativeSubStructure.SubType.TILE_ENTITY, RIFT_STONE_WELL,
            // +2
            new RelativeLocation(2, 2, 2),          new RelativeLocation(2, 2, -2),
            new RelativeLocation(-2, 2, 2),         new RelativeLocation(-2, 2, -2)
    );

    /** ***************************************************************************************************************
     * DisruptionStone Well (Mid Game)
     *
     * Planned to be the second Rift Related multi-block, the player can get. This structure can be used to push incoming rifts more effectively.
     * A DisruptionStone Well can link up with simple DisruptionStones and direct incoming rifts more effectively.
     * Default Behavior:
     * Max Connected Stones: 8
     * Displacement Vector Strength: 9
     *
     * With different type of stones on modification spots of the multi-block this default behaviour can be changed.
     */
    public static final RelativeStructure DISRUPTION_STONE_WELL = new RelativeStructure(IRelativeStructure.StructureType.DISRUPT_STONE_WELL,
            // 0
                                                    new RelativeStructureBlock(0, 0, 2),
            new RelativeStructureBlock(0, 0, -2),   new RelativeStructureBlock(0, 0, 0),    new RelativeStructureBlock(0, 0, 2),
                                                    new RelativeStructureBlock(0, 0, -2),
            // -1
                                                    new RelativeStructureBlock(0, -1, 2),
            new RelativeStructureBlock(0, -1, -2),  new RelativeStructureBlock(0, -1, 0),   new RelativeStructureBlock(0, -1, 2),
                                                    new RelativeStructureBlock(0, -1, -2)
    );

    public static final RelativeSubStructure DISRUPTION_STONE_WELL_MODIFIERS = new RelativeSubStructure(RelativeSubStructure.SubType.MODIFIER, DISRUPTION_STONE_WELL,
            // -1
                                                new RelativeLocation(0, -1, 2),
            new RelativeLocation(0, -1, -2),    new RelativeLocation(0, -1, 0),   new RelativeLocation(0, -1, 2),
                                                new RelativeLocation(0, -1, -2)
    );

    public static final RelativeSubStructure DISRUPTION_STONE_WELL_TILES = new RelativeSubStructure(RelativeSubStructure.SubType.TILE_ENTITY, DISRUPTION_STONE_WELL,
            // 0
                                                    new RelativeLocation(0, 0, 2),
            new RelativeLocation(0, 0, -2),                                                 new RelativeLocation(0, 0, 2),
                                                    new RelativeLocation(0, 0, -2)

    );

    /** ***************************************************************************************************************
     * Rifting Well (Late > End Game)
     * The basis allows to open 1-way rifts to any place the player wants inside the dimension. Location has to be stored on a FocusMatrix.
     * Does not have the focus attribute of its stone variant.
     * Upgrades:
     *  1: Structure is able to open rifts to new locations (energy cost * 4) (Lower lvl-functions cost *.5)
     *  2: Structure is able to open interdimensional rifts (energy cost * 4) (Lower lvl-functions cost *.5)
     *  3: Structure is able to open 2-way rifts (energy cost * 4) (Lower lvl-functions cost *.5)
     *
     * Add-ons:
     *  Transport, Structure is able to transport items/liquid/energy through the rift.
     */
    public static final RelativeStructure RIFTING_WELL_BASIS = null;
    public static final RelativeStructure RIFTING_WELL_LVL1 = null;
    public static final RelativeStructure RIFTING_WELL_LVL2 = null;
    public static final RelativeStructure RIFTING_WELL_LVL3 = null;

    public static final LeveledRelativeStructure DISRUPTING_WELL = new LeveledRelativeStructure(IRelativeStructure.StructureType.DISRUPT_WELL,
            RIFTING_WELL_BASIS,
            RIFTING_WELL_LVL1,
            RIFTING_WELL_LVL2,
            RIFTING_WELL_LVL3
    );

    /** ***************************************************************************************************************
     * Disruption Well (Late > End Game)
     * Enables the player to fine-tune their defences against incoming rifts.
     * Default Behaviour:
     *  Can connect to up to 8 (StoneWells + Stones) Connections from StoneWells stack up. True max 8 * 8.
     *  Displacement Vector Strength: 18
     *
     * Upgrades:
     *  1: Incorporate Rift(Stone) Structures to set final destination.
     *  2: Structure is able to identify incoming rifts and filter them.
     *  3: Disruption is able to fauxCancle incoming rift. Basically completely denying it instead of pushing away. (Uses Energy VOID)
     */
    public static final RelativeStructure Disruption_Well = null;


//</editor-fold>

//<editor-fold desc="Energy Stuctures">
    /** ***************************************************************************************************************
     * Energy Manipulator
     *
     * One of the first multi-blocks which can refine enderic energy.
     * lvl: rift efficiency:    void efficiency
     * 1:   0.5:                0.0
     * 2:   0.7:                0.0
     * 3:   0.8:                0.1
     * 4:   0.875:              0.2
     * 5:   0.925:              0.25
     * 6:   0.95:               0.275
     */
    public static final LeveledRelativeStructure ENERGY_MANIPULATOR = null;

    /** ***************************************************************************************************************
     * Void Extractor
     *
     * An energy multi-block which sacrifices the generation of Rift Energy, for void energy.
     * lvl: rift efficiency:    void efficiency
     * 1:   0.0:                0.2
     * 2:   0.0:                0.4
     * 3:   0.0:                0.5
     * 4:   0.1:                0.575
     * 5:   0.2:                0.65
     * 6:   0.25:               0.7
     */
    public static final LeveledRelativeStructure VOID_EXTRACTOR = null;
//</editor-fold>

//<editor-fold desc="Other/ Util">
    /** ***************************************************************************************************************
     * Repository
     *
     * This multi-block allows a player to store his focusMatrix locations for later use. The basis allows sharing with any player.
     * Levels expand functionality of the repository.
     *  1: Protection against unwanted players
     *  2: Sync Up to other Repositories
     */
    public static final RelativeStructure REPOSITORY = null;
//</editor-fold>
    //@formatter:on
}
