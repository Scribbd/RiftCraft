package nl.scribblon.riftcraft.client.gui;

import cpw.mods.fml.client.IModGuiFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.util.Set;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-7-2014
 */
public class RCGuiFactory implements IModGuiFactory {

    /**
     * UNIMPLEMENTED IN MASTER
     * @param minecraftInstance
     */
    @Override
    public void initialize(Minecraft minecraftInstance) {

    }

    /**
     *
     * @return GuiScreen Default config class
     */
    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return RCGuiConfig.class;
    }

    /**
     * UNIMPLEMENTED IN MASTER
     * @return
     */
    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    /**
     * UNIMPLEMENTED IN MASTER
     * @param element
     * @return
     */
    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
        return null;
    }
}
