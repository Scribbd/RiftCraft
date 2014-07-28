package nl.scribblon.riftcraft.reference;


import net.minecraftforge.common.config.Configuration;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-7-2014
 */
public class DefaultConfigurationValues {
    /*
     * General Default Configuration Values + Comments
     */
    public static final String GENERAL_CATEGORY_NAME = "a- " + Configuration.CATEGORY_GENERAL;
    public static final String GENERAL_CATEGORY_COMMENT = "General stuff";

    public static final String LANGUAGE_NAME = "Language";
    public static final String LANGUAGE_VALUE = "en-EN";
    public static final String LANGUAGE_COMMENT = "Currently, no connected functionality included.";

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
