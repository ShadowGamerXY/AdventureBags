package SirShadow.AdventureBags.registry;

import SirShadow.AdventureBags.lib.LibMain;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by SirShadow for the mod Roots on 22.7.2016.
 */
public class RecipeManeger {

    private static final ItemStack ENDER_BAG = new ItemStack(RegistyManeger.itemEnderBag);


    public static void regiser() {
       /* if (!ConfigurationHandler.hard_bag_recipe) {
            addRecipe("bag_e",new ShapedOreRecipe(new ResourceLocation(LibMain.ModInfo.MOD_ID,"recipes/bag_e"),new ItemStack(RegistyManeger.itemEnderBag), true, new Object[]{" R ", "LEL", "LLL", 'R', new ItemStack(Items.BLAZE_POWDER), 'L', new ItemStack(Items.LEATHER), 'E', new ItemStack(Items.ENDER_EYE)}));
            addRecipe("leather_e",new ShapedOreRecipe(new ResourceLocation(LibMain.ModInfo.MOD_ID,"recipes/leather_e"),new ItemStack(RegistyManeger.itemReinforcedLeather), true, new Object[]{"SSS", "SLS", "SSS", 'S', new ItemStack(Items.STRING), 'L', new ItemStack(Items.LEATHER)}));
            addRecipe("backpack_e",new ShapedOreRecipe(new ResourceLocation(LibMain.ModInfo.MOD_ID,"recipes/backpack_e"),new ItemStack(RegistyManeger.itemEnderBackpack), true, new Object[]{" R ", "LEL", "LLL", 'R', new ItemStack(Items.BLAZE_POWDER), 'L', new ItemStack(RegistyManeger.itemReinforcedLeather), 'E', new ItemStack(Items.NETHER_STAR)}));
        }
        else if (ConfigurationHandler.hard_bag_recipe) {
            addRecipe("bag_h",new ShapedOreRecipe(new ResourceLocation(LibMain.ModInfo.MOD_ID,"recipes/bag_h"),new ItemStack(RegistyManeger.itemEnderBag), true, new Object[]{" R ", "LEL", "LLL", 'R', new ItemStack(Blocks.END_ROD), 'L', new ItemStack(Items.LEATHER), 'E', new ItemStack(Items.ENDER_EYE)}));
            addRecipe("leather_h",new ShapedOreRecipe(new ResourceLocation(LibMain.ModInfo.MOD_ID,"recipes/leather_h"),new ItemStack(RegistyManeger.itemReinforcedLeather), true, new Object[]{"IWI", "WLW", "IWI", 'W', new ItemStack(Blocks.WOOL), 'L', new ItemStack(Items.LEATHER),'I',new ItemStack(Items.IRON_INGOT)}));
            addRecipe("backpack_h",new ShapedOreRecipe(new ResourceLocation(LibMain.ModInfo.MOD_ID,"recipes/backpack_h"),new ItemStack(RegistyManeger.itemEnderBackpack), true, new Object[]{" R ", "LEL", "LLL", 'R', new ItemStack(Blocks.END_ROD), 'L', new ItemStack(RegistyManeger.itemReinforcedLeather), 'E', new ItemStack(Items.NETHER_STAR)}));
        }*/
    }

    public static void addRecipe(String name, IRecipe recipe){
        GameRegistry.addRecipe(new ResourceLocation(LibMain.ModInfo.MOD_ID,"recipes/"+ name),recipe);
    }
}
