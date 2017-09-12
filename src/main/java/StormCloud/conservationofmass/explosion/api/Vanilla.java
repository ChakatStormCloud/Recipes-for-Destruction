package StormCloud.conservationofmass.explosion.api;

import StormCloud.conservationofmass.explosion.ExplosionRecipeHandler;
import StormCloud.conservationofmass.explosion.ExplosionRecipeHandler.RecipeType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Vanilla {
	
	public static void addRecipes(){
		System.out.println("Trying to add recipes");
		Item planks = Item.getItemFromBlock(Block.getBlockFromName("planks")); 
		Item stick = Item.getByNameOrId("stick");
		
		ExplosionRecipeHandler.addExplosionResult(Item.getItemFromBlock(Block.getBlockFromName("chest")), 6f, planks,planks,planks,planks,planks,planks,planks,planks);
		ExplosionRecipeHandler.addExplosionResult(Item.getItemFromBlock(Block.getBlockFromName("crafting_table")), 4f, planks,planks,planks,planks);
		
		ExplosionRecipeHandler.addExplosionResult(planks, 2f, stick,stick);
		ExplosionRecipeHandler.addExplosionResult(Item.getItemFromBlock(Block.getBlockFromName("cobble")), 16, Item.getItemFromBlock(Block.getBlockFromName("gravel")));
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("dirt"),RecipeType.DROP);
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("grass"),RecipeType.DROP);
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("stone"),RecipeType.BREAK);
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("chest"),RecipeType.BREAK);
		ExplosionRecipeHandler.handleBlockExplosion(Block.getBlockFromName("crafting_table"),RecipeType.BREAK);
		
	}
	
}
