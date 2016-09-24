package SirShadow.AdventureBags.lib;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class LibMain
{
    public class ModInfo {
        public static final String
                MOD_ID = "adventurebags",
                NAME = "Adventure Bags",
                VERSION = "0.4",
                CLIENT_PROXY_CLASS = "SirShadow.AdventureBags.proxys.ClientProxy",
                SERVER_PROXY_CLASS = "SirShadow.AdventureBags.proxys.ServerProxy";
    }
    public class LibTags
    {
        public static final String
                backpackLockTag = "[backpackLockTag]",
                bagLockTag = "[bagLockTag]";
    }

    public class LibNames
    {
        public static final String ender_bag = "itemEnderBag",ender_backpack = "itemEnderBackpack";
    }

    public class ContainerLib
    {
        public static final int INVENTORY_X = 8,INVENTORY_Y = 88;
    }
}
