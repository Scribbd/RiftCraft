package nl.scribblon.riftcraft.proxy;

import nl.scribblon.riftcraft.init.RCModHandlers;

/**
 * Created by Scribblon for riftcraft.
 * Date Creation: 16-6-2014
 */
public abstract class CommonProxy implements IRCProxy{

    @Override
    public void registerEventHandler() {
        RCModHandlers.commonInit();
    }
}
