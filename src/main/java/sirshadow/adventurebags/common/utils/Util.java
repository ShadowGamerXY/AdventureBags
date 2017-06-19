package sirshadow.adventurebags.common.utils;

import sirshadow.adventurebags.AdventureBags;
import sirshadow.adventurebags.client.EnumIDs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

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

    /*public static void dropItems(World world, int x, int y, int z) {
        Random rand = new Random();
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        if (!(tileEntity instanceof IInventory)) {
            return;
        }

        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack item = inventory.getStackInSlot(i);

            if (item != null && item.getCount() > 0) {
                float rx = rand.nextFloat() * 0.8F + 0.1F;
                float ry = rand.nextFloat() * 0.8F + 0.1F;
                float rz = rand.nextFloat() * 0.8F + 0.1F;
                EntityItem entityItem = new EntityItem(world,
                        x + rx, y + ry, z + rz,
                        new ItemStack(item.getItem(), item.getCount(), item.getItemDamage()));

                if (item.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntity(entityItem);
                item.setCount(0);
            }
        }
    }*/
}
