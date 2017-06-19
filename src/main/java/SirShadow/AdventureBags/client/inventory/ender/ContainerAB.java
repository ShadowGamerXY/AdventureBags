package SirShadow.AdventureBags.client.inventory.ender;

import SirShadow.AdventureBags.api.IBagAbility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;

/**
 * Created by SirShadow on 16.8.2016.
 */
public abstract class ContainerAB extends Container
{
    public void addPlayerInventory(EntityPlayer player, int x, int y)
    {
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, x + j * 18, y + i * 18));
            }
        }

        for(int i = 0; i < 9; ++i) {
            if (player.inventory.getStackInSlot(i).getItem() instanceof IBagAbility) {
                this.addSlotToContainer(new Slot(player.inventory, i, x + i * 18, y + 58) {
                    @Override
                    public boolean isItemValid(ItemStack stack) {
                        return false;
                    }

                    @Override
                    public boolean canTakeStack(EntityPlayer playerIn) {
                        return false;
                    }
                });
            } else {
                addSlotToContainer(new Slot(player.inventory, i, x + i * 18, y + 58));
            }
        }
    }
}
