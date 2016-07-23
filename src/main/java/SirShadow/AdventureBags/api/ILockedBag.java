package SirShadow.AdventureBags.api;

import net.minecraft.item.ItemStack;

/**
 * Created by SirShadow for the mod Roots on 22.7.2016.
 */
public interface ILockedBag
{
    void setLockState(ItemStack stack);

    void getLockState(ItemStack stack);
}
