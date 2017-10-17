package StormCloud.recipesfordestruction.item;

import StormCloud.recipesfordestruction.RecipesForDestruction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemDye;

public class ItemMulch extends Item {
	public ItemMulch(String unlocalizedName){
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(RecipesForDestruction.MODID, unlocalizedName));
		this.setHasSubtypes(false);
		
	}
	
	
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack)){
			return EnumActionResult.FAIL;
		}else{
			if (ItemDye.applyBonemeal(stack, worldIn, pos, playerIn)){
				if (!worldIn.isRemote){
					worldIn.playEvent(2005, pos, 0);
				}
				return EnumActionResult.SUCCESS;
			}
			
			return EnumActionResult.PASS;
		}
	}
}