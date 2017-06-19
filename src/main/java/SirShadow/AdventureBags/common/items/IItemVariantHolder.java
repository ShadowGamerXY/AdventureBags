package SirShadow.AdventureBags.common.items;

import net.minecraft.client.renderer.ItemMeshDefinition;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public interface IItemVariantHolder<T extends ItemBase>
{
    T getItem();

    String[] getVariants();

    ItemMeshDefinition getCustomMeshDefinition();
}
