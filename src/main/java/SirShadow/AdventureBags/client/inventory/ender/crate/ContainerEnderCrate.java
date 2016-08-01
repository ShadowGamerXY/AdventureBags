package SirShadow.AdventureBags.client.inventory.ender.crate;

import SirShadow.AdventureBags.client.inventory.ender.InventoryEnderBackapck;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by SirShadow for the mod Roots on 1.8.2016.
 */
public class ContainerEnderCrate extends Container
    {
        protected final int PLAYER_INVENTORY_ROWS = 3;
        protected final int PLAYER_INVENTORY_COLUMNS = 9;

        protected final int BAG_INVENTORY_ROWS = 9;
        protected final int BAG_INVENTORY_COLUMNS = 5;

        int size = BAG_INVENTORY_COLUMNS * BAG_INVENTORY_ROWS;

        private final EntityPlayer player;
        public final InventoryEnderBackapck inventoryBasicBag;

        private Item itemFilter;

    public ContainerEnderCrate(EntityPlayer player, InventoryEnderBackapck inventoryBasicBag) {
        this.player = player;
        this.inventoryBasicBag = inventoryBasicBag;

        int slotBagIndex = 0;

        for (int i = 0; i < BAG_INVENTORY_ROWS; i++)
            for (int k = 0; k < BAG_INVENTORY_COLUMNS; k++) {
                this.addSlotToContainer(new ContainerEnderCrate.SlotBagEnder(this, inventoryBasicBag, player, slotBagIndex++, 7 + i * 18, 7 + k * 18));
            }

        for (int rowIndex = 0; rowIndex < PLAYER_INVENTORY_ROWS; ++rowIndex)
        {
            for (int columnIndex = 0; columnIndex < PLAYER_INVENTORY_COLUMNS; ++columnIndex)
            {
                this.addSlotToContainer(new Slot(player.inventory, columnIndex + rowIndex * 9 + 9, 8 + columnIndex * 18, 115 + rowIndex * 18));
            }
        }

        for (int actionBarIndex = 0; actionBarIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarIndex)
        {
            this.addSlotToContainer(new Slot(player.inventory, actionBarIndex, 8 + actionBarIndex * 18, 173));
        }
    }

        @Override
        public boolean canInteractWith(EntityPlayer entityPlayer)
        {
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
        public ItemStack transferStackInSlot(EntityPlayer p, int i)
        {
            ItemStack itemstack = null;
            Slot slot = (Slot) inventorySlots.get(i);
            if (slot != null && slot.getHasStack())
            {
                ItemStack itemstack1 = slot.getStack();
                itemstack = itemstack1.copy();
                if (i < this.size)
                {
                    if (!mergeItemStack(itemstack1, this.size, inventorySlots.size(), true))
                    {
                        return null;
                    }
                }
                else if (!acceptsStack(itemstack1))
                {
                    return null;
                }
                else if (!mergeItemStack(itemstack1, 0, this.size, false))
                {
                    return null;
                }
                if (itemstack1.stackSize == 0)
                {
                    slot.putStack(null);
                }
                else
                {
                    slot.onSlotChanged();
                }
            }
            return itemstack;
        }


    public boolean acceptsStack(ItemStack itemstack)
    {
        return itemFilter == null || itemstack == null || itemstack.getItem() == itemFilter;
    }

    public void saveInventory(EntityPlayer entityPlayer)
    {
        inventoryBasicBag.onGuiSaved(entityPlayer);
    }
    private class SlotBagEnder extends Slot
    {
        private final EntityPlayer player;
        private ContainerEnderCrate ContainerBasicBag;

        public SlotBagEnder(ContainerEnderCrate ContainerBasicBag, IInventory inventory, EntityPlayer player, int slotIndex, int x, int y)
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
}