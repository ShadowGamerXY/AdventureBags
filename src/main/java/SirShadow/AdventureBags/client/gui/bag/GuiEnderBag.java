package SirShadow.AdventureBags.client.gui.bag;

import SirShadow.AdventureBags.client.gui.GuiBase;
import SirShadow.AdventureBags.client.gui.GuiComponent;
import SirShadow.AdventureBags.client.inventory.ender.bag.ContainerEnderBag;
import SirShadow.AdventureBags.client.inventory.ender.InventoryEnderBag;
import SirShadow.AdventureBags.lib.LibMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class GuiEnderBag extends GuiBase
{

    private static final ResourceLocation texture = new ResourceLocation(LibMain.ModInfo.MOD_ID,"textures/gui/guiBasicBag.png");

    public GuiEnderBag(EntityPlayer player, InventoryEnderBag inventoryBag) {
        super("Adventure Bag", new ContainerEnderBag(player,inventoryBag), texture);
        setGuiWidth(175);
        setGuiHeight(169);
    }
}
