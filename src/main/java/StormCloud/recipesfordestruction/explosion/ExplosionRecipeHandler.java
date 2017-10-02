package StormCloud.recipesfordestruction.explosion;


import java.util.HashMap;

import StormCloud.recipesfordestruction.Utility;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ExplosionRecipeHandler {
	
	public static enum RecipeType{DROP,BREAK,UNHANDLED};
	
	
	public static class Debris{
		private final int[][] metas;
		public final float resistance;
		private final ItemStack[][] result;
		public Debris(float c, int[][] i,ItemStack[]... r) {
			this.resistance = c;
			this.result = r;
			this.metas = i;
			
		}
		public Debris(float c, ItemStack... r) {
			this(c, null,r);
		}
		
		public ItemStack[] getResults(ItemStack stack) {
			if (metas == null) {
				return result[0];
			}else{
				int m = stack.getMetadata();
				for(int i = 0; i < metas.length;i++) {
					for(int j=0;j<metas[i].length;j++) {
						if (metas[i][j]==m) {
							return result[i];
						}
					}
				}
			}
			System.out.println("Unknown meta, returning default");
			return result[0];
			
			
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
		if (block==null) {Utility.getLogger().error("Can't Add Block! Block Null!");return;}
		//check if there's already a recipe
		if(explosionRecipeMap2.containsKey(block)) {
			Utility.getLogger().warn("Explosion Handler Recipe for "+block.getUnlocalizedName()+" already exists!");
		}else {
			//normal behaviour
			explosionRecipeMap2.put(block, type);
			Utility.getLogger().info("Explosion Handler Recipe for "+block.getUnlocalizedName()+" successfully added!");
		}
		
	}
	
	/**
	 * Adds the Result for an item, which is used when something is blown up with advanced handling
	 * It will go down the results recursively up to a limit based on the distance from epicenter,
	 * strength of the explosion, and explosion resistance you set here.
	 * 
	 * @param item; inital item or itemblock 
	 * @param resistance; explosion resistance, for itemblocks, suggest using regular explosion resistance 
	 * @param metas[]; a collection of meta values
	 * @param result[]; collection of collections of items stacks, each set must match to a meta value given in the same order
	 * 
	 * ie
	 * metas[] = {meta1,meta2,meta3}
	 * result[][]= {{Itemstacks for meta1},{Itemstack for meta2},{Itemstacks for meta3}}
	 * 
	 * 
	 */
	public static void addExplosionResult(Item item, float resistance,int[][] metas, ItemStack[]... result) {
		//null check
		if (item==null) {Utility.getLogger().error("Can't Add Item! Item Null!");return;}
		//check if there's already a recipe
		if(explosionDebrisMap.containsKey(item)){//tell somebody
			Utility.getLogger().warn("Explosion Debris Recipe for " + item.getUnlocalizedName() + " already exists!");
		}else{
			//normal behaviour
			explosionDebrisMap.put(item, new Debris(resistance,metas, result));
			//we did it!! wooo
			Utility.getLogger().info("Explosion Debris Recipe for " + item.getUnlocalizedName() +" added successfully.");
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
	public static void addExplosionResult(Item item, float resistance, ItemStack... result) {
		//null check
		if (item==null) {Utility.getLogger().error("Can't Add Item! Item Null!");return;}
		//check if there's already a recipe
		if(explosionDebrisMap.containsKey(item)){//tell somebody
			Utility.getLogger().warn("Explosion Debris Recipe for " + item.getUnlocalizedName() + " already exists!");
		}else{
			//normal behaviour
			explosionDebrisMap.put(item, new Debris(resistance, result));
			//we did it!! wooo
			Utility.getLogger().info("Explosion Debris Recipe for " + item.getUnlocalizedName() +" added successfully.");
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
