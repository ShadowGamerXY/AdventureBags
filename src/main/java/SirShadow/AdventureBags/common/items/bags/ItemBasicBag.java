package SirShadow.AdventureBags.common.items.bags;

import SirShadow.AdventureBags.AdventureBags;
import SirShadow.AdventureBags.client.EnumIDs;
import SirShadow.AdventureBags.common.items.ItemBaseAB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public class ItemBasicBag extends ItemBaseAB
{
    public ItemBasicBag()
    {
        super("itemBasicBag");
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {

        int x,y,z;

        x = (int)playerIn.posX;
        y = (int)playerIn.posY;
        z = (int)playerIn.posZ;


        if(!worldIn.isRemote)
        {
            playerIn.openGui(AdventureBags.instance, EnumIDs.GUI_BASIC_BAG.ordinal(),worldIn,x,y,z);
        }
        return new ActionResult(EnumActionResult.PASS, itemStackIn);
    }
}
