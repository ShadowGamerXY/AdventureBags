package SirShadow.AdventureBags.common.items.bags;

import SirShadow.AdventureBags.AdventureBags;
import SirShadow.AdventureBags.api.ILockedBag;
import SirShadow.AdventureBags.client.EnumIDs;
import SirShadow.AdventureBags.client.inventory.ender.InventoryEnderBackapck;
import SirShadow.AdventureBags.client.inventory.ender.InventoryEnderBag;
import SirShadow.AdventureBags.common.items.ItemBaseAB;
import SirShadow.AdventureBags.common.utils.Util;
import SirShadow.AdventureBags.common.utils.handler.ConfigurationHandler;
import SirShadow.AdventureBags.common.utils.helper.TextHelper;
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

import java.util.List;

/**
 * Created by SirShadow for the mod Roots on 27.7.2016.
 */
public class ItemEnderBackpack extends ItemBaseAB implements ILockedBag
{

    public static boolean isLocked = false;
    public String isLockedString = "isLocked";

    public ItemEnderBackpack() {
        super("itemEnderBackpack");
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if(playerIn.isSneaking())
        {
            if(!isLocked)
            {
                isLocked = true;
                return EnumActionResult.SUCCESS;
            }
        }
        else
        {
            if(isLocked) {
                isLocked = false;
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.PASS;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        tooltip.add("Is bag locked: " + TextFormatting.RED + isLocked);
        if (TextHelper.displayShiftForDetail && !TextHelper.isShiftPressed())
        {
            tooltip.add("<Shift for details>");
        }
        if (!TextHelper.isShiftPressed()) {
            return;
        }
        tooltip.add("Special inventory tag: " + TextHelper.LIGHT_BLUE +ConfigurationHandler.backpack_tag);
        if(ConfigurationHandler.dimension_Lock)
        {
            tooltip.add(TextFormatting.RED + "Dimension lock is active!");
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(!worldIn.isRemote) {
            if(!ConfigurationHandler.dimension_Lock) {
                if (!isLocked) {
                    Util.openGUI(playerIn,worldIn,EnumIDs.GUI_ENDER_BACKPACK,isLocked);
                    return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
                }
            }else
            {
                if(playerIn.dimension == DimensionType.OVERWORLD.getId())
                {
                    if (!isLocked) {
                        Util.openGUI(playerIn,worldIn,EnumIDs.GUI_ENDER_BACKPACK,isLocked);
                        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
                    }
                }
                else
                {

                }
            }
        }
        return new ActionResult(EnumActionResult.PASS, itemStackIn);
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
        tag.setBoolean(this.isLockedString,isLocked);
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
        tag.getBoolean(isLockedString);
    }
}
