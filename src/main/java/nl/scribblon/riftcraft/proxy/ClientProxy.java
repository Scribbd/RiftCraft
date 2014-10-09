package nl.scribblon.riftcraft.proxy;

import nl.scribblon.riftcraft.client.helper.SoundHelper;
import nl.scribblon.riftcraft.init.RCModHandlers;
import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;

/**
 * Created by Scribblon for riftcraft.
 * Date Creation: 16-6-2014
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerEventHandler() {
        super.registerEventHandler();
        RCModHandlers.clientInit();
    }

    @Override
    public void playSoundAt(String soundName, ILocationRC location, float volume, float pitch) {
        SoundHelper.playSoundAt(soundName, location, volume, pitch);
    }

    @Override
    public void playRelativeSoundAt(String soundName, ILocationRC root, IRelativeLocationRC relativeLocation, float volume, float pitch) {
        SoundHelper.playSoundAt(soundName, relativeLocation.getILocationRelativelyFrom(root), volume, pitch);
    }
}
