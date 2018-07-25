package sirshadow.adventurebags.client.inventory.ender.backpack;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sirshadow.adventurebags.client.inventory.ContainerAB;
import sirshadow.adventurebags.client.inventory.ender.IBagContainer;
import sirshadow.adventurebags.client.inventory.ender.SlotBag;

import javax.annotation.Nonnull;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class ContainerEnderBackapck extends ContainerAB implements IBagContainer{
    private  static int BAG_INVENTORY_ROWS = 9;
    private  static int BAG_INVENTORY_COLUMNS = 5;

    private static int size = BAG_INVENTORY_COLUMNS * BAG_INVENTORY_ROWS;

    private final EntityPlayer player;
    private final InventoryEnderBackapck inventoryEnderBackpack;

    private Item itemFilter;

    public ContainerEnderBackapck(EntityPlayer player, InventoryEnderBackapck inventoryBasicBag) {
        this.player = player;
        this.inventoryEnderBackpack = inventoryBasicBag;

        int slotID = 0;

        for (int i = 0; i < BAG_INVENTORY_ROWS; i++)
            for (int k = 0; k < BAG_INVENTORY_COLUMNS; k++) {
                    this.addSlotToContainer(new SlotBag(this, inventoryBasicBag, player, slotID++, 7 + i * 18, 7 + k * 18));
        }

        addPlayerInventory(player,8,115);
    }

    @Override
    public boolean canInteractWith(@Nonnull EntityPlayer player)
    {
        return true;
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        if (!entityPlayer.world.isRemote) {
            saveInventory(entityPlayer);
        }
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        if (!player.world.isRemote) {
            saveInventory(player);
        }
    }

    @Nonnull
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
        inventoryEnderBackpack.onGuiSaved(entityPlayer);
    }

    public static int getSize() {
        return size;
    }

    public InventoryEnderBackapck getInventoryEnderBackPack() {
        return inventoryEnderBackpack;
    }
}
