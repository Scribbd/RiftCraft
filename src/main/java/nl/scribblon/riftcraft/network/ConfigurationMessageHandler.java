package nl.scribblon.riftcraft.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 19-09-14
 *
 * Configuration Sync Message if it isn't done by Forge to begin with. Just placing the frame to init this dir in git
 */
public class ConfigurationMessageHandler implements IMessageHandler<ConfigurationMessageHandler.ConfigurationMessage, IMessage> {


    @Override
    public IMessage onMessage(ConfigurationMessage message, MessageContext ctx) {
        return null;
    }



    public static class ConfigurationMessage implements IMessage {

        @Override
        public void fromBytes(ByteBuf buf) {

        }

        @Override
        public void toBytes(ByteBuf buf) {

        }
    }
}
