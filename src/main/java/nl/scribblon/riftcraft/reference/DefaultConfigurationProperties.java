package nl.scribblon.riftcraft.reference;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 28-7-2014
 */
public class DefaultConfigurationProperties {

    public static final List<String> GENERAL_ORDER = new LinkedList<String> () {{
        add(DefaultConfigurationValues.LANGUAGE_NAME);
        add(DefaultConfigurationValues.HIGH_TECH_POWER_NAME);
        add(DefaultConfigurationValues.ABUSE_PROTECTION_NAME);
        add(DefaultConfigurationValues.DEATH_PROTECTION_NAME);
        add(DefaultConfigurationValues.VOID_PROTECTION_NAME);
    }};

    public static final List<String> GENERATING_ORDER = new LinkedList<String> () {{
        add(DefaultConfigurationValues.GENERATION_NAME);
        add(DefaultConfigurationValues.REGENERATE_NATURAL_NAME);
    }};

    public static final boolean IS_DEBUG_GUIABLE = false;

    public static final boolean CONVERSION_REQUIRES_REBOOT = true;
}
