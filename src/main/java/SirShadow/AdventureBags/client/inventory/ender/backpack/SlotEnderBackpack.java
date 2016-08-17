package SirShadow.AdventureBags.client.inventory.ender.backpack;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by SirShadow on 17. 08. 2016.
 */
public class SlotEnderBackpack extends Slot
{
    private final EntityPlayer player;
    private ContainerEnderBackapck ContainerBasicBag;

    public SlotEnderBackpack(ContainerEnderBackapck ContainerBasicBag, IInventory inventory, EntityPlayer player, int slotIndex, int x, int y)
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

