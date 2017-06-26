package sirshadow.adventurebags.common;

import net.minecraft.block.BlockEnderChest;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sirshadow.adventurebags.AdventureBags;
import sirshadow.adventurebags.client.EnumIDs;

/**
 * Created by sirshadow on 6/19/17.
 */
public class EventHandler {


    @SubscribeEvent
    public void onBlockRightClick(PlayerInteractEvent.RightClickBlock event){
        if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof BlockEnderChest){
            event.setCanceled(true);
            event.getEntityPlayer().openGui(AdventureBags.instance, EnumIDs.GUI_ENDER_BACKPACK.ordinal(),event.getWorld(),(int)event.getEntityPlayer().posX,(int)event.getEntityPlayer().posY,(int)event.getEntityPlayer().posZ);
        }
    }
}
