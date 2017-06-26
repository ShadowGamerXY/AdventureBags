package sirshadow.adventurebags.registry;

import net.minecraftforge.fml.common.registry.ForgeRegistries;
import sirshadow.adventurebags.common.blocks.BlockContainerBase;
import sirshadow.adventurebags.common.items.ItemBase;
import sirshadow.adventurebags.common.items.bags.ItemEnderBackpack;
import sirshadow.adventurebags.common.items.bags.itemEnderBag;
import sirshadow.adventurebags.common.items.components.ItemReinforcedLeather;
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


    public static void regiser()
    {
        ITEMS.forEach(ForgeRegistries.ITEMS::register);

        for (BlockContainerBase blockCHE : Block_Container) {
            ForgeRegistries.BLOCKS.register(blockCHE);
            ForgeRegistries.ITEMS.register(new ItemBlock(blockCHE).setRegistryName(blockCHE.getRegistryName()));
        }
    }
    @SideOnly(Side.CLIENT)
    public static void initItemModelsAndVariants()
    {
        ITEMS.forEach(ItemBase::initModelsAndVariants);
    }

}
