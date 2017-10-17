package sirshadow.adventurebags.common.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sirshadow.adventurebags.AdventureBags;
import sirshadow.adventurebags.lib.LibMain;
import sirshadow.adventurebags.registry.RegistyManeger;

/**
 * Created by SirShadow for the mod Roots on 1.8.2016.
 */
public class BlockContainerBase extends BlockContainer {
    public TileEntity tile;

    public BlockContainerBase(String name, TileEntity tileEntity) {
        this(name, Material.ROCK);
        tile = tileEntity;
    }

    public BlockContainerBase(String name, Material material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(LibMain.ModInfo.MOD_ID + ":" + name);
        setCreativeTab(AdventureBags.tabAdventure);

        RegistyManeger.Block_Container.add(this);
    }

    @SideOnly(Side.CLIENT)
    public void initModelsAndVariants() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName().toString()));
    }


    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return tile;
    }
}
