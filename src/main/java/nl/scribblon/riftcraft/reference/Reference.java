package nl.scribblon.riftcraft.reference;

/**
 * Created by Scribblon for riftcraft.
 * Date Creation: 16-6-2014
 *
 * All references
 */
public class Reference {
    public static final String MOD_ID = "RiftCraft";
    public static final String MOD_NAME = "RiftCraft";
    //public static final String FINGERPRINT = "@FINGERPRINT@";
    public static final String VERSION = "1.7.10-0.0.1-RAW";
    public static final String SERVER_PROXY_CLASS = "nl.scribblon.riftcraft.proxy.ServerProxy";
    public static final String CLIENT_PROXY_CLASS = "nl.scribblon.riftcraft.proxy.ClientProxy";
    public static final String GUI_FACTORY_CLASS = "nl.scribblon.riftcraft.client.gui.RCGuiFactory";

    public static final boolean IS_PRE_CONFIG_DEV_MODE = true; //set to false before release

    //Tick references
    public static final int DEFAULT_TICK_SPACE = 1;
    public static final int TICKS_IN_SECOND = 20;
    public static final int TICKS_IN_MINUTE = TICKS_IN_SECOND * 60;

    //Tool property references
    public static final int MAX_STACK_SIZE_TOOL = 1;

    //Active player slot reference
    public static final int CURRENTLY_HELD_ITEM = 0;
    public static final int HEAD_SLOT = 1;
    public static final int BODY_SLOT = 2;
    public static final int PANTS_SLOT = 3;
    public static final int FEET_SLOT = 4;
}
