package SirShadow.AdventureBags.client.inventory.ender.bag;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by SirShadow on 16.8.2016.
 */
public class SlotEnderBag extends Slot
{
    private final EntityPlayer player;


    private ContainerEnderBag containerEnderBackapck;
    private Container container;

    public SlotEnderBag(ContainerEnderBag container, IInventory inventory, EntityPlayer player, int slotIndex, int x, int y)
    {
        super(inventory, slotIndex, x, y);
        this.player = player;
        this.container = container;
    }

    @Override
    public void onSlotChanged() {
        super.onSlotChanged();
        if(FMLCommonHandler.instance().getEffectiveSide().isServer())
        {
            containerEnderBackapck.saveInventory(player);
        }
    }
    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        return true;
    }
}
