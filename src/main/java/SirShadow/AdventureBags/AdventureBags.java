package SirShadow.AdventureBags;

import SirShadow.AdventureBags.lib.LibMain;
import SirShadow.AdventureBags.proxys.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
@Mod(modid = LibMain.MOD_ID,name = LibMain.NAME,version = LibMain.VERSION,useMetadata = true)
public class AdventureBags
{
    @Mod.Instance(LibMain.MOD_ID)
    public static AdventureBags instance;

    @SidedProxy(clientSide = LibMain.CLIENT_PROXY_CLASS,serverSide = LibMain.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
