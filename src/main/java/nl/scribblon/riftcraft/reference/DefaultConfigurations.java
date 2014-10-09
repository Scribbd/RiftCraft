package nl.scribblon.riftcraft.reference;

import net.minecraftforge.common.config.Configuration;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 29-7-2014
 */
public class DefaultConfigurations {
    /**
     * Created by Scribblon for RiftCraft.
     * Date Creation: 26-7-2014
     */
    //TODO make config localized
    public static class Values {
        /*
         * General Default Configuration Values + Comments
         */
        public static final String GENERAL_CATEGORY_NAME = "a- " + Configuration.CATEGORY_GENERAL;
        public static final String GENERAL_CATEGORY_COMMENT = "General stuff";

        public static final String HIGH_TECH_POWER_NAME = "High Tech Requires External Power";
        public static final boolean HIGH_TECH_POWER_VALUE = true;
        public static final String HIGH_TECH_POWER_COMMENT = "If high tier tech needs an external power source";

        public static final String DEATH_PROTECTION_NAME = "Death Protection Mode";
        public static final boolean DEATH_PROTECTION_VALUE = true;
        public static final String DEATH_PROTECTION_COMMENT = "Be warned, suffocation in walls and falling to death become very real whenever set to false. Does not prevent death in the void.";

        public static final String ABUSE_PROTECTION_NAME = "Abuse Protection Mode";
        public static final boolean ABUSE_PROTECTION_VALUE = false;
        public static final String ABUSE_PROTECTION_COMMENT = "Prevents punishment of abuse when set to true. ";

        public static final String VOID_PROTECTION_NAME = "Void Protection Mode";
        public static final boolean VOID_PROTECTION_VALUE = false;
        public static final String VOID_PROTECTION_COMMENT = "Tears will not destroy worlds by default and is not exclusive to vanilla dimensions.";

        /*
         * (Dynamic) World Generation config
         */

        public static final String GENERATION_CATEGORY_NAME = "b- (dynamic) world generation";
        public static final String GENERATION_CATEGORY_COMMENT = "Generation of ruins and natural/ancient rifts";

        public static final String GENERATION_NAME = "World Generation";
        public static final boolean GENERATION_VALUE = true;
        public static final String GENERATION_COMMENT = "Whatever structures will be generated.";

        public static final String REGENERATE_NATURAL_NAME = "Regenerate Natural Rifts";
        public static final boolean REGENERATE_NATURAL_VALUE = true;
        public static final String REGENERATE_NATURAL_COMMENT = "Whenever new natural rifts spawn.";

        /*
         * Conversion Values
         */
        public static final String CONVERSION_CATEGORY_NAME = "c- conversion values";
        public static final String CONVERSION_CATEGORY_COMMENT = "Conversion is how many (unit) it takes for 1 power unit (1 rift energy).";

        public static final String RF_NAME = "RF (TE)";
        public static final double RF_VALUE = 1;

        public static final String EU_NAME = "EU (IC2)";
        public static final double EU_VALUE = 1;

        public static final String MJ_NAME = "MJ (Buildcraft)";
        public static final double MJ_VALUE = 1;

        /*
         * Development config values
         */
        public static final String DEBUG_CATEGORY_NAME = "d- debug mode";
        public static final String DEBUG_CATEGORY_COMMENT = "MINE!";

        public static final String DEBUG_MODE_NAME = "Debug Mode";
        public static final boolean DEBUG_MODE_VALUE = false;
        public static final String DEBUG_MODE_COMMENT = "Enable if you want console spam, or look cool when you supposedly should be doing something else.";

    }

    /**
     * Created by Scribblon for RiftCraft.
     * Date Creation: 28-7-2014
     *
     * Subclass is used for the in-game mod config menu.
     */
    public static class Properties {

        public static final List<String> GENERAL_ORDER = new LinkedList<String>() {{
            add(Values.HIGH_TECH_POWER_NAME);
            add(Values.ABUSE_PROTECTION_NAME);
            add(Values.DEATH_PROTECTION_NAME);
            add(Values.VOID_PROTECTION_NAME);
        }};

        public static final List<String> GENERATING_ORDER = new LinkedList<String> () {{
            add(Values.GENERATION_NAME);
            add(Values.REGENERATE_NATURAL_NAME);
        }};

        public static final boolean IS_DEBUG_GUIABLE = false;

        public static final boolean CONVERSION_REQUIRES_REBOOT = true;
    }

    //@formatter:on
}
