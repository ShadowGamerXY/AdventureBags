package SirShadow.AdventureBags.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by SirShadow for the mod Roots on 22.7.2016.
 */
public class RecipeManeger
{

    private static final ItemStack ENDER_BAG = new ItemStack(RegistyManeger.itemEnderBag);


    public static void regiser()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistyManeger.itemEnderBag),true,new Object[]{" R ","LEL","LLL",'R', new ItemStack(Blocks.END_ROD),'L',new ItemStack(Items.LEATHER),'E',new ItemStack(Items.ENDER_EYE)}));
    }

}
