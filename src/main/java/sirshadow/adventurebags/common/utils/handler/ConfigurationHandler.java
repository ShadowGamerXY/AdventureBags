package sirshadow.adventurebags.common.utils.handler;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sirshadow.adventurebags.lib.LibMain;

import java.io.File;

/**
 * Created by SirShadow for the mod Roots on 27.7.2016.
 */
public class ConfigurationHandler
{
    public static Configuration configuration;

    public static boolean dimension_Lock;

    public static String bag_tag,backpack_tag;

    public static String CATEGORY_MISC = "misc";

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
        dimension_Lock = configuration.getBoolean("Bag_Dimension_Lock",Configuration.CATEGORY_GENERAL,false,"If returns true it the all bags will work only in overworld!");

        bag_tag = configuration.getString("ender_satchel_tag",CATEGORY_MISC,"EnderSatchelTag","The special tag for the bag!");
        backpack_tag =configuration.getString("ender_backpack_tag",CATEGORY_MISC,"EnderBackpackTag","The special tag for the backpack");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equalsIgnoreCase(LibMain.ModInfo.MOD_ID))
        {
            load();
        }
    }
}
