package sirshadow.adventurebags.client.inventory.ender.bag;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sirshadow.adventurebags.client.inventory.ContainerAB;
import sirshadow.adventurebags.client.inventory.InventoryEnder;
import sirshadow.adventurebags.client.inventory.ender.IBagContainer;
import sirshadow.adventurebags.client.inventory.ender.SlotBag;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class ContainerEnderBag extends ContainerAB implements IBagContainer{
    protected final int BAG_INVENTORY_ROWS = 6;
    protected final int BAG_INVENTORY_COLUMNS = 3;

    int size = BAG_INVENTORY_COLUMNS * BAG_INVENTORY_ROWS;

    private final EntityPlayer player;
    public final InventoryEnder inventoryBasicBag;

    private Item itemFilter;

    public ContainerEnderBag(EntityPlayer player, InventoryEnder inventoryBasicBag) {
        this.player = player;
        this.inventoryBasicBag = inventoryBasicBag;

        int slotBagIndex = 0;
        for (int i = 0; i < BAG_INVENTORY_ROWS; i++)
            for (int k = 0; k < BAG_INVENTORY_COLUMNS; k++) {
                this.addSlotToContainer(new SlotBag(this, inventoryBasicBag, player, slotBagIndex++, 31 + i * 18, 16 + k * 18));
            }

        addPlayerInventory(player,8,88);
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

        if (!player.world.isRemote) {
            saveInventory(player);
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.size)
            {
                if (!this.mergeItemStack(itemstack1, this.size, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.acceptsStack(itemstack1))
            {
                return ItemStack.EMPTY;
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.size, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
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
        return true;
    }

    @Override
    public void saveInventory(EntityPlayer entityPlayer)
    {
        inventoryBasicBag.onGuiSaved(entityPlayer);
    }
}
