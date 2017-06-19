package SirShadow.AdventureBags.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by SirShadow for the mod Roots on 22.7.2016.
 */
public class RecipeManager {

    public static void register() {
        Object o1 = new Object[]{" R ", "LEL", "LLL", 'R', new ItemStack(Items.BLAZE_POWDER), 'L', new ItemStack(Items.LEATHER), 'E', new ItemStack(Items.ENDER_EYE)};
        addRecipe(new ItemStack(RegistyManeger.itemEnderBag),o1);
        addRecipe(new ItemStack(RegistyManeger.itemReinforcedLeather), new Object[]{"SSS", "SLS", "SSS", 'S', new ItemStack(Items.STRING), 'L', new ItemStack(Items.LEATHER)});
        addRecipe(new ItemStack(RegistyManeger.itemEnderBackpack), new Object[]{" R ", "LEL", "LLL", 'R', new ItemStack(Items.BLAZE_POWDER), 'L', new ItemStack(RegistyManeger.itemReinforcedLeather), 'E', new ItemStack(Items.NETHER_STAR)});

    }

    public static void addRecipe(ItemStack output,Object o){
        GameRegistry.register(new ShapedOreRecipe(new ResourceLocation("",""),output,true,o).setRegistryName("recipe" + output.getItem().getRegistryName()));
    }
}
