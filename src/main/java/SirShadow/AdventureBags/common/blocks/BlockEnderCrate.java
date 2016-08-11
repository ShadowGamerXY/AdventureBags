package SirShadow.AdventureBags.common.blocks;

import SirShadow.AdventureBags.client.EnumIDs;
import SirShadow.AdventureBags.common.tile.TEEnderCrate;
import SirShadow.AdventureBags.common.utils.Util;
import SirShadow.AdventureBags.common.utils.handler.ConfigurationHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by SirShadow for the mod Roots on 1.8.2016.
 */
public class BlockEnderCrate extends BlockContainerBase {
    public BlockEnderCrate() {
        super("blockEnderCrate", new TEEnderCrate());
    }


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            if (!ConfigurationHandler.dimension_Lock) {
                Util.openGUI(playerIn, worldIn, EnumIDs.GUI_ENDER_CRATE, false);
                return true;
            } else {
                if (playerIn.dimension == DimensionType.OVERWORLD.getId()) {
                    Util.openGUI(playerIn, worldIn, EnumIDs.GUI_ENDER_CRATE, false);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        Util.dropItems(world, pos.getX(), pos.getY(), pos.getZ());
        super.breakBlock(world, pos, state);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
