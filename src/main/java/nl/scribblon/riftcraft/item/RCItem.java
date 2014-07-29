package nl.scribblon.riftcraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nl.scribblon.riftcraft.creativetab.RCCreativeTab;
import nl.scribblon.riftcraft.reference.Settings;
import nl.scribblon.riftcraft.reference.Textures;
import nl.scribblon.riftcraft.util.LogHelper;

/**
 * Created by Scribblon for riftcraft.
 * Date Creation: 17-6-2014
 */
public class RCItem extends Item{

    public RCItem(){
        super();
        this.setCreativeTab(RCCreativeTab.RC_TAB);
    }

    @Override
    public String getUnlocalizedName(){
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
        if(Settings.Debug.isDebugging)
            LogHelper.info("Registered icon at " + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
