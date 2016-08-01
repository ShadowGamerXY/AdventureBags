package SirShadow.AdventureBags.client;

import SirShadow.AdventureBags.client.gui.bag.GuiEnderBackapck;
import SirShadow.AdventureBags.client.gui.bag.GuiEnderBag;
import SirShadow.AdventureBags.client.gui.crate.GuiEnderCrate;
import SirShadow.AdventureBags.client.inventory.ender.bag.ContainerEnderBackapck;
import SirShadow.AdventureBags.client.inventory.ender.bag.ContainerEnderBag;
import SirShadow.AdventureBags.client.inventory.ender.InventoryEnderBackapck;
import SirShadow.AdventureBags.client.inventory.ender.InventoryEnderBag;
import SirShadow.AdventureBags.client.inventory.ender.crate.ContainerEnderCrate;
import SirShadow.AdventureBags.common.tile.TEEnderCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class GuiHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (EnumIDs.values()[ID])
        {
            case GUI_ENDER_BAG:
                return new ContainerEnderBag(player,new InventoryEnderBag(player));
            case GUI_ENDER_BACKPACK:
                return new ContainerEnderBackapck(player,new InventoryEnderBackapck(player));
            case GUI_ENDER_CRATE:
                    return new ContainerEnderCrate(player,new InventoryEnderBackapck(player));

        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (EnumIDs.values()[ID])
        {
            case GUI_ENDER_BAG:
                return new GuiEnderBag(player,new InventoryEnderBag(player));
            case GUI_ENDER_BACKPACK:
                return new GuiEnderBackapck(player,new InventoryEnderBackapck(player));
            case GUI_ENDER_CRATE:
                return new GuiEnderCrate(player,new InventoryEnderBackapck(player));

        }
        return null;
    }
}
