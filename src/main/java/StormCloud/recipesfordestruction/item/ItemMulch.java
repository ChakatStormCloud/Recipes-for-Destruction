package StormCloud.recipesfordestruction.item;

import StormCloud.recipesfordestruction.RecipesForDestruction;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemMulch extends Item {
	public ItemMulch(String unlocalizedName){
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(RecipesForDestruction.MODID, unlocalizedName));
		this.setHasSubtypes(false);
		
	}
}
