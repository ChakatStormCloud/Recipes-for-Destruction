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
		
		
		ExplosionRecipeHandler.addExplosionResult(Item.getItemFromBlock(Block.getBlockFromName("chest")), 6f, planks,planks,planks,planks,planks,planks,planks,planks);
		ExplosionRecipeHandler.addExplosionResult(Item.getItemFromBlock(Block.getBlockFromName("crafting_table")), 4f, planks,planks,planks,planks);
		ExplosionRecipeHandler.addExplosionResult(Item.getItemFromBlock(Block.getBlockFromName("furnace")), 9f, cobble,cobble,cobble,cobble,cobble,cobble,cobble,cobble);
		ExplosionRecipeHandler.addExplosionResult(planks, 2f, stick,stick);
		ExplosionRecipeHandler.addExplosionResult(cobble, 14f, Item.getItemFromBlock(Block.getBlockFromName("gravel")));
		
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("dirt"),RecipeType.DROP);
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("grass"),RecipeType.DROP);
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("stone"),RecipeType.BREAK);
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("chest"),RecipeType.BREAK);
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("crafting_table"),RecipeType.BREAK);
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("furnace"), RecipeType.BREAK);
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("cobblestone"), RecipeType.BREAK);
		
	}
	
}
