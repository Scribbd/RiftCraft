package nl.scribblon.riftcraft.proxy;

import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;

/**
 * Created by Scribblon for riftcraft.
 * Date Creation: 16-6-2014
 */
public class ServerProxy extends CommonProxy {

    @Override
    public void playSoundAt(String soundName, ILocationRC location, float volume, float pitch) {
        // No sound should play at server!
    }

    @Override
    public void playRelativeSoundAt(String soundName, ILocationRC root, IRelativeLocationRC relativeLocation, float volume, float pitch) {
        // No sound should play at server!
    }
}
