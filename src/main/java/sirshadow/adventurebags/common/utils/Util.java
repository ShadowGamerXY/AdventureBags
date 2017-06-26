package sirshadow.adventurebags.common.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sirshadow.adventurebags.AdventureBags;
import sirshadow.adventurebags.api.IBagAbility;
import sirshadow.adventurebags.client.EnumIDs;
import sirshadow.adventurebags.client.inventory.other.InventoryPBS;

/**
 * Created by SirShadow for the mod Roots on 29.7.2016.
 */
public class Util
{
    public static void openGUI(EntityPlayer player, World world, EnumIDs iDs, boolean lock) {
        if (!world.isRemote) {
            int x, y, z;

            x = (int) player.posX;
            y = (int) player.posY;
            z = (int) player.posZ;

            if (!lock) {
                player.openGui(AdventureBags.instance, iDs.ordinal(), world, x, y, z);
            } else {

            }
        }
    }

   public static void equipBag(EntityPlayer player){
       InventoryPBS inv = new InventoryPBS(player);
       ItemStack curStack = player.inventory.getCurrentItem();
       ItemStack storedStack = inv.getStackInSlot(0);


       if (storedStack.getItem().equals(new ItemStack(Blocks.AIR).getItem())) {
           if (curStack.getItem() instanceof IBagAbility) {
               inv.setInventorySlotContents(0, curStack);
               player.inventory.deleteStack(curStack);
           }
       } else {
           player.inventory.addItemStackToInventory(storedStack);
           inv.setInventorySlotContents(0, ItemStack.EMPTY);
       }
       inv.onGuiSaved(player);
   }
}
