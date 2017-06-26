package sirshadow.adventurebags.client.inventory.other;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import sirshadow.adventurebags.api.BagBindingUtils;

/**
 * Created by sirshadow on 6/26/17.
 */
public class InventoryPBS implements IInventory {

    public NonNullList<ItemStack> inventory;

    private String NBT_TAG = "NBT_TAG";

    public InventoryPBS(EntityPlayer player) {
        this.inventory = NonNullList.withSize(1,ItemStack.EMPTY);
        readFromNBT(BagBindingUtils.getInventoryTagOfPlayer(player,NBT_TAG));
    }

    public void onGuiSaved(EntityPlayer entityPlayer)
    {
        save(entityPlayer);
    }

    public void save(EntityPlayer player)
    {
        NBTTagCompound tag = BagBindingUtils.getInventoryTagOfPlayer(player,NBT_TAG);
        writeToNBT(tag);
        BagBindingUtils.setInventoryTagOfPlayer(player,NBT_TAG ,tag);
    }

    @Override
    public int getSizeInventory() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inventory.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        ItemStack itemStack = getStackInSlot(index);
        if (itemStack != null)
        {
            if (itemStack.getCount() <= count)
            {
                setInventorySlotContents(index, ItemStack.EMPTY);
            }
            else
            {
                itemStack = itemStack.splitStack(count);
                if (itemStack.getCount() == 0)
                {
                    setInventorySlotContents(index, ItemStack.EMPTY);
                }
            }
        }

        return itemStack;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = inventory.get(index);
        inventory.remove(stack);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.inventory.set(index,stack);
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        if (nbtTagCompound != null && nbtTagCompound.hasKey(NBT_TAG))
        {
            // Read in the ItemStacks in the inventory from NBT
            if (nbtTagCompound.hasKey(NBT_TAG))
            {
                NBTTagList tagList = nbtTagCompound.getTagList(NBT_TAG, 10);
                inventory = NonNullList.withSize(this.getSizeInventory(),ItemStack.EMPTY);
                for (int i = 0; i < tagList.tagCount(); ++i)
                {
                    NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
                    byte slotIndex = tagCompound.getByte("Slot");
                    if (slotIndex >= 0 && slotIndex < inventory.size()) {
                        inventory.set(slotIndex,new ItemStack(tagCompound));
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
        nbtTagCompound.setTag(NBT_TAG, tagList);
    }
}
