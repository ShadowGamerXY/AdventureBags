package SirShadow.AdventureBags.registry;

import SirShadow.AdventureBags.common.Block.BlockContainerBase;
import SirShadow.AdventureBags.common.Block.BlockEnderCrate;
import SirShadow.AdventureBags.common.items.ItemBaseAB;
import SirShadow.AdventureBags.common.items.bags.ItemEnderBackpack;
import SirShadow.AdventureBags.common.items.bags.itemEnderBag;
import SirShadow.AdventureBags.common.items.components.ItemReinforcedLeather;
import SirShadow.AdventureBags.common.tile.TEEnderCrate;
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
    public static List<ItemBaseAB>ITEMS = new ArrayList();
    public static List<BlockContainerBase>Block_Container = new ArrayList<>();

    public static ItemBaseAB itemEnderBag = new itemEnderBag(),
                             itemReinforcedLeather = new ItemReinforcedLeather(),
                             itemEnderBackpack = new ItemEnderBackpack();
    public static BlockContainerBase blockContainerEnderCrate = new BlockEnderCrate();


    public static void regiser()
    {
        GameRegistry.register(itemEnderBag);
        GameRegistry.register(itemReinforcedLeather);
        GameRegistry.register(itemEnderBackpack);

        for (BlockContainerBase blockCHE : Block_Container) {
            GameRegistry.register(blockCHE);
            GameRegistry.register(new ItemBlock(blockCHE).setRegistryName(blockCHE.getRegistryName()));
        }

        GameRegistry.registerTileEntity(TEEnderCrate.class,"tileEnderCrate");
    }
    @SideOnly(Side.CLIENT)
    public static void initItemModelsAndVariants()
    {
        ITEMS.forEach(ItemBaseAB::initModelsAndVariants);
    }

}
