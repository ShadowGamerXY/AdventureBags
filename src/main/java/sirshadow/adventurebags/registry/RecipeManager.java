package sirshadow.adventurebags.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
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
        addRecipe(new ItemStack(RegistyManeger.itemEnderBackpack), new Object[]{" R ", "LEL", "LCL", 'R', new ItemStack(Items.BLAZE_POWDER), 'L', new ItemStack(RegistyManeger.itemReinforcedLeather), 'E', new ItemStack(Items.ENDER_EYE),'C',new ItemStack(Blocks.ENDER_CHEST)});

    }

    public static void addRecipe(ItemStack output,Object o){
        ForgeRegistries.RECIPES.register(new ShapedOreRecipe(new ResourceLocation("",""),output,true,o).setRegistryName("recipe" + output.getItem().getRegistryName()));
    }
}
