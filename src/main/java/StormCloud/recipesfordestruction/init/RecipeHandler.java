package StormCloud.recipesfordestruction.init;


import StormCloud.recipesfordestruction.Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {

	public static void registerCraftingRecipies(){
	
		Utility.getLogger().info("Registered Crafting Recipies!");
	}
	
	
	public static void registerSmeltingRecipies(){
		//Input can be block, item, or itemstack, Output must be itemstack, XP is a float
		//GameRegistry.addSmelting(input, output, xp);
		GameRegistry.addSmelting(new ItemStack(ItemsHandler.itemMetalBits,1,1),new ItemStack(ItemsHandler.itemMetalBits,1,0),0);
		GameRegistry.addSmelting(new ItemStack(ItemsHandler.itemMetalBits,1,2), new ItemStack(Items.GOLD_NUGGET), 0);
		GameRegistry.addSmelting(new ItemStack(ItemsHandler.itemOreChunk,4,0), new ItemStack(Items.IRON_INGOT,1), 0);//add actuall XP from iron
		GameRegistry.addSmelting(new ItemStack(ItemsHandler.itemOreChunk,4,1), new ItemStack(Items.GOLD_INGOT,1), 0);//add actuall XP from gold
		
		Utility.getLogger().info("Registered Smelting Recipies!");
	}
}
