package StormCloud.recipesfordestruction.item;

import java.util.List;

import StormCloud.recipesfordestruction.MainLib;
import StormCloud.recipesfordestruction.item.Enums.RubbleTypes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemRubble extends Item {
	public ItemRubble(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MainLib.MODID,unlocalizedName));
		this.setHasSubtypes(true);
	}
	
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		for(int i = 0; i < RubbleTypes.values().length;i++){
			subItems.add(new  ItemStack(itemIn,1,i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		/*if(stack.getItemDamage() < MetalDebrisTypes.values().length){
			return this.getUnlocalizedName() + "." + MetalDebrisTypes.values()[stack.getItemDamage()].getName();
		}else{
			return this.getUnlocalizedName() + "." + MetalDebrisTypes.BROKEN.getName();
		}*/
		return RubbleTypes.values()[stack.getItemDamage()].getName();
	}
}
