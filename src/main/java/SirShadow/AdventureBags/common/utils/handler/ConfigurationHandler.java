package SirShadow.AdventureBags.common.utils.handler;

import SirShadow.AdventureBags.lib.LibMain;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

/**
 * Created by SirShadow for the mod Roots on 27.7.2016.
 */
public class ConfigurationHandler
{
    public static Configuration configuration;

    public static boolean hard_bag_recipe;

    public static void init(File configFile)
    {
        if(configuration == null)
        {
            configuration = new Configuration(configFile);
            load();
        }
    }

    public static void load()
    {
        hard_bag_recipe = configuration.getBoolean("hard_bag_recipe",Configuration.CATEGORY_GENERAL,false,"Needs a game restart!");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equalsIgnoreCase(LibMain.MOD_ID))
        {
            load();
        }
    }
}
