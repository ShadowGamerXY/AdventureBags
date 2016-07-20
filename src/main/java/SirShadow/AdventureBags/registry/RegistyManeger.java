package SirShadow.AdventureBags.registry;

import SirShadow.AdventureBags.common.items.ItemBaseAB;
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

    public static ItemBaseAB itemBasicBag;

    public static void regiser()
    {

    }
    @SideOnly(Side.CLIENT)
    public static void initModelsAndVariants()
    {
        ITEMS.forEach(ItemBaseAB::initModelsAndVariants);
        //ITEMS_SWORD.forEach(ItemSwordHE::initModelsAndVariants);
    }

}
