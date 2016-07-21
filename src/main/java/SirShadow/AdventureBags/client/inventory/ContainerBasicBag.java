package SirShadow.AdventureBags.client.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class ContainerBasicBag extends Container {
    protected final int PLAYER_INVENTORY_ROWS = 3;
    protected final int PLAYER_INVENTORY_COLUMNS = 9;

    protected final int BAG_INVENTORY_ROWS = 5;
    protected final int BAG_INVENTORY_COLUMNS = 5;

    private final EntityPlayer player;
    public final InventoryBasicBag InventorySpellBook;

    public ContainerBasicBag(EntityPlayer player, InventoryBasicBag inventorySpellBook) {
        this.player = player;
        this.InventorySpellBook = inventorySpellBook;
        int currentSlotHeldIn = player.inventory.currentItem;

        int slotBagIndex = 0;

        for (int i = 0; i < BAG_INVENTORY_ROWS; i++)
            for (int k = 0; k < BAG_INVENTORY_COLUMNS; k++) {
                this.addSlotToContainer(new SlotSpellBook(this, inventorySpellBook, player, slotBagIndex++, i * 20 + 15, k * 18 + 15));
            }

        for (int rowIndex = 0; rowIndex < PLAYER_INVENTORY_ROWS; ++rowIndex)
        {
            for (int columnIndex = 0; columnIndex < PLAYER_INVENTORY_COLUMNS; ++columnIndex)
            {
                this.addSlotToContainer(new Slot(player.inventory, columnIndex + rowIndex * 9 + 9, 8 + columnIndex * 18, 140 + rowIndex * 18));
            }
        }

        for (int actionBarIndex = 0; actionBarIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarIndex)
        {
            this.addSlotToContainer(new Slot(player.inventory, actionBarIndex, 8 + actionBarIndex * 18, 198));
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
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
    {
        //StillWorking on it
        return null;
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
