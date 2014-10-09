package nl.scribblon.riftcraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import nl.scribblon.riftcraft.creativetab.RCCreativeTab;
import nl.scribblon.riftcraft.reference.Textures;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 *
 * Base block for anything Rift Crafty.
 */
public abstract class RCBlock extends Block {

    public RCBlock(Material material) {
        super(material);
        this.setCreativeTab(RCCreativeTab.RC_TAB);
    }

    public RCBlock(){
        this(Material.rock);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
