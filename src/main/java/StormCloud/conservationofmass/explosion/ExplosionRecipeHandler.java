package StormCloud.conservationofmass.explosion;


import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;


public class ExplosionRecipeHandler {
	
	public static enum RecipeType{DROP,BREAK,UNHANDLED};
	
	
	public static class Debris{
		public final float resistance;
		public final Item[] result;
		public Debris(float c, Item[] r) {
			this.resistance = c;
			this.result = r;
		}
	}
	

	private static HashMap<Item,Debris> explosionDebrisMap;
	private static HashMap<Block,RecipeType> explosionRecipeMap2;
	
	
	public static void init(){
		explosionDebrisMap = new HashMap<Item,Debris>();
		explosionRecipeMap2 = new HashMap<Block,RecipeType>();
	}
	
	/**
	 * Adds a block to the handling, and tells how to treat it when it get's blown up
	 * 
	 * @param Block
	 * @param RecipeType; How to handle the block when it's blown up
	 * 		DROP: just drop it, use for things like dirt
	 * 		BREAK; BETTER: drop pieces or broken parts
	 * 		UNHANDLED; Use vanilla mechanics
	 */
	public static void handleBlockExplosion(Block block, RecipeType type) {
		//null check
		if (block==null) {System.out.println("Can't Add Block! Block Null!");return;}
		//check if there's already a recipe
		if(explosionRecipeMap2.containsKey(block)) {
			System.out.println("Explosion Handler Recipe for "+block.getUnlocalizedName()+" already exists!");
		}else {
			//normal behaviour
			explosionRecipeMap2.put(block, type);
			System.out.println("Explosion Handler Recipe for "+block.getUnlocalizedName()+" successfully added!");
		}
		
	}
	
	/**
	 * Adds the Result for an item, which is used when something is blown up with advanced handling
	 * It will go down the results recursively up to a limit based on the distance from epicenter,
	 * strength of the explosion, and explosion resistance you set here.
	 * 
	 * @param item; inital item or itemblock 
	 * @param resistance; explosion resistance, for itemblocks, suggest using regular explosion resistance 
	 * @param result[]; collection of items, that this item will break into, don't use too many.
	 */
	public static void addExplosionResult(Item item, float resistance, Item... result) {
		//null check
		if (item==null) {System.out.println("Can't Add Item! Item Null!");return;}
		//check if there's already a recipe
		if(explosionDebrisMap.containsKey(item)){//tell somebody
			System.out.println("Explosion Debris Recipe for " + item.getUnlocalizedName() + " already exists!");
		}else{
			//normal behaviour
			explosionDebrisMap.put(item, new Debris(resistance, result));
			//we did it!! wooo
			System.out.println("Explosion Debris Recipe for " + item.getUnlocalizedName() +" added successfully.");
		}
		
	}
	/**
	 * Returns the Recipe type, or UNHANDLED if none found
	 * (a block may also be registered as UNHANDLED to enforce vanilla handling)
	 */
	public static RecipeType getHandledType(Block block) {
		if(explosionRecipeMap2.containsKey(block)) {
			return explosionRecipeMap2.get(block);
		}else {
			return RecipeType.UNHANDLED;
		}
	}
	
	public static Debris getDebris(Item item) {
		if(explosionDebrisMap.containsKey(item)) {
			return explosionDebrisMap.get(item);
		}
		
		return null;
	}
	
}
