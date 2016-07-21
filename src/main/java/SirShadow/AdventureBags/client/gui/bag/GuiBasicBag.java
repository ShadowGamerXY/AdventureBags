package SirShadow.AdventureBags.client.gui.bag;

import SirShadow.AdventureBags.client.gui.GuiBase;
import SirShadow.AdventureBags.client.inventory.ContainerBasicBag;
import SirShadow.AdventureBags.client.inventory.InventoryBasicBag;
import SirShadow.AdventureBags.lib.LibMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class GuiBasicBag extends GuiBase
{

    private static final ResourceLocation texture = new ResourceLocation(LibMain.MOD_ID,"textures/gui/guiBasicBag.png");

    public GuiBasicBag(EntityPlayer player, InventoryBasicBag inventoryBag) {
        super("Adventure Bag", new ContainerBasicBag(player,inventoryBag), texture);
    }
}
