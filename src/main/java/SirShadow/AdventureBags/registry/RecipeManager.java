package SirShadow.AdventureBags.registry;

import SirShadow.AdventureBags.lib.LibMain;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by SirShadow for the mod Roots on 22.7.2016.
 */
public class RecipeManager {

    public static void register() {
        CraftingManager.func_193373_a(new ResourceLocation(LibMain.ModInfo.MOD_ID,"recipes/recipebag.json"));
        CraftingManager.func_193373_a(new ResourceLocation(LibMain.ModInfo.MOD_ID,"recipes/recipebackpack.json"));
    }
}
