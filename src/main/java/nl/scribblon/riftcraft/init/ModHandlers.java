package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventBus;
import nl.scribblon.riftcraft.handler.ConfigurationHandler;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class ModHandlers {

    public static final ConfigurationHandler configurationHandler = new ConfigurationHandler();

    public static void init(){
        EventBus fmlBus = FMLCommonHandler.instance().bus();

        fmlBus.register(configurationHandler);
    }
}
