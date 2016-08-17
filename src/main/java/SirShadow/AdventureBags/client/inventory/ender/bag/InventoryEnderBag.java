package SirShadow.AdventureBags.client.inventory.ender.bag;

import SirShadow.AdventureBags.api.BagBindingUtils;
import SirShadow.AdventureBags.common.utils.handler.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.ITextComponent;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class InventoryEnderBag implements IInventory
{
        protected ItemStack[] inventory;

        public static String Special_Bag_Tag = ConfigurationHandler.bag_tag;

        protected static String NBT_ITEMS = "spells";

    public InventoryEnderBag(EntityPlayer player)
        {
            inventory = new ItemStack[18];
            readFromNBT(BagBindingUtils.getInventoryTagOfPlayer(player,Special_Bag_Tag));

        }

    public void onGuiSaved(EntityPlayer entityPlayer)
    {
        save(entityPlayer);
    }



    public void save(EntityPlayer player)
    {
        NBTTagCompound tag = BagBindingUtils.getInventoryTagOfPlayer(player,Special_Bag_Tag);
        writeToNBT(tag);
        BagBindingUtils.setInventoryTagOfPlayer(player,Special_Bag_Tag ,tag);
    }

    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slotIndex)
    {
        return slotIndex >= 0 && slotIndex < this.inventory.length ? inventory[slotIndex] : null;
    }

    @Override
    public ItemStack decrStackSize(int slotIndex, int decrementAmount)
    {
        ItemStack itemStack = getStackInSlot(slotIndex);
        if (itemStack != null)
        {
            if (itemStack.stackSize <= decrementAmount)
            {
                setInventorySlotContents(slotIndex, null);
            }
            else
            {
                itemStack = itemStack.splitStack(decrementAmount);
                if (itemStack.stackSize == 0)
                {
                    setInventorySlotContents(slotIndex, null);
                }
            }
        }

        return itemStack;
    }

    @Override
    public ItemStack removeStackFromSlot(int slotIndex)
    {
        if (inventory[slotIndex] != null)
        {
            ItemStack itemStack = inventory[slotIndex];
            inventory[slotIndex] = null;
            return itemStack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slotIndex, ItemStack itemStack)
    {
        if (slotIndex >= 0 && slotIndex < this.inventory.length)
        {
            this.inventory[slotIndex] = itemStack;
        }
    }

    @Override
    public String getName()
    {
        return "SpellBook";
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void markDirty()
    {
        // NOOP
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer)
    {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {
        // NOOP
    }

    @Override
    public void closeInventory(EntityPlayer player)
    {
        // NOOP
    }

    @Override
    public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack)
    {
        return true;
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        if (nbtTagCompound != null && nbtTagCompound.hasKey(NBT_ITEMS))
        {
            // Read in the ItemStacks in the inventory from NBT
            if (nbtTagCompound.hasKey(NBT_ITEMS))
            {
                NBTTagList tagList = nbtTagCompound.getTagList(NBT_ITEMS, 10);
                inventory = new ItemStack[this.getSizeInventory()];
                for (int i = 0; i < tagList.tagCount(); ++i)
                {
                    NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
                    byte slotIndex = tagCompound.getByte("Slot");
                    if (slotIndex >= 0 && slotIndex < inventory.length)
                    {
                        inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
                    }
                }
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex)
        {
            if (inventory[currentIndex] != null)
            {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag(NBT_ITEMS, tagList);
    }

    public static boolean hasTag(ItemStack itemStack, String keyName)
    {
        return itemStack != null && itemStack.getTagCompound() != null && itemStack.getTagCompound().hasKey(keyName);
    }

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }

    @Override
    public int getField(int id)
    {
        return 0;
    }

    @Override
    public void setField(int id, int value)
    {

    }

    @Override
    public int getFieldCount()
    {
        return 0;
    }

    @Override
    public void clear()
    {

    }
}
