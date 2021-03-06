package sirshadow.adventurebags.client.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import sirshadow.adventurebags.api.BagBindingUtils;

import javax.annotation.Nonnull;

public class InventoryEnder implements IInventory {
    protected NonNullList<ItemStack> inventory;

    private String special_tag;

    private String NBT_ITEMS;

    public InventoryEnder(EntityPlayer player, String tag, String nbt, int size) {
        inventory = NonNullList.withSize(size, ItemStack.EMPTY);
        this.special_tag = tag;
        this.NBT_ITEMS = nbt;
        readFromNBT(BagBindingUtils.getInventoryTagOfPlayer(player, special_tag));

    }

    public void onGuiSaved(EntityPlayer entityPlayer) {
        save(entityPlayer);
    }

    public void save(EntityPlayer player) {
        NBTTagCompound tag = BagBindingUtils.getInventoryTagOfPlayer(player, special_tag);
        writeToNBT(tag);
        BagBindingUtils.setInventoryTagOfPlayer(player, special_tag, tag);
    }

    @Override
    public int getSizeInventory() {
        return inventory.size();
    }

    @Nonnull
    @Override
    public ItemStack getStackInSlot(int slotIndex) {
        return inventory.get(slotIndex);
    }

    @Nonnull
    @Override
    public ItemStack decrStackSize(int slotIndex, int decrementAmount) {
        ItemStack itemStack = getStackInSlot(slotIndex);
        if (itemStack.getCount() <= decrementAmount) {
            setInventorySlotContents(slotIndex, ItemStack.EMPTY);
        } else {
            itemStack = itemStack.splitStack(decrementAmount);
            if (itemStack.getCount() == 0) {
                setInventorySlotContents(slotIndex, ItemStack.EMPTY);
            }
        }

        return itemStack;
    }

    @Nonnull
    @Override
    public ItemStack removeStackFromSlot(int slotIndex) {
        ItemStack stack = inventory.get(slotIndex);
        inventory.remove(stack);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slotIndex, @Nonnull ItemStack itemStack) {
        this.inventory.set(slotIndex, itemStack);
    }

    @Nonnull
    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void markDirty() {
        // NOOP
    }

    @Override
    public boolean isEmpty() {
        return inventory == null;
    }

    @Override
    public boolean isUsableByPlayer(@Nonnull EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void openInventory(@Nonnull EntityPlayer player) {
        // NOOP
    }

    @Override
    public void closeInventory(@Nonnull EntityPlayer player) {
        // NOOP
    }

    @Override
    public boolean isItemValidForSlot(int slotIndex, @Nonnull ItemStack itemStack) {
        return true;
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        if (nbtTagCompound != null && nbtTagCompound.hasKey(NBT_ITEMS)) {
            // Read in the ItemStacks in the inventory from NBT
            if (nbtTagCompound.hasKey(NBT_ITEMS)) {
                NBTTagList tagList = nbtTagCompound.getTagList(NBT_ITEMS, 10);
                inventory = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
                for (int i = 0; i < tagList.tagCount(); ++i) {
                    NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
                    byte slotIndex = tagCompound.getByte("Slot");
                    if (slotIndex >= 0 && slotIndex < inventory.size()) {
                        inventory.set(slotIndex, new ItemStack(tagCompound));
                    }
                }
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound) {
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

    public static boolean hasTag(ItemStack itemStack, String keyName) {
        return itemStack != null && itemStack.getTagCompound() != null && itemStack.getTagCompound().hasKey(keyName);
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentString("");
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
}