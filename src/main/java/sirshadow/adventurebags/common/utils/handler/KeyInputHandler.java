package sirshadow.adventurebags.common.utils.handler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import sirshadow.adventurebags.AdventureBags;
import sirshadow.adventurebags.api.IBagAbility;
import sirshadow.adventurebags.client.EnumIDs;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.DimensionType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import sirshadow.adventurebags.client.inventory.other.InventoryPBS;
import sirshadow.adventurebags.common.network.PacketHandler;
import sirshadow.adventurebags.common.network.PacketUpdatePBS;

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
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event) {
        KeyBindings key = getPressedKey();
        if (key != null) {
            switch (key) {
                case PBS:
                    PacketHandler.INSTANCE.sendToServer(new PacketUpdatePBS());
            }
        }
    }
}
