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
import sirshadow.adventurebags.lib.ModLibrary;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by sirshadow on 10/17/17.
 */
public class ItemBag extends ItemBase {

    public ItemBag(String name) {
        super(name);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
}
