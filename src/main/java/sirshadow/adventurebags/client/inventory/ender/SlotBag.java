package sirshadow.adventurebags.client.inventory.ender;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by sirshadow on 6/26/17.
 */
public class SlotBag extends Slot{

    private final EntityPlayer player;

    IBagContainer container;

    public SlotBag(IBagContainer container, IInventory inventory, EntityPlayer player, int slotIndex, int x, int y)
    {
        super(inventory, slotIndex, x, y);
        this.player = player;
        this.container = container;
    }
    @Override
    public void onSlotChanged(){
        super.onSlotChanged();
        if(FMLCommonHandler.instance().getEffectiveSide().isServer())
        {
            container.saveInventory(player);
        }
    }
    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        return true;
    }
}
