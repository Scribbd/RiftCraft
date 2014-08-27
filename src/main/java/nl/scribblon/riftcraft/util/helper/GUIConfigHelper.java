package nl.scribblon.riftcraft.util.helper;

import cpw.mods.fml.client.config.IConfigElement;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.LinkedList;
import java.util.List;

/**
 * Utility for the creation of the config options.
 *
 * Created by Scribblon for RiftCraft.
 * Date Creation: 28-7-2014
 */
final public class GUIConfigHelper {

    public static List<IConfigElement> getAllOptions(Configuration config) {
        List<IConfigElement> elementList = new LinkedList<IConfigElement>();

        for(String name : config.getCategoryNames()){
            if(config.getCategory(name).showInGui())
                elementList.addAll(new ConfigElement(config.getCategory(name)).getChildElements());
        }

        return elementList;
    }
}
