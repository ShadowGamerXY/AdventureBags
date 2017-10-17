package sirshadow.adventurebags.proxys;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import sirshadow.adventurebags.AdventureBags;
import sirshadow.adventurebags.client.GuiHandler;
import sirshadow.adventurebags.common.EventHandler;
import sirshadow.adventurebags.common.network.PacketHandler;
import sirshadow.adventurebags.common.utils.handler.ConfigurationHandler;
import sirshadow.adventurebags.common.utils.handler.KeyBindings;
import sirshadow.adventurebags.common.utils.handler.KeyInputHandler;
import sirshadow.adventurebags.registry.RecipeManager;
import sirshadow.adventurebags.registry.RegistyManeger;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public abstract class CommonProxy implements IProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent e)
    {
        ConfigurationHandler.init(e.getSuggestedConfigurationFile());
        eventRegistry();
        RegistyManeger.regiser();
        registerKeybinds();
        PacketHandler.register();
    }

    @Override
    public void init(FMLInitializationEvent e)
    {
        newtworkRegistry();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        RecipeManager.register();
    }


    private static void eventRegistry()
    {
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    private void registerKeybinds(){
        FMLCommonHandler.instance().bus().register(new KeyInputHandler());
        for(KeyBindings key : KeyBindings.values()) {
            ClientRegistry.registerKeyBinding(key.getKeyBid());
        }

    }

    private static void newtworkRegistry()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(AdventureBags.instance,new GuiHandler());
    }
}
