package nl.scribblon.riftcraft.reference;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import nl.scribblon.riftcraft.init.RCModBlocks;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-09-14
 *
 * Maybe not the right name. Basically this reference enum will provide modifier values ( products ) when they are part of a structure.
 */
public enum ValueModifier {
    // WHERE IS THE OVERTYPE SETTING ON A MAC! ARGHHH
    // TABLE            (BlockReference,                ImprintModifier,    FocusModifier,      StabilityTimeModifier,  StabilityLocationModifier,
    OTHER               (null,                          1.0,                1.0,                1.0,                    1.0),

	AIR                 (Blocks.air,                    1.0,                1.0,                1.0,                    1.0),
	STONE               (Blocks.stone,                  1.0,                1.0,                1.0,                    1.0),
	DIAMOND_BLOCK       (Blocks.diamond_block,          1.0,                1.0,                1.0,                    1.0),
	GOLD_BLOCK          (Blocks.gold_block,             1.0,                1.0,                1.0,                    1.0),
	NETHER_QUARTZ       (Blocks.quartz_block,           1.0,                1.0,                1.0,                    1.0),

	RIFT_STONE          (RCModBlocks.riftStone,         1.0,                1.0,                1.0,                    1.0),
	DISRUPTION_STONE    (RCModBlocks.disruptionStone,   1.0,                1.0,                1.0,                    1.0),
	CLEAR_QUARTZ        (RCModBlocks.clearQuartz,       1.0,                1.0,                1.0,                    1.0);

	private Block block;
	private double imprintModifier, focusModifier, stabilityTimeModifier, stabilityLocationModifier;

	private ValueModifier(Block block, double imprintModifier, double focusModifier, double stabilityTimeModifier, double stabilityLocationModifier) {
		this.block = block;
		this.imprintModifier = imprintModifier;
		this.focusModifier = focusModifier;
		this.stabilityTimeModifier = stabilityTimeModifier;
        this.stabilityLocationModifier = stabilityLocationModifier;
	}

    public Block getBlock() {
        return block;
    }

    public double getImprintModifier() {
        return imprintModifier;
    }

    public void setImprintModifier(double imprintModifier) {
        this.imprintModifier = imprintModifier;
    }

    public double getFocusModifier() {
        return focusModifier;
    }

    public void setFocusModifier(double focusModifier) {
        this.focusModifier = focusModifier;
    }

    public double getStabilityTimeModifier() {
        return stabilityTimeModifier;
    }

    public void setStabilityTimeModifier(double stabilityTimeModifier) {
        this.stabilityTimeModifier = stabilityTimeModifier;
    }

    public double getStabilityLocationModifier() {
        return stabilityLocationModifier;
    }

    public void setStabilityLocationModifier(double stabilityLocationModifier) {
        this.stabilityLocationModifier = stabilityLocationModifier;
    }

    public boolean matchesBlock(Block block) {
        return this.block.getUnlocalizedName().equals(block.getUnlocalizedName());
    }

    public static int applyModifierToInt(int original, double modifier) {
        return (int) Math.floor((double) original * modifier);
    }

    public static ValueModifier getModifiersOfBlock(Block block) {
        if(ValueModifier.AIR.matchesBlock(block)) return ValueModifier.AIR;
        if(ValueModifier.STONE.matchesBlock(block)) return ValueModifier.STONE;
        if(ValueModifier.DIAMOND_BLOCK.matchesBlock(block)) return ValueModifier.DIAMOND_BLOCK;
        if(ValueModifier.GOLD_BLOCK.matchesBlock(block)) return ValueModifier.GOLD_BLOCK;
        if(ValueModifier.NETHER_QUARTZ.matchesBlock(block)) return ValueModifier.NETHER_QUARTZ;

        if(ValueModifier.RIFT_STONE.matchesBlock(block)) return ValueModifier.RIFT_STONE;
        if(ValueModifier.DISRUPTION_STONE.matchesBlock(block)) return ValueModifier.DISRUPTION_STONE;
        if(ValueModifier.CLEAR_QUARTZ.matchesBlock(block)) return ValueModifier.CLEAR_QUARTZ;

        return ValueModifier.OTHER;
    }
}
