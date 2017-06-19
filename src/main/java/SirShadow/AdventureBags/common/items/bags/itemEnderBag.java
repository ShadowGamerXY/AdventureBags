package SirShadow.AdventureBags.common.items.bags;

import SirShadow.AdventureBags.api.IBagAbility;
import SirShadow.AdventureBags.client.EnumIDs;
import SirShadow.AdventureBags.common.items.ItemBase;
import SirShadow.AdventureBags.common.utils.Util;
import SirShadow.AdventureBags.common.utils.handler.ConfigurationHandler;
import SirShadow.AdventureBags.common.utils.helper.TextHelper;
import SirShadow.AdventureBags.lib.LibMain;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class itemEnderBag extends ItemBase implements IBagAbility {

    public static boolean isLocked = false;

    public itemEnderBag() {
        super(LibMain.LibNames.ender_bag);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (player.isSneaking()) {
            if (!isLocked) {
                isLocked = true;
                return EnumActionResult.SUCCESS;
            }
        } else {
            if (isLocked) {
                isLocked = false;
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.PASS;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        tooltip.add("Is bag locked: " + TextFormatting.RED + isLocked);
        if (TextHelper.displayShiftForDetail && !TextHelper.isShiftPressed())
        {
            tooltip.add("<Shift for details>");
        }
        if (!TextHelper.isShiftPressed()) {
            return;
        }
            tooltip.add("Inventory special tag: " + TextHelper.LIGHT_BLUE +ConfigurationHandler.bag_tag);
            if (ConfigurationHandler.dimension_Lock) {
                tooltip.add(TextFormatting.RED + "Dimension lock is active!");
            }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack itemStackIn = playerIn.getHeldItem(hand);
        if (!worldIn.isRemote) {
            if (!ConfigurationHandler.dimension_Lock) {
                if (!isLocked) {
                    Util.openGUI(playerIn,worldIn,EnumIDs.GUI_ENDER_BAG,isLocked);
                    return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
                } else {
                    return new ActionResult<>(EnumActionResult.FAIL, itemStackIn);
                }
            }
            else {
                if(playerIn.dimension == DimensionType.OVERWORLD.getId())
                {
                    if (!isLocked) {
                        Util.openGUI(playerIn,worldIn,EnumIDs.GUI_ENDER_BAG,isLocked);
                        return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
                    } else {
                        return new ActionResult<>(EnumActionResult.FAIL, itemStackIn);
                    }
                }
                else {
                    return new ActionResult<>(EnumActionResult.FAIL, itemStackIn);
                }
            }
        }
        return new ActionResult<>(EnumActionResult.PASS, itemStackIn);
    }

    @Override
    public void setLockState(ItemStack stack)
    {
        NBTTagCompound tag = stack.getTagCompound();
        if(tag == null)
        {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
        tag.setBoolean(LibMain.LibTags.bagLockTag,isLocked);
    }

    @Override
    public void getLockState(ItemStack stack)
    {
        NBTTagCompound tag = stack.getTagCompound();
        if(tag == null)
        {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
        tag.getBoolean(LibMain.LibTags.bagLockTag);
    }
}
