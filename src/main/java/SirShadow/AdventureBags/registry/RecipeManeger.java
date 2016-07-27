package SirShadow.AdventureBags.registry;

import SirShadow.AdventureBags.common.utils.handler.ConfigurationHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by SirShadow for the mod Roots on 22.7.2016.
 */
public class RecipeManeger {

    private static final ItemStack ENDER_BAG = new ItemStack(RegistyManeger.itemEnderBag);


    public static void regiser() {
        if (!ConfigurationHandler.hard_bag_recipe) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistyManeger.itemEnderBag), true, new Object[]{" R ", "LEL", "LLL", 'R', new ItemStack(Items.BLAZE_POWDER), 'L', new ItemStack(Items.LEATHER), 'E', new ItemStack(Items.ENDER_EYE)}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistyManeger.itemReinforcedLeather), true, new Object[]{"SSS", "SLS", "SSS", 'S', new ItemStack(Items.STRING), 'L', new ItemStack(Items.LEATHER)}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistyManeger.itemEnderBackpack), true, new Object[]{" R ", "LEL", "LLL", 'R', new ItemStack(Items.BLAZE_POWDER), 'L', new ItemStack(RegistyManeger.itemReinforcedLeather), 'E', new ItemStack(Items.NETHER_STAR)}));
        }
        else if (ConfigurationHandler.hard_bag_recipe) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistyManeger.itemEnderBag), true, new Object[]{" R ", "LEL", "LLL", 'R', new ItemStack(Blocks.END_ROD), 'L', new ItemStack(Items.LEATHER), 'E', new ItemStack(Items.ENDER_EYE)}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistyManeger.itemReinforcedLeather), true, new Object[]{"IWI", "WLW", "IWI", 'W', new ItemStack(Blocks.WOOL), 'L', new ItemStack(Items.LEATHER),'I',new ItemStack(Items.IRON_INGOT)}));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistyManeger.itemEnderBackpack), true, new Object[]{" R ", "LEL", "LLL", 'R', new ItemStack(Blocks.END_ROD), 'L', new ItemStack(RegistyManeger.itemReinforcedLeather), 'E', new ItemStack(Items.NETHER_STAR)}));
        }
    }
}
