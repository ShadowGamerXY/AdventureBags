package sirshadow.adventurebags.common.utils.handler;

import sirshadow.adventurebags.AdventureBags;
import sirshadow.adventurebags.client.EnumIDs;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.DimensionType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

/**
 * Created by TeamRoots on 14.8.2016.
 */
public class KeyInputHandler
{
    private KeyBindings getPressedKey(){
        for(KeyBindings key : KeyBindings.values()) {
            if(key.isPressed()) return key;
        }
        return null;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event){
        KeyBindings key = getPressedKey();
        if(key != null) {
            switch(key){
                case QUICK_ACCESS:
                    EntityPlayer player = Minecraft.getMinecraft().player;
                    if(player.dimension == DimensionType.THE_END.getId())
                    {
                        int x, y, z;

                        x = (int) player.posX;
                        y = (int) player.posY;
                        z = (int) player.posZ;

                        player.openGui(AdventureBags.instance, EnumIDs.GUI_ENDER_BACKPACK.ordinal(), player.world, x, y, z);
                    }
            }
        }
    }
}
