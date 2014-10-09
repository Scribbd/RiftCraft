package nl.scribblon.riftcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import nl.scribblon.riftcraft.handler.ConfigurationHandler;
import nl.scribblon.riftcraft.init.*;
import nl.scribblon.riftcraft.proxy.IRCProxy;
import nl.scribblon.riftcraft.reference.Reference;
import nl.scribblon.riftcraft.util.helper.LogHelper;

/**
 * Created by Scribblon for riftcraft.
 * Date Creation: 16-6-2014
 *
 * RiftCraft.
 * A mod that tries to bring balanced, PvP-friendly, and aesthetically pleasing teleportation to your MineCraft world.
 * Inspired by tears from Bioshock Infinite.
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, /*certificateFingerprint = Reference.FINGERPRINT,*/ version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class RiftCraft {

    @Mod.Instance(Reference.MOD_ID)
    public static RiftCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IRCProxy proxy;

    @Mod.EventHandler
    public void invalidFingerprint(FMLFingerprintViolationEvent event) {
        LogHelper.warn("FINGERPRINT INVALID. If you are reading this, somewhere along the way, the RiftCraft Package got altered. Consider re-downloading and make sure you are downloading from the release-GitHub repository.");
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        // Whenever I want to register commands.
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        if(Reference.IS_PRE_CONFIG_DEV_MODE) {
            LogHelper.info("Pre-Init Started");
            LogHelper.info("If you read this, and this is not a DEV/RAW build. Then I forgot to turn of the debug-mode! Warn me!");
        }

        // Config loading, initialize networkHandeling, keybinding, items, blocks
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        // Register Block & Items & Liquids
        RCModBlocks.init();
        RCModItems.init();
        RCModLiquids.init();

        LogHelper.reportWhenDebugging("Pre-Init Passed");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        LogHelper.reportWhenDebugging("Init Started");
        // Gui Handler, Tile entities, Rendering, Even Handlers, start registering Recipes

        // TileEntities
        RCTileEntities.init();

        // Register messages & networking.
        RCModNetwork.init();

        // Register Handler
        proxy.registerEventHandler();


        // Recipes & Crafting Handler
        RCModRecipes.init();

        // Fuels

        LogHelper.reportWhenDebugging("Init Passed");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.reportWhenDebugging("Post-Init Started");
        //

        LogHelper.reportWhenDebugging("Post-Init Passed");
    }

    @Mod.EventHandler
    public void handleIMCMessages(IMCEvent event) {

    }
}
