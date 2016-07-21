package SirShadow.AdventureBags.client.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class ContainerBasicBag extends Container {
    protected final int PLAYER_INVENTORY_ROWS = 3;
    protected final int PLAYER_INVENTORY_COLUMNS = 9;

    private final EntityPlayer player;
    public final InventoryBasicBag InventorySpellBook;

    public ContainerBasicBag(EntityPlayer player, InventoryBasicBag inventorySpellBook) {
        this.player = player;
        this.InventorySpellBook = inventorySpellBook;
        int currentSlotHeldIn = player.inventory.currentItem;

//        for (int columnIndex = 4; columnIndex < inventoryColumns; ++columnIndex)
        {
            //slot 1
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 0, 20, 11));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 1, 20, 11 + 20));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 2, 20, 11 + 40));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 3, 20, 11 + 60));

            //Slot 2
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 4, 20 + 20 + 3, 11));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 5, 20 + 20 + 3, 11 + 20));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 6, 20 + 20 + 3, 11 + 40));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 7, 20 + 20 + 3, 11 + 60));
            //Slot 3
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 8, 20 + 20 + 3 + 71, 11));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 9, 20 + 20 + 3 + 71, 11 + 20));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 10, 20 + 20 + 3 + 71, 11 + 40));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 11, 20 + 20 + 3 + 71, 11 + 60));
            //Slot 4
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 12, 20 + 20 + 98, 11));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 13, 20 + 20 + 98, 11 + 20));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 14, 20 + 20 + 98, 11 + 40));
            this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, 15, 20 + 20 + 98, 11 + 60));

        }

        for (int rowIndex = 0; rowIndex < PLAYER_INVENTORY_ROWS; ++rowIndex) {
            for (int columnIndex = 0; columnIndex < PLAYER_INVENTORY_COLUMNS; ++columnIndex) {
                this.addSlotToContainer(new Slot(player.inventory, columnIndex + rowIndex * 9 + 9, 8 + columnIndex * 18, 123 + rowIndex * 18));
            }
        }

        for (int actionBarIndex = 0; actionBarIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarIndex) {
            if (actionBarIndex == currentSlotHeldIn) {
                this.addSlotToContainer(new SlotDisabled(player.inventory, actionBarIndex, 8 + actionBarIndex * 18, 181));
            } else {
                this.addSlotToContainer(new Slot(player.inventory, actionBarIndex, 8 + actionBarIndex * 18, 181));
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        if (!player.worldObj.isRemote) {
            saveInventory(player);
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slotIndex);
        int slots = inventorySlots.size();

        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            if (slotIndex < 1) {
                if (!this.mergeItemStack(stackInSlot, 1, slots, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(stackInSlot, 0, 1, false)) {
                return null;
            }

            if (slotIndex < 1 + (PLAYER_INVENTORY_ROWS * PLAYER_INVENTORY_COLUMNS)) {
                if (!this.mergeItemStack(stackInSlot, 1 + (PLAYER_INVENTORY_ROWS * PLAYER_INVENTORY_COLUMNS), inventorySlots.size(), false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(stackInSlot, 1, 1 + (PLAYER_INVENTORY_ROWS * PLAYER_INVENTORY_COLUMNS), false)) {
                return null;
            }

            if (stackInSlot.stackSize == 0)

            {
                slotObject.putStack(null);
            } else

            {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize)

            {
                return null;
            }

            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
    }


    public void saveInventory(EntityPlayer entityPlayer)
    {
        InventorySpellBook.onGuiSaved(entityPlayer);
    }

    private class SlotSpellBook extends Slot
    {
        private final EntityPlayer player;
        private ContainerBasicBag ContainerBasicBag;

        public SlotSpellBook(ContainerBasicBag ContainerBasicBag, IInventory inventory, EntityPlayer player, int slotIndex, int x, int y)
        {
            super(inventory, slotIndex, x, y);
            this.player = player;
            this.ContainerBasicBag = ContainerBasicBag;
        }

        @Override
        public void onSlotChanged()
        {
            super.onSlotChanged();

            if (FMLCommonHandler.instance().getEffectiveSide().isServer())
            {
                ContainerBasicBag.saveInventory(player);
            }
        }

        @Override
        public boolean isItemValid(ItemStack itemStack)
        {
            return true;
        }
    }

    private class SlotDisabled extends Slot
    {
        public SlotDisabled(IInventory inventory, int slotIndex, int x, int y)
        {
            super(inventory, slotIndex, x, y);
        }

        @Override
        public boolean isItemValid(ItemStack itemStack)
        {
            return false;
        }

        @Override
        public boolean canTakeStack(EntityPlayer player)
        {
            return false;
        }
    }
}
