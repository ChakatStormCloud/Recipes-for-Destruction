package StormCloud.recipesfordestruction.item;

import StormCloud.recipesfordestruction.MainLib;
import StormCloud.recipesfordestruction.item.Enums.MetalDebrisTypes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class ItemMetalBits extends Item {
	public ItemMetalBits(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MainLib.MODID,unlocalizedName));
		this.setHasSubtypes(true);
	}
	
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		for(int i = 0; i < MetalDebrisTypes.values().length;i++){
			items.add(new  ItemStack(this,1,i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "." + MetalDebrisTypes.values()[stack.getItemDamage()].getName();
	}
}
