package nl.scribblon.riftcraft.reference;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 28-7-2014
 */
public class Settings {
    public static class General {
        public static boolean isHTExternalPowerRequired;
        public static boolean isAbuseProtected;
        public static boolean isDeathProtected;
        public static boolean isWorldProtected;
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
