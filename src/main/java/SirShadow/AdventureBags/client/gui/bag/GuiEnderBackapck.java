package SirShadow.AdventureBags.client.gui.bag;

import SirShadow.AdventureBags.client.gui.GuiBase;
import SirShadow.AdventureBags.client.inventory.ender.bag.ContainerEnderBackapck;
import SirShadow.AdventureBags.client.inventory.ender.InventoryEnderBackapck;
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
        super("", new ContainerEnderBackapck(player,inventoryBag), null);
        xSize = 175;
        ySize = 196;
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
