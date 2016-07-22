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
