package SirShadow.AdventureBags.client.gui.bag;

import SirShadow.AdventureBags.client.inventory.ender.backpack.ContainerEnderBackapck;
import SirShadow.AdventureBags.client.inventory.ender.backpack.InventoryEnderBackapck;
import SirShadow.AdventureBags.lib.LibMain;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class GuiEnderBackapck extends GuiContainer
{

    private static final ResourceLocation texture = new ResourceLocation(LibMain.ModInfo.MOD_ID,"textures/gui/guibasicbackpack.png");

    public GuiEnderBackapck(EntityPlayer player, InventoryEnderBackapck inventoryBag) {
        super(new ContainerEnderBackapck(player,inventoryBag));
        xSize = 176;
        ySize = 197;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        mc.renderEngine.bindTexture(texture);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
