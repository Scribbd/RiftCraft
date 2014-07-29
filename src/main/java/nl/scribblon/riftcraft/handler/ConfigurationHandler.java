package nl.scribblon.riftcraft.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import nl.scribblon.riftcraft.reference.DefaultConfigurations;
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
        configuration.addCustomCategoryComment(DefaultConfigurations.Values.GENERAL_CATEGORY_NAME, DefaultConfigurations.Values.GENERAL_CATEGORY_COMMENT);

        Settings.General.isHTExternalPowerRequired = configuration.get(DefaultConfigurations.Values.GENERAL_CATEGORY_NAME, DefaultConfigurations.Values.HIGH_TECH_POWER_NAME, DefaultConfigurations.Values.HIGH_TECH_POWER_VALUE, DefaultConfigurations.Values.HIGH_TECH_POWER_COMMENT).getBoolean(DefaultConfigurations.Values.HIGH_TECH_POWER_VALUE);
        Settings.General.isDeathProtected = configuration.get(DefaultConfigurations.Values.GENERAL_CATEGORY_NAME, DefaultConfigurations.Values.DEATH_PROTECTION_NAME, DefaultConfigurations.Values.DEATH_PROTECTION_VALUE, DefaultConfigurations.Values.DEATH_PROTECTION_COMMENT).getBoolean(DefaultConfigurations.Values.DEATH_PROTECTION_VALUE);
        Settings.General.isAbuseProtected = configuration.get(DefaultConfigurations.Values.GENERAL_CATEGORY_NAME, DefaultConfigurations.Values.ABUSE_PROTECTION_NAME, DefaultConfigurations.Values.ABUSE_PROTECTION_VALUE, DefaultConfigurations.Values.ABUSE_PROTECTION_COMMENT).getBoolean(DefaultConfigurations.Values.ABUSE_PROTECTION_VALUE);
        Settings.General.isWorldProtected = configuration.get(DefaultConfigurations.Values.GENERAL_CATEGORY_NAME, DefaultConfigurations.Values.VOID_PROTECTION_NAME, DefaultConfigurations.Values.VOID_PROTECTION_VALUE, DefaultConfigurations.Values.VOID_PROTECTION_COMMENT).getBoolean(DefaultConfigurations.Values.VOID_PROTECTION_VALUE);

        //World Generation
        configuration.addCustomCategoryComment(DefaultConfigurations.Values.GENERATION_CATEGORY_NAME, DefaultConfigurations.Values.GENERATION_CATEGORY_COMMENT);

        Settings.Generation.areStructuresGenerated = configuration.get(DefaultConfigurations.Values.GENERATION_CATEGORY_NAME, DefaultConfigurations.Values.GENERATION_NAME, DefaultConfigurations.Values.GENERATION_VALUE, DefaultConfigurations.Values.GENERATION_COMMENT).getBoolean(DefaultConfigurations.Values.GENERATION_VALUE);
        Settings.Generation.areRiftsRegenerating = configuration.get(DefaultConfigurations.Values.GENERATION_CATEGORY_NAME, DefaultConfigurations.Values.REGENERATE_NATURAL_NAME, DefaultConfigurations.Values.REGENERATE_NATURAL_VALUE, DefaultConfigurations.Values.REGENERATE_NATURAL_COMMENT).getBoolean(DefaultConfigurations.Values.REGENERATE_NATURAL_VALUE);

        //Conversion Variables
        configuration.addCustomCategoryComment(DefaultConfigurations.Values.CONVERSION_CATEGORY_NAME, DefaultConfigurations.Values.CONVERSION_CATEGORY_COMMENT);
        
        Settings.Conversion.rfConversionRate = configuration.get(DefaultConfigurations.Values.CONVERSION_CATEGORY_NAME, DefaultConfigurations.Values.RF_NAME, DefaultConfigurations.Values.RF_VALUE).getDouble(DefaultConfigurations.Values.RF_VALUE);
        Settings.Conversion.euConversionRate = configuration.get(DefaultConfigurations.Values.CONVERSION_CATEGORY_NAME, DefaultConfigurations.Values.EU_NAME, DefaultConfigurations.Values.EU_VALUE).getDouble(DefaultConfigurations.Values.EU_VALUE);
        Settings.Conversion.mjConversionRate = configuration.get(DefaultConfigurations.Values.CONVERSION_CATEGORY_NAME, DefaultConfigurations.Values.MJ_NAME, DefaultConfigurations.Values.MJ_VALUE).getDouble(DefaultConfigurations.Values.MJ_VALUE);

        //Debug Settings
        configuration.addCustomCategoryComment(DefaultConfigurations.Values.DEBUG_CATEGORY_NAME, DefaultConfigurations.Values.DEBUG_CATEGORY_COMMENT);

        Settings.Debug.isDebugging = configuration.get(DefaultConfigurations.Values.DEBUG_CATEGORY_NAME, DefaultConfigurations.Values.DEBUG_MODE_NAME, DefaultConfigurations.Values.DEBUG_MODE_VALUE, DefaultConfigurations.Values.DEBUG_MODE_COMMENT).getBoolean(DefaultConfigurations.Values.DEBUG_MODE_VALUE);

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
        configuration.setCategoryPropertyOrder(DefaultConfigurations.Values.GENERAL_CATEGORY_NAME, DefaultConfigurations.Properties.GENERAL_ORDER);
        configuration.setCategoryPropertyOrder(DefaultConfigurations.Values.GENERATION_CATEGORY_NAME, DefaultConfigurations.Properties.GENERATING_ORDER);

        configuration.setCategoryRequiresMcRestart(DefaultConfigurations.Values.CONVERSION_CATEGORY_NAME, DefaultConfigurations.Properties.CONVERSION_REQUIRES_REBOOT);

        configuration.getCategory(DefaultConfigurations.Values.DEBUG_CATEGORY_NAME).setShowInGui(DefaultConfigurations.Properties.IS_DEBUG_GUIABLE);
    }

}
