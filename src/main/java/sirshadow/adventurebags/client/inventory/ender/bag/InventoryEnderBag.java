package sirshadow.adventurebags.client.inventory.ender.bag;

import net.minecraft.entity.player.EntityPlayer;
import sirshadow.adventurebags.client.inventory.InventoryEnder;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class InventoryEnderBag extends InventoryEnder {
    public InventoryEnderBag(EntityPlayer player) {
        super(player, "bag_tag", "satchel_items", 18);
    }
}