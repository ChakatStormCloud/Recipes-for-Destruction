package StormCloud.conservationofmass.explosion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ExplosionRecipeHandler {
	
	public static enum RecipeType{DROP,BREAK,ORE,UNHANDLED};
	
	private class ExplosionRecipeDescription{
		public final RecipeType type;
		
		public ExplosionRecipeDescription(RecipeType t, int m){
			this.type = t;
		}
	}
	
	private static Multimap<String,ExplosionDebris> explosionRecipeMap;
	private static HashMap<String,ExplosionRecipeDescription> explosionBlockDescriptionMap;
	private static ExplosionRecipeHandler handler;
	
	
	public ExplosionRecipeHandler(){
		explosionRecipeMap = ArrayListMultimap.create();
		explosionBlockDescriptionMap = new HashMap<String,ExplosionRecipeDescription>();
		ExplosionRecipeHandler.handler = this;
	}

/*	public static Boolean isBlockHandled(String string){
		return(getBlockExplosionRecipeType(string) != RecipeType.UNHANDLED);
	}*/
	/**
	 * For checking the specific type of a recipe, or if it's handled at all.
	 *@param Block.getUnlocalizedName()
	 *@return 0; Unhandled, default to vanilla
	 *@return 1; Drop normally with 100% chance, for things like dirt, stone, bricks, etc.
	 *@return 2; Drop advanced with a chance of smashing into debris
	**/	
	public static RecipeType getBlockExplosionRecipeType(String string){
		if (explosionBlockDescriptionMap.containsKey(string)){
			return explosionBlockDescriptionMap.get(string).type;
			
		}
		return RecipeType.UNHANDLED;
	}
	
/*	public static int getBlockExplosionMass(String string){
		if(explosionBlockDescriptionMap.containsKey(string)){
			return explosionBlockDescriptionMap.get(string).mass;
		}
		return 0;
	}*/
	
	/**
	 * 
	 * @param block.getUnlocalizedName()
	 * @param resultList
	 * @return true if successful, false if it found a recipe already.
	 */
	public static void addExplosionRecipe(String unlocalizedName,RecipeType recipeType,int mass,ExplosionDebris... debris){
		//check if there's already a recipe
		if(explosionBlockDescriptionMap.containsKey(unlocalizedName)){
			//tell somebody
			System.out.println("Explosion Recipe for " + unlocalizedName + " already exits!");
		}else{
			//normal behaviour
			explosionBlockDescriptionMap.put(unlocalizedName, handler.new ExplosionRecipeDescription(recipeType,mass));
			
			for(ExplosionDebris newDebris : debris){
				explosionRecipeMap.put(unlocalizedName, newDebris);
			}
			//we did it!! wooo
			System.out.println("Explosion Recipe for " + unlocalizedName +" added successfully.");
		}
	}
	
/*	public static Collection<ExplosionDebris> getBlockDebris(String blockUnlocalizedName){
		return explosionRecipeMap.get(blockUnlocalizedName);
	}*/
	
	public static Collection<Item> getExplosionRecipeItems(){
		Collection<Item> recipeItems = new ArrayList<Item>();
		// TODO method stub
		
		
		
		
		
		return recipeItems;
	}
	
	public static boolean getItemBreakable(){
		// TODO method stub
		
		return false;
	}
	public static ItemStack getItemBreakDownItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
