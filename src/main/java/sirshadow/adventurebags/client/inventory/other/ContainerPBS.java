package sirshadow.adventurebags.client.inventory.other;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sirshadow.adventurebags.client.inventory.ContainerAB;
import sirshadow.adventurebags.client.inventory.ender.IBagContainer;
import sirshadow.adventurebags.client.inventory.ender.SlotBag;

/**
 * Created by sirshadow on 6/26/17.
 */
public class ContainerPBS extends ContainerAB implements IBagContainer{

    int size = 1;

    private final EntityPlayer player;
    public final InventoryPBS inventoryBasicBag;

    private Item itemFilter;

    public ContainerPBS(EntityPlayer player, InventoryPBS inventoryBasicBag) {
        this.player = player;
        this.inventoryBasicBag = inventoryBasicBag;

        int slotBagIndex = 0;
        this.addSlotToContainer(new SlotBag(this,inventoryBasicBag,player,slotBagIndex,0,0));
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
    public ItemStack transferStackInSlot(EntityPlayer p, int i) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot) inventorySlots.get(i);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (i < this.size) {
                if (!mergeItemStack(itemstack1, this.size, inventorySlots.size(), true)) {
                    return null;
                }
            } else if (!acceptsStack(itemstack1)) {
                return null;
            } else if (!mergeItemStack(itemstack1, 0, this.size, false)) {
                return null;
            }
            if (itemstack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }


    public boolean acceptsStack(ItemStack itemstack) {
        return itemFilter == null || itemstack == null || itemstack.getItem() == itemFilter;
    }

    @Override
    public void saveInventory(EntityPlayer entityPlayer) {
        inventoryBasicBag.onGuiSaved(entityPlayer);
    }
}