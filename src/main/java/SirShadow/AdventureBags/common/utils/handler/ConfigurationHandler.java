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

    public static boolean dimension_Lock;

    public static String bag_tag,backpack_tag;

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
        dimension_Lock = configuration.getBoolean("Bag_Dimension_Lock",Configuration.CATEGORY_GENERAL,false,"If returns true it the all bags will work only in overworld!");

        bag_tag = configuration.getString("ender_satchel_tag",Configuration.CATEGORY_GENERAL,"EnderSatchelTag","The special tag for the bag!");
        backpack_tag =configuration.getString("ender_backpack_tag",Configuration.CATEGORY_GENERAL,"EnderBackpackTag","The special tag for the backpack");

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
