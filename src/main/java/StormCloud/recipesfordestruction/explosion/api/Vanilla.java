package StormCloud.recipesfordestruction.explosion.api;

import StormCloud.recipesfordestruction.explosion.ExplosionRecipeHandler;
import StormCloud.recipesfordestruction.explosion.ExplosionRecipeHandler.RecipeType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Vanilla {
	
	public static void addRecipes(){
		System.out.println("Trying to add recipes");
		Item planks = Item.getItemFromBlock(Block.getBlockFromName("planks")); 
		Item stick = Item.getByNameOrId("stick");
		Item cobble = Item.getItemFromBlock(Block.getBlockFromName("cobblestone"));
		
		
		addDebris(Item.getItemFromBlock(Block.getBlockFromName("chest")), 6f, planks,planks,planks,planks,planks,planks,planks,planks);
		addDebris(Item.getItemFromBlock(Block.getBlockFromName("crafting_table")), 4f, planks,planks,planks,planks);
		addDebris(Item.getItemFromBlock(Block.getBlockFromName("furnace")), 9f, cobble,cobble,cobble,cobble,cobble,cobble,cobble,cobble);
		addDebris(planks, 2f, stick,stick);
		addDebris(cobble, 14f, Item.getItemFromBlock(Block.getBlockFromName("gravel")));
		
		addRecipe(Block.getBlockFromName("dirt"),RecipeType.DROP);
		addRecipe(Block.getBlockFromName("grass"),RecipeType.DROP);
		addRecipe(Block.getBlockFromName("stone"),RecipeType.BREAK);
		addRecipe(Block.getBlockFromName("chest"),RecipeType.BREAK);
		addRecipe(Block.getBlockFromName("crafting_table"),RecipeType.BREAK);
		addRecipe(Block.getBlockFromName("furnace"), RecipeType.BREAK);
		addRecipe(Block.getBlockFromName("cobblestone"), RecipeType.BREAK);
		
	}
	//maybe 
	private static void addRecipe(Block b, RecipeType r){
		ExplosionRecipeHandler.handleBlockExplosion(b,r);
	}
	private static void addDebris(Item i, float f, Item... items ){
		ExplosionRecipeHandler.addExplosionResult(i,f,items);
	}
	
	
}
