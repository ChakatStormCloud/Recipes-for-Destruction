package StormCloud.recipesfordestruction.init;


import StormCloud.recipesfordestruction.Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeHandler {
	
	
	public static void registerOreDict() {
		OreDictionary.registerOre("nuggetIron", new ItemStack(ItemsHandler.itemMetalBits,1,0));
	}
	
	public static void registerCraftingRecipies(){
		//add regular recipes
		GameRegistry.addShapedRecipe(null, null, new ItemStack(Blocks.GRAVEL), new Object[]{"GG","GG",'G',new ItemStack(ItemsHandler.itemRubble, 1, 0)});
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.IRON_ORE), new Object[]{"GG","GG",'G',new ItemStack(ItemsHandler.itemOreChunk, 1, 0)});
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.GOLD_ORE), new Object[]{"GG","GG",'G',new ItemStack(ItemsHandler.itemOreChunk, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(ItemsHandler.itemRubble), new Object[] {"GG","GG",'G',new ItemStack(ItemsHandler.itemRubble,1,2)});
		
		//add OreDict recipes
		GameRegistry.addRecipe(new ShapedOreRecipe(Items.IRON_INGOT,"###","###","###", '#', "nuggetIron"));
		
		Utility.getLogger().info("Registered Crafting Recipies!");
	}
	
	
	public static void registerSmeltingRecipies(){
		//Input can be block, item, or itemstack, Output must be itemstack, XP is a float
		//GameRegistry.addSmelting(input, output, xp);
		GameRegistry.addSmelting(Blocks.GRAVEL, new ItemStack(Blocks.COBBLESTONE), 0f);
		GameRegistry.addSmelting(new ItemStack(ItemsHandler.itemRubble,1,2), new ItemStack(Blocks.PURPUR_BLOCK,1), 0);
		GameRegistry.addSmelting(new ItemStack(ItemsHandler.itemMetalBits,1,1),new ItemStack(ItemsHandler.itemMetalBits,1,0),0);
		GameRegistry.addSmelting(new ItemStack(ItemsHandler.itemMetalBits,1,2), new ItemStack(Items.GOLD_NUGGET), 0);
		
		Utility.getLogger().info("Registered Smelting Recipies!");
		
	}
}
