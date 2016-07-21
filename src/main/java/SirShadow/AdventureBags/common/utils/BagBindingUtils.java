package SirShadow.AdventureBags.common.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class BagBindingUtils
{

    public static String IDTag = "[AdventureBags]";

    public static NBTTagCompound getPersistentDataTag(EntityPlayer player)
    {
        NBTTagCompound forgeData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
        NBTTagCompound bagData = forgeData.getCompoundTag("bagData");

        //Creates/sets the tags if they don't exist
        if (!forgeData.hasKey("bagData")) forgeData.setTag("bagData", bagData);
        if (!player.getEntityData().hasKey(EntityPlayer.PERSISTED_NBT_TAG)) player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, forgeData);

        return bagData;
    }


    public static NBTTagCompound getInventoryTagOfPlayer(EntityPlayer player)
    {
        NBTTagCompound data = BagBindingUtils.getPersistentDataTag(player);
        if(data.hasKey(IDTag + "BagInventory"))
        {
            return data.getCompoundTag(IDTag + "BagInventory");
        }

        return new NBTTagCompound();
    }

    public static void setInventoryTagOfPlayer(EntityPlayer player, NBTTagCompound tag)
    {
        NBTTagCompound data = BagBindingUtils.getPersistentDataTag(player);
        data.setTag(IDTag + "BagInventory", tag);
    }
}
