package sirshadow.adventurebags.client.gui.bag;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import sirshadow.adventurebags.client.inventory.ender.bag.ContainerEnderBag;
import sirshadow.adventurebags.client.inventory.ender.bag.InventoryEnderBag;
import sirshadow.adventurebags.lib.LibMain;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class GuiEnderBag extends GuiContainer
{

    private static final ResourceLocation texture = new ResourceLocation(LibMain.ModInfo.MOD_ID,"textures/gui/guibasicbag.png");

    public GuiEnderBag(EntityPlayer player, InventoryEnderBag inventoryBag) {
        super(new ContainerEnderBag(player,inventoryBag));
        xSize = (176);
        ySize = (170);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        mc.renderEngine.bindTexture(texture);
        int xStart = (width  - 176) / 2;
        int yStart = (height - 170) / 2;
        drawTexturedModalRect(xStart,yStart,0,0,xSize,ySize);
    }
}
