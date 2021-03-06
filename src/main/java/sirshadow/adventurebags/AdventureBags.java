package sirshadow.adventurebags;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sirshadow.adventurebags.proxys.IProxy;
import sirshadow.adventurebags.registry.RegistryManager;

import static sirshadow.adventurebags.lib.ModLibrary.ModInfo.*;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
@Mod(modid = MOD_ID,name = NAME,version = VERSION,useMetadata = true,guiFactory = "sirshadow.adventurebags.proxys.GuiFactory")
public class AdventureBags
{
    @Mod.Instance(MOD_ID)
    public static AdventureBags instance;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS,serverSide = SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }


    public static CreativeTabs tabAdventure = new CreativeTabs(MOD_ID){
        @Override
        public ItemStack getIconItemStack()
        {
            return new ItemStack(RegistryManager.itemEnderBag,1,0);
        }

        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(RegistryManager.itemEnderBag);
        }
    };
}
