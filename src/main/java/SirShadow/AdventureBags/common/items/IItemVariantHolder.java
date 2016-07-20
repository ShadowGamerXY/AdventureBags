package SirShadow.AdventureBags.common.items;

import net.minecraft.client.renderer.ItemMeshDefinition;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public interface IItemVariantHolder<T extends ItemBaseAB>
{
    T getItem();

    String[] getVariants();

    ItemMeshDefinition getCustomMeshDefinition();
}
