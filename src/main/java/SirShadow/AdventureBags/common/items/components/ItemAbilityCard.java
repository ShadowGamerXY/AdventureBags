package SirShadow.AdventureBags.common.items.components;

import SirShadow.AdventureBags.common.items.ItemBaseAB;
import SirShadow.AdventureBags.common.items.bags.ItemEnderBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by TeamRoots on 11.8.2016.
 */
public class ItemAbilityCard extends ItemBaseAB
{

    private static String[] variants = {"quickAccess"};

    public ItemAbilityCard(String name, String... variants) {
        super("itemAbilityCard ", variants);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        switch (itemStackIn.getItemDamage())
        {
            case 0:
                ItemEnderBackpack.quickAccess = true;
        }
        return new ActionResult<ItemStack>(EnumActionResult.FAIL,itemStackIn);
    }
}
