package SirShadow.AdventureBags.client;

import SirShadow.AdventureBags.client.gui.bag.GuiEnderBag;
import SirShadow.AdventureBags.client.inventory.ender.ContainerEnderBag;
import SirShadow.AdventureBags.client.inventory.ender.InventoryEnderBag;
import net.minecraft.entity.player.EntityPlayer;
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
        }
        return null;
    }
}
