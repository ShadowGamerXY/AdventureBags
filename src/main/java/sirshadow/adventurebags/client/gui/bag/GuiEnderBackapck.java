package sirshadow.adventurebags.client.gui.bag;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import sirshadow.adventurebags.client.inventory.ender.backpack.ContainerEnderBackapck;
import sirshadow.adventurebags.client.inventory.ender.backpack.InventoryEnderBackapck;
import sirshadow.adventurebags.lib.ModLibrary;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class GuiEnderBackapck extends GuiContainer
{

    private static final ResourceLocation texture = new ResourceLocation(ModLibrary.ModInfo.MOD_ID,"textures/gui/guibasicbackpack.png");

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
