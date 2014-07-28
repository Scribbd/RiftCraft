package nl.scribblon.riftcraft.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import nl.scribblon.riftcraft.handler.ConfigurationHandler;
import nl.scribblon.riftcraft.reference.DefaultConfigurationValues;
import nl.scribblon.riftcraft.reference.Reference;
import nl.scribblon.riftcraft.util.GUIConfigHelper;
import nl.scribblon.riftcraft.util.LogHelper;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-7-2014
 */
public class RCGuiConfig extends GuiConfig {


    public RCGuiConfig(GuiScreen guiScreen) {
        super(guiScreen,
                GUIConfigHelper.getAllOptions(ConfigurationHandler.configuration),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
