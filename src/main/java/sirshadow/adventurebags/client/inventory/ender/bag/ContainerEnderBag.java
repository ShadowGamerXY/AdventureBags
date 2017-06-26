package sirshadow.adventurebags.client.inventory.ender.bag;

import net.minecraft.inventory.Container;
import sirshadow.adventurebags.client.inventory.ContainerAB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
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
    public final InventoryEnderBag inventoryBasicBag;

    private Item itemFilter;

    public ContainerEnderBag(EntityPlayer player, InventoryEnderBag inventoryBasicBag) {
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
    public ItemStack transferStackInSlot(EntityPlayer p, int i)
    {
        ItemStack itemstack = ItemStack.EMPTY;
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
            if (itemstack1.getCount() == 0)
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
        return itemFilter == null || itemstack == null || itemstack.getItem() == itemFilter;
    }

    @Override
    public void saveInventory(EntityPlayer entityPlayer)
    {
        inventoryBasicBag.onGuiSaved(entityPlayer);
    }
}
