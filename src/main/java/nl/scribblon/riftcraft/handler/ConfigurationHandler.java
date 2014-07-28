package nl.scribblon.riftcraft.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import nl.scribblon.riftcraft.reference.DefaultConfigurationProperties;
import nl.scribblon.riftcraft.reference.DefaultConfigurationValues;
import nl.scribblon.riftcraft.reference.Reference;
import nl.scribblon.riftcraft.reference.Settings;
import nl.scribblon.riftcraft.util.LogHelper;

import java.io.File;

/**
 * Created by Scribblon for RiftCraft.
 * Date Creation: 26-7-2014
 */
public class ConfigurationHandler {

    public static Configuration configuration;

    /**
     * Initializes the configurationHandler
     * @param configurationFile File-Object with location of config-file
     */
    public static void init(File configurationFile) {
        //Generic init
        if (configuration == null){
            if(Reference.IS_PRE_CONFIG_DEV_MODE){
                if(configurationFile.exists())
                    LogHelper.info("[ConfigurationHandler] Starting to read config file.");
                else
                    LogHelper.info("[ConfigurationHandler] Generating config file.");
            }

            configuration = new Configuration(configurationFile);
            loadConfiguration();
        }
    }

    /**
     * Handler to resync configuration changes
     * @param event OnConfigChangedEvent -Default
     */
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            ConfigurationHandler.loadConfiguration();
        }
    }

    private static void loadConfiguration() {

        //Main settings
        configuration.addCustomCategoryComment(DefaultConfigurationValues.GENERAL_CATEGORY_NAME, DefaultConfigurationValues.GENERAL_CATEGORY_COMMENT);

        Settings.General.language = configuration.get(DefaultConfigurationValues.GENERAL_CATEGORY_NAME, DefaultConfigurationValues.LANGUAGE_NAME, DefaultConfigurationValues.LANGUAGE_VALUE, DefaultConfigurationValues.LANGUAGE_COMMENT).getString();
        Settings.General.isHTExternalPowerRequired = configuration.get(DefaultConfigurationValues.GENERAL_CATEGORY_NAME, DefaultConfigurationValues.HIGH_TECH_POWER_NAME, DefaultConfigurationValues.HIGH_TECH_POWER_VALUE, DefaultConfigurationValues.HIGH_TECH_POWER_COMMENT).getBoolean(DefaultConfigurationValues.HIGH_TECH_POWER_VALUE);
        Settings.General.isDeathProtected = configuration.get(DefaultConfigurationValues.GENERAL_CATEGORY_NAME, DefaultConfigurationValues.DEATH_PROTECTION_NAME, DefaultConfigurationValues.DEATH_PROTECTION_VALUE, DefaultConfigurationValues.DEATH_PROTECTION_COMMENT).getBoolean(DefaultConfigurationValues.DEATH_PROTECTION_VALUE);
        Settings.General.isAbuseProtected = configuration.get(DefaultConfigurationValues.GENERAL_CATEGORY_NAME, DefaultConfigurationValues.ABUSE_PROTECTION_NAME, DefaultConfigurationValues.ABUSE_PROTECTION_VALUE, DefaultConfigurationValues.ABUSE_PROTECTION_COMMENT).getBoolean(DefaultConfigurationValues.ABUSE_PROTECTION_VALUE);
        Settings.General.isWorldProtected = configuration.get(DefaultConfigurationValues.GENERAL_CATEGORY_NAME, DefaultConfigurationValues.VOID_PROTECTION_NAME, DefaultConfigurationValues.VOID_PROTECTION_VALUE, DefaultConfigurationValues.VOID_PROTECTION_COMMENT).getBoolean(DefaultConfigurationValues.VOID_PROTECTION_VALUE);

        //World Generation
        configuration.addCustomCategoryComment(DefaultConfigurationValues.GENERATION_CATEGORY_NAME, DefaultConfigurationValues.GENERATION_CATEGORY_COMMENT);

        Settings.Generation.areStructuresGenerated = configuration.get(DefaultConfigurationValues.GENERATION_CATEGORY_NAME, DefaultConfigurationValues.GENERATION_NAME, DefaultConfigurationValues.GENERATION_VALUE, DefaultConfigurationValues.GENERATION_COMMENT).getBoolean(DefaultConfigurationValues.GENERATION_VALUE);
        Settings.Generation.areRiftsRegenerating = configuration.get(DefaultConfigurationValues.GENERATION_CATEGORY_NAME, DefaultConfigurationValues.REGENERATE_NATURAL_NAME, DefaultConfigurationValues.REGENERATE_NATURAL_VALUE, DefaultConfigurationValues.REGENERATE_NATURAL_COMMENT).getBoolean(DefaultConfigurationValues.REGENERATE_NATURAL_VALUE);

        //Conversion Variables
        configuration.addCustomCategoryComment(DefaultConfigurationValues.CONVERSION_CATEGORY_NAME, DefaultConfigurationValues.CONVERSION_CATEGORY_COMMENT);
        
        Settings.Conversion.rfConversionRate = configuration.get(DefaultConfigurationValues.CONVERSION_CATEGORY_NAME, DefaultConfigurationValues.RF_NAME, DefaultConfigurationValues.RF_VALUE).getDouble(DefaultConfigurationValues.RF_VALUE);
        Settings.Conversion.euConversionRate = configuration.get(DefaultConfigurationValues.CONVERSION_CATEGORY_NAME, DefaultConfigurationValues.EU_NAME, DefaultConfigurationValues.EU_VALUE).getDouble(DefaultConfigurationValues.EU_VALUE);
        Settings.Conversion.mjConversionRate = configuration.get(DefaultConfigurationValues.CONVERSION_CATEGORY_NAME, DefaultConfigurationValues.MJ_NAME, DefaultConfigurationValues.MJ_VALUE).getDouble(DefaultConfigurationValues.MJ_VALUE);

        //Debug Settings
        configuration.addCustomCategoryComment(DefaultConfigurationValues.DEBUG_CATEGORY_NAME, DefaultConfigurationValues.DEBUG_CATEGORY_COMMENT);

        Settings.Debug.isDebugging = configuration.get(DefaultConfigurationValues.DEBUG_CATEGORY_NAME, DefaultConfigurationValues.DEBUG_MODE_NAME, DefaultConfigurationValues.DEBUG_MODE_VALUE, DefaultConfigurationValues.DEBUG_MODE_COMMENT).getBoolean(DefaultConfigurationValues.DEBUG_MODE_VALUE);

        //Setup config
        setupConfigurationProperties();

        //Finally save config
        saveConfiguration();

        if(Reference.IS_PRE_CONFIG_DEV_MODE)
            LogHelper.info("[ConfigurationHandler] Done!");
    }

    private static void saveConfiguration() {
        if (configuration.hasChanged()) {
            configuration.save();

            if(Reference.IS_PRE_CONFIG_DEV_MODE){
                LogHelper.info("[ConfigurationHandler] Changes saved to: " + configuration);
            }
        }
    }

    private static void setupConfigurationProperties(){
        configuration.setCategoryPropertyOrder(DefaultConfigurationValues.GENERAL_CATEGORY_NAME, DefaultConfigurationProperties.GENERAL_ORDER);
        configuration.setCategoryPropertyOrder(DefaultConfigurationValues.GENERATION_CATEGORY_NAME, DefaultConfigurationProperties.GENERATING_ORDER);

        configuration.setCategoryRequiresMcRestart(DefaultConfigurationValues.CONVERSION_CATEGORY_NAME, DefaultConfigurationProperties.CONVERSION_REQUIRES_REBOOT);

        configuration.getCategory(DefaultConfigurationValues.DEBUG_CATEGORY_NAME).setShowInGui(DefaultConfigurationProperties.IS_DEBUG_GUIABLE);
    }

}
