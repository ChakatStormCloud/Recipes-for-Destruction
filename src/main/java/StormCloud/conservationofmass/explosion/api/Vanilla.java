package StormCloud.conservationofmass.explosion.api;

import StormCloud.conservationofmass.explosion.ExplosionRecipeHandler;
import StormCloud.conservationofmass.explosion.ExplosionRecipeHandler.RecipeType;
import net.minecraft.item.Item;
import StormCloud.conservationofmass.explosion.ExplosionDebris;

public class Vanilla {
	
	public static void addRecipes(){
		ExplosionDebris stick = new ExplosionDebris(Item.getByNameOrId("minecraft:stick"),1,1,1,0);
		ExplosionDebris plank = new ExplosionDebris(Item.getByNameOrId("minecraft:plank"),1,2,2,0);
		ExplosionRecipeHandler.addExplosionRecipe("tile.dirt",RecipeType.DROP,0);
		ExplosionRecipeHandler.addExplosionRecipe("tile.grass",RecipeType.DROP,0);
		ExplosionRecipeHandler.addExplosionRecipe("tile.stone",RecipeType.DROP,0);
		ExplosionRecipeHandler.addExplosionRecipe("tile.chest",RecipeType.BREAK,16,stick,plank);
		ExplosionRecipeHandler.addExplosionRecipe("tile.workbench",RecipeType.BREAK,8,stick,plank);
		
	}
	
}
