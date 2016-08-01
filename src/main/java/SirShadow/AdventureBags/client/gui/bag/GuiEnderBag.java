package SirShadow.AdventureBags.client.gui.bag;

import SirShadow.AdventureBags.client.gui.GuiBase;
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

    private static final ResourceLocation texture = new ResourceLocation(LibMain.MOD_ID,"textures/gui/guiBasicBag.png");

    public GuiEnderBag(EntityPlayer player, InventoryEnderBag inventoryBag) {
        super("Adventure Bag", new ContainerEnderBag(player,inventoryBag), null);
        xSize = 175;
        ySize = 169;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int rawMouseX, int rawMouseY) {
        super.drawGuiContainerBackgroundLayer(partialTicks, rawMouseX, rawMouseY);
        this.mc.getTextureManager().bindTexture(texture);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
