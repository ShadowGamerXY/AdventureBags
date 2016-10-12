package SirShadow.AdventureBags.common.items.bags;

import SirShadow.AdventureBags.client.EnumIDs;
import SirShadow.AdventureBags.common.items.ItemBaseAB;
import SirShadow.AdventureBags.common.utils.Util;
import SirShadow.AdventureBags.common.utils.handler.ConfigurationHandler;
import SirShadow.AdventureBags.common.utils.helper.TextHelper;
import SirShadow.AdventureBags.lib.LibMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by SirShadow for the mod Roots on 27.7.2016.
 */
public class ItemEnderBackpack extends ItemBaseAB
{
    public ItemEnderBackpack() {
        super(LibMain.LibNames.ender_backpack);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        if (ConfigurationHandler.waypoint_marker)
        {
            if (TextHelper.displayShiftForDetail && !TextHelper.isShiftPressed())
            {
                tooltip.add("<Shift for details>");
            }
            if (!TextHelper.isShiftPressed())
            {
                return;
            }
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if (!worldIn.isRemote)
        {
            if (!ConfigurationHandler.dimension_Lock)
            {
                Util.openGUI(playerIn, worldIn, EnumIDs.GUI_ENDER_BACKPACK);
                return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
            } else
            {
                if (playerIn.dimension == DimensionType.OVERWORLD.getId())
                {
                    Util.openGUI(playerIn, worldIn, EnumIDs.GUI_ENDER_BACKPACK);
                    return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
                }
            }
        }
        return new ActionResult<>(EnumActionResult.PASS, itemStackIn);
    }
}
