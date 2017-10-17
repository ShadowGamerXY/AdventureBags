package sirshadow.adventurebags.common.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import sirshadow.adventurebags.common.utils.Util;

/**
 * Created by sirshadow on 6/26/17.
 */
public class PacketUpdatePBS extends MessageBase<PacketUpdatePBS>
{
    public PacketUpdatePBS(){}

    @Override
    public void handleClientSide(PacketUpdatePBS message, EntityPlayer player) {}

    @Override
    public void handleServerSide(PacketUpdatePBS message, EntityPlayer player) {
        Util.equipBag(player);
    }

    @Override
    public void fromBytes(ByteBuf buf) {}

    @Override
    public void toBytes(ByteBuf buf) {}
}
