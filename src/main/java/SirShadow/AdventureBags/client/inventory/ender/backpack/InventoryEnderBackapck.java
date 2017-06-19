package SirShadow.AdventureBags.client.inventory.ender.backpack;

import SirShadow.AdventureBags.api.BagBindingUtils;
import SirShadow.AdventureBags.common.utils.handler.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nonnull;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class InventoryEnderBackapck implements IInventory
{
        protected NonNullList<ItemStack> inventory;

        public static String Special_Backpack_Tag = ConfigurationHandler.backpack_tag;

        protected static String NBT_ITEMS = "backpackItems";

    public InventoryEnderBackapck(EntityPlayer player)
        {
            inventory = NonNullList.withSize(45,ItemStack.EMPTY);
            readFromNBT(BagBindingUtils.getInventoryTagOfPlayer(player,Special_Backpack_Tag));

        }

    public void onGuiSaved(EntityPlayer entityPlayer)
    {
        save(entityPlayer);
    }



    public void save(EntityPlayer player)
    {
        NBTTagCompound tag = BagBindingUtils.getInventoryTagOfPlayer(player,Special_Backpack_Tag);
        writeToNBT(tag);
        BagBindingUtils.setInventoryTagOfPlayer(player,Special_Backpack_Tag ,tag);
    }

    @Override
    public int getSizeInventory()
    {
        return inventory.size();
    }

    @Override
    public ItemStack getStackInSlot(int slotIndex)
    {
        return inventory.get(slotIndex);
    }

    @Override
    public ItemStack decrStackSize(int slotIndex, int decrementAmount)
    {
        ItemStack itemStack = getStackInSlot(slotIndex);
        if (itemStack != null)
        {
            if (itemStack.getCount() <= decrementAmount)
            {
                setInventorySlotContents(slotIndex, ItemStack.EMPTY);
            }
            else
            {
                itemStack = itemStack.splitStack(decrementAmount);
                if (itemStack.getCount() == 0)
                {
                    setInventorySlotContents(slotIndex, ItemStack.EMPTY);
                }
            }
        }

        return itemStack;
    }

    @Override
    public ItemStack removeStackFromSlot(int slotIndex)
    {
        ItemStack stack = inventory.get(slotIndex);
        inventory.remove(stack);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slotIndex,@Nonnull ItemStack itemStack)
    {
        this.inventory.set(slotIndex,itemStack);
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
    public boolean isEmpty() {
        return inventory == null;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer)
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
                inventory = NonNullList.withSize(this.getSizeInventory(),ItemStack.EMPTY);
                for (int i = 0; i < tagList.tagCount(); ++i)
                {
                    NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
                    byte slotIndex = tagCompound.getByte("Slot");
                    if (slotIndex >= 0 && slotIndex < inventory.size())
                    {
                        inventory.set(slotIndex, new ItemStack(tagCompound));
                    }
                }
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.size(); ++currentIndex) {
            NBTTagCompound tagCompound = new NBTTagCompound();
            tagCompound.setByte("Slot", (byte) currentIndex);
            inventory.get(currentIndex).writeToNBT(tagCompound);
            tagList.appendTag(tagCompound);

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
