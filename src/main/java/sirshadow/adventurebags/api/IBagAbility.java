package sirshadow.adventurebags.api;

import net.minecraft.item.ItemStack;

/**
 * Created by SirShadow for the mod Roots on 22.7.2016.
 */
public interface IBagAbility
{
    void setLockState(ItemStack stack);

    void getLockState(ItemStack stack);
}
