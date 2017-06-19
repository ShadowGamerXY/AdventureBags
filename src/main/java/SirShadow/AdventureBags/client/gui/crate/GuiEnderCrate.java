package SirShadow.AdventureBags.client.gui.crate;

import SirShadow.AdventureBags.client.inventory.ender.backpack.InventoryEnderBackapck;
import SirShadow.AdventureBags.client.inventory.ender.crate.ContainerEnderCrate;
import SirShadow.AdventureBags.lib.LibMain;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by SirShadow for the mod Roots on 1.8.2016.
 */
public class GuiEnderCrate extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation(LibMain.ModInfo.MOD_ID,"textures/gui/guibasicbackpack.png");

    public GuiEnderCrate(EntityPlayer player, InventoryEnderBackapck inventoryBag) {
        super(new ContainerEnderCrate(player,inventoryBag));
        xSize = 176;
        ySize = 197;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int rawMouseX, int rawMouseY) {
        this.mc.getTextureManager().bindTexture(texture);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
