package sirshadow.adventurebags.common.items.bags;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import sirshadow.adventurebags.client.EnumIDs;
import sirshadow.adventurebags.common.utils.Util;
import sirshadow.adventurebags.common.utils.handler.ConfigurationHandler;
import sirshadow.adventurebags.lib.ModLibrary;

/**
 * Created by SirShadow for the mod Roots on 27.7.2016.
 */
public class ItemEnderBackpack extends ItemBag
{
    public ItemEnderBackpack() {
        super(ModLibrary.LibNames.ender_backpack);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack itemStackIn = playerIn.getHeldItem(hand);

        if (!worldIn.isRemote) {
            if (!ConfigurationHandler.dimension_Lock) {
                Util.openGUI(playerIn, worldIn, EnumIDs.GUI_ENDER_BACKPACK, false);
                return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
            } else {
                if (playerIn.dimension == DimensionType.OVERWORLD.getId()) {
                    Util.openGUI(playerIn, worldIn, EnumIDs.GUI_ENDER_BACKPACK, false);
                    return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
                }
            }
        }
        return new ActionResult<>(EnumActionResult.PASS, itemStackIn);
    }
}
