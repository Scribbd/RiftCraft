package nl.scribblon.riftcraft.proxy;

import nl.scribblon.riftcraft.util.iplace.ILocationRC;
import nl.scribblon.riftcraft.util.iplace.IRelativeLocationRC;

/**
 * Created by Scribblon for riftcraft.
 * Date Creation: 16-6-2014
 */
public interface IRCProxy {

    void registerEventHandler();

    void playSoundAt(String soundName, ILocationRC location, float volume, float pitch);

    //For those random scary noises
    void playRelativeSoundAt(String soundName, ILocationRC root, IRelativeLocationRC relativeLocation, float volume, float pitch);
}
