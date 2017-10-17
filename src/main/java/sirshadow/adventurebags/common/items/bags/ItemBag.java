package sirshadow.adventurebags.common.items.bags;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import sirshadow.adventurebags.common.items.ItemBase;
import sirshadow.adventurebags.common.utils.handler.ConfigurationHandler;
import sirshadow.adventurebags.common.utils.helper.TextHelper;
import sirshadow.adventurebags.lib.LibMain;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by sirshadow on 10/17/17.
 */
public class ItemBag extends ItemBase {

    private boolean isLocked = false;

    public ItemBag(String name) {
        super(name);
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
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        if (TextHelper.displayShiftForDetail && !TextHelper.isShiftPressed())
        {
            tooltip.add("<Shift for details>");
        }
        if (!TextHelper.isShiftPressed()) {
            return;
        }
        tooltip.add("Is bag locked: " + TextFormatting.RED + isLocked);
        if(ConfigurationHandler.dimension_Lock)
        {
            tooltip.add(TextFormatting.RED + "Dimension lock is active!");
        }
    }

    public void setLockState(ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        if(tag == null)
        {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
        tag.setBoolean(LibMain.LibTags.backpackLockTag,isLocked);
    }

    public void getLockState(ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        if(tag == null)
        {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
        tag.getBoolean(LibMain.LibTags.backpackLockTag);
    }

    public boolean isBagLocked(){
        return isLocked;
    }
}
