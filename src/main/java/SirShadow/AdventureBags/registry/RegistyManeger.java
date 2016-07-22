package SirShadow.AdventureBags.registry;

import SirShadow.AdventureBags.common.items.ItemBaseAB;
import SirShadow.AdventureBags.common.items.bags.ItemBasicBag;
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

    public static ItemBaseAB itemBasicBag = new ItemBasicBag();

    public static void regiser()
    {
        GameRegistry.register(itemBasicBag);
    }
    @SideOnly(Side.CLIENT)
    public static void initItemModelsAndVariants()
    {
        ITEMS.forEach(ItemBaseAB::initModelsAndVariants);
        //ITEMS_SWORD.forEach(ItemSwordHE::initModelsAndVariants);
    }

}
