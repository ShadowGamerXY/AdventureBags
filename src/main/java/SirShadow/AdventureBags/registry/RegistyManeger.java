package SirShadow.AdventureBags.registry;

import SirShadow.AdventureBags.common.items.ItemBaseAB;
import SirShadow.AdventureBags.common.items.bags.ItemEnderBackpack;
import SirShadow.AdventureBags.common.items.bags.itemEnderBag;
import SirShadow.AdventureBags.common.items.components.ItemReinforcedLeather;
import SirShadow.AdventureBags.lib.LibMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class RegistyManeger
{
    public static List<ItemBaseAB>ITEMS = new ArrayList();

    public static ItemBaseAB itemEnderBag = new itemEnderBag(),
                             itemReinforcedLeather = new ItemReinforcedLeather(),
                             itemEnderBackpack = new ItemEnderBackpack();


    public static void regiser()
    {
        GameRegistry.register(itemEnderBag);
        GameRegistry.register(itemReinforcedLeather);
        GameRegistry.register(itemEnderBackpack);
    }
    @SideOnly(Side.CLIENT)
    public static void initItemModelsAndVariants()
    {
        ITEMS.forEach(ItemBaseAB::initModelsAndVariants);
    }

}
