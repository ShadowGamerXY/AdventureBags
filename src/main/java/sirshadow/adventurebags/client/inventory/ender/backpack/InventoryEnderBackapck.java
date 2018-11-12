package sirshadow.adventurebags.client.inventory.ender.backpack;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import sirshadow.adventurebags.api.BagBindingUtils;
import sirshadow.adventurebags.client.inventory.InventoryEnder;
import sirshadow.adventurebags.common.utils.handler.ConfigurationHandler;

import javax.annotation.Nonnull;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class InventoryEnderBackapck extends InventoryEnder {
    public InventoryEnderBackapck(EntityPlayer player) {
        super(player, "backpack_tag", "backpackItems", 45);
    }
}

