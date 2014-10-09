package nl.scribblon.riftcraft.init;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import nl.scribblon.riftcraft.handler.ConfigurationHandler;
import nl.scribblon.riftcraft.handler.EnderPearlHandler;
import nl.scribblon.riftcraft.handler.EnderShardHandler;
import nl.scribblon.riftcraft.manager.RiftCraftConductor;
import nl.scribblon.riftcraft.reference.Reference;
//@formatter:off
/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 *
 * Handle my handler, twat!
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class RCModHandlers {

    //Reference for the non-singelton handlers/managers
    public static final ConfigurationHandler CONFIGURATION_HANDLER = new ConfigurationHandler();
    public static final EnderPearlHandler ENDER_TOSS_HANDLER = new EnderPearlHandler();
    public static final EnderShardHandler ENDER_SHARD_HANDLER = new EnderShardHandler();

    public static void commonInit() {
        EventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.register(ENDER_TOSS_HANDLER);
        forgeBus.register(ENDER_SHARD_HANDLER);
        forgeBus.register(RiftCraftConductor.getInstance());
    }

    public static void clientInit() {
        EventBus fmlBus = FMLCommonHandler.instance().bus();
        fmlBus.register(CONFIGURATION_HANDLER);
    }
}
//@formatter:on
