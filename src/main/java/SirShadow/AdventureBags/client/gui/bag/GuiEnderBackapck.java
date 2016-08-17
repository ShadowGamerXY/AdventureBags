package SirShadow.AdventureBags.client.gui.bag;

import SirShadow.AdventureBags.client.gui.GuiBase;
import SirShadow.AdventureBags.client.inventory.ender.backpack.ContainerEnderBackapck;
import SirShadow.AdventureBags.client.inventory.ender.backpack.InventoryEnderBackapck;
import SirShadow.AdventureBags.lib.LibMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class GuiEnderBackapck extends GuiBase
{

    private static final ResourceLocation texture = new ResourceLocation(LibMain.ModInfo.MOD_ID,"textures/gui/guiBasicBackpack.png");

    public GuiEnderBackapck(EntityPlayer player, InventoryEnderBackapck inventoryBag) {
        super("", new ContainerEnderBackapck(player,inventoryBag), texture);
        setGuiHeight(196);
        setGuiWidth(175);
    }
}
