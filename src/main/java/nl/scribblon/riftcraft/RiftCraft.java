package nl.scribblon.riftcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import nl.scribblon.riftcraft.handler.ConfigurationHandler;
import nl.scribblon.riftcraft.init.ModBlocks;
import nl.scribblon.riftcraft.init.ModHandlers;
import nl.scribblon.riftcraft.init.ModItems;
import nl.scribblon.riftcraft.proxy.IRCProxy;
import nl.scribblon.riftcraft.reference.Reference;
import nl.scribblon.riftcraft.reference.Settings;
import nl.scribblon.riftcraft.util.LogHelper;

/**
 * Created by Scribblon for riftcraft.
 * Date Creation: 16-6-2014
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, /*certificateFingerprint = Reference.FINGERPRINT,*/ version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class RiftCraft {

    @Mod.Instance(Reference.MOD_ID)
    public static RiftCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IRCProxy proxy;

    @Mod.EventHandler
    public void invalidFingerprint(FMLFingerprintViolationEvent event)
    {

    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        if(Reference.IS_PRE_CONFIG_DEV_MODE) {
            LogHelper.info("Pre-Init Started");
            LogHelper.info("If you read this, and this is not a DEV/RAW build. Then I forgot to turn of the pre-configure load debug check! Warn me!");
        }

        // Config loading, initialize networkHandeling, keybinding, items, blocks
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        // Register Block & Items
        ModBlocks.init();
        ModItems.init();

        // Register Handler
        ModHandlers.init();

        if(Settings.Debug.isDebugging)
            LogHelper.info("Pre-Init Passed");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        if(Settings.Debug.isDebugging)
            LogHelper.info("Init Started");
        // Gui Handler, Tile entities, Rendering, Even Handlers, start registering Recipies
        if(Settings.Debug.isDebugging)
            LogHelper.info("Init Passed");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        if(Settings.Debug.isDebugging)
            LogHelper.info("Post-Init Started");
        //
        if(Settings.Debug.isDebugging)
            LogHelper.info("Post-Init Passed");
    }

    @Mod.EventHandler
    public void handleIMCMessages(IMCEvent event)
    {

    }
}
