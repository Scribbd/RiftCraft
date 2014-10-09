package nl.scribblon.riftcraft.reference;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 28-7-2014
 *
 * Settings of the mod. Not... really object orientated, but easy.
 */
public class Settings {

    /**
     * General settings for the mod
     */
    public static class General {
        public static boolean isHTExternalPowerRequired;
        public static boolean isAbuseProtected;
        public static boolean isDeathProtected;
        public static boolean isWorldProtected;
    }

    //TODO integrate into configs
    /**
     * Settings concerning Shard-items
     * Focusing
     */
    public static class Shards {
        public static int defaultImprintTime = 80;
        public static int defaultFocusTime = 40;
        public static int defaultShiftTime = 40;
        public static int defaultStableTime = 20 * Reference.TICKS_IN_MINUTE;
        public static int defaultStableDecrement = 1;
        public static float defaultThrowDamage = 9.0F; //4.5 hearths of damage
    }

    public static class Stones {
        public static int defaultStableTime = 1 * Reference.TICKS_IN_MINUTE;
        public static int defaultImprintTime = Shards.defaultImprintTime / 2;
    }

    public static class Generation {
        public static boolean areStructuresGenerated;
        public static boolean areRiftsRegenerating;
    }

    public static class Conversion {
        public static double euConversionRate;
        public static double mjConversionRate;
        public static double rfConversionRate;
    }

    public static class Debug {
        public static boolean isDebugging;
    }
}
