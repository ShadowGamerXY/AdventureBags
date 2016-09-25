package SirShadow.AdventureBags.common.items.bags;

import SirShadow.AdventureBags.client.EnumIDs;
import SirShadow.AdventureBags.common.items.ItemBaseAB;
import SirShadow.AdventureBags.common.utils.Util;
import SirShadow.AdventureBags.common.utils.handler.ConfigurationHandler;
import SirShadow.AdventureBags.common.utils.helper.TextHelper;
import SirShadow.AdventureBags.lib.LibMain;
import net.minecraft.client.Minecraft;
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
 * Created by SirShadow on 21. 07. 2016.
 */
public class itemEnderBag extends ItemBaseAB
{

    int x,y,z;

    boolean shouldShow;

    public itemEnderBag()
    {
        super(LibMain.LibNames.ender_bag);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
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
            if (shouldShow)
            {
                tooltip.add("Saved position:");
                tooltip.add("X:" + Integer.toString(x) + " Y:" + Integer.toString(y) + " Z:" + Integer.toString(z));
            }
        }
        tooltip.add(TextFormatting.RED + "Dimension lock is active!");
    }

    public void createData(ItemStack stack)
    {
        NBTTagCompound tag = stack.getTagCompound();
        if(tag == null)
        {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }

        tag.setBoolean("show",shouldShow);
        tag.setInteger("x",x);
        tag.setInteger("y",y);
        tag.setInteger("z",z);
    }

    public void readData(ItemStack stack)
    {
        NBTTagCompound tag = stack.getTagCompound();
        if(tag == null)
        {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
        tag.getBoolean("show");
        tag.getInteger("x");
        tag.getInteger("y");
        tag.getInteger("z");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if (!worldIn.isRemote)
        {
            if (ConfigurationHandler.waypoint_marker)
            {
                if (playerIn.isSneaking())
                {
                    x = (int) playerIn.posX;
                    y = (int) playerIn.posY;
                    z = (int) playerIn.posZ;

                    shouldShow = true;
                }
            }
            if (!ConfigurationHandler.dimension_Lock)
            {
                Util.openGUI(playerIn, worldIn, EnumIDs.GUI_ENDER_BAG);
                return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
            } else
            {
                if (playerIn.dimension == DimensionType.OVERWORLD.getId())
                {
                    Util.openGUI(playerIn, worldIn, EnumIDs.GUI_ENDER_BAG);
                    return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
                } else
                {
                    return new ActionResult<>(EnumActionResult.FAIL, itemStackIn);
                }
            }
        }
            return new ActionResult<>(EnumActionResult.PASS, itemStackIn);
    }
}
