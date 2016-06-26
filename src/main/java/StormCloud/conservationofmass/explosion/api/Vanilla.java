package StormCloud.conservationofmass.explosion.api;

import StormCloud.conservationofmass.explosion.ExplosionRecipeHandler;
import StormCloud.conservationofmass.explosion.ExplosionRecipeHandler.RecipeType;
import StormCloud.conservationofmass.explosion.ExplosionDebris;

public class Vanilla {
	
	public static void addRecipes(){
		//ExplosionDebris stick = new ExplosionDebris(null, 1, 1,false);
		ExplosionRecipeHandler.addExplosionRecipe("tile.dirt",RecipeType.DROP,0);
		ExplosionRecipeHandler.addExplosionRecipe("tile.grass",RecipeType.DROP,0);
		ExplosionRecipeHandler.addExplosionRecipe("tile.stone",RecipeType.DROP,0);
		
	}
	
}
