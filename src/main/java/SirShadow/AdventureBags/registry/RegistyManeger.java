package SirShadow.AdventureBags.registry;

import SirShadow.AdventureBags.common.blocks.BlockContainerBase;
import SirShadow.AdventureBags.common.items.ItemBase;
import SirShadow.AdventureBags.common.items.bags.ItemEnderBackpack;
import SirShadow.AdventureBags.common.items.bags.itemEnderBag;
import SirShadow.AdventureBags.common.items.components.ItemReinforcedLeather;
import net.minecraft.item.ItemBlock;
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
    public static List<ItemBase>ITEMS = new ArrayList<ItemBase>();
    public static List<BlockContainerBase>Block_Container = new ArrayList<BlockContainerBase>();

    public static ItemBase itemEnderBag = new itemEnderBag(),
                             itemReinforcedLeather = new ItemReinforcedLeather(),
                             itemEnderBackpack = new ItemEnderBackpack();
    //public static BlockContainerBase blockContainerEnderCrate = new BlockEnderCrate();


    public static void regiser()
    {
        GameRegistry.register(itemEnderBag);
        GameRegistry.register(itemReinforcedLeather);
        GameRegistry.register(itemEnderBackpack);

        for (BlockContainerBase blockCHE : Block_Container) {
            GameRegistry.register(blockCHE);
            GameRegistry.register(new ItemBlock(blockCHE).setRegistryName(blockCHE.getRegistryName()));
        }
    }
    @SideOnly(Side.CLIENT)
    public static void initItemModelsAndVariants()
    {
        ITEMS.forEach(ItemBase::initModelsAndVariants);
    }

}
