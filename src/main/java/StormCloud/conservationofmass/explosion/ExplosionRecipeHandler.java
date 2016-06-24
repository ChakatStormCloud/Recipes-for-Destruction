package StormCloud.conservationofmass.explosion;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ExplosionRecipeHandler {
	
	private static HashMap<Block,List<Object>> explosionRecipeMap;
	
	/**
	 *@return(0) Unhandled, default to vanilla
	 *@return(1) Drop normally with 100% chance, for things like dirt, stone, bricks, etc.
	 *@return(2) Drop advanced with a chance of smashing into debris
	**/
	public static Boolean IsBlockHandled(Block blockIn){
		return(GetBlockExplosionRecipeType(blockIn) != 0);
	}
	
	public static Integer GetBlockExplosionRecipeType(Block blockIn){
		if (explosionRecipeMap.containsKey(blockIn)){
			return 2;
		}
		
		
		
		
		return 0;
	}
	
	@Nullable
	public static List<ItemStack> GetExplosionResult(Block blockIn){
		if (IsBlockHandled(blockIn)){
			List<ItemStack> list = null;
			//list.add(e);
			
			return list;
		}
		return null;
	}
	
	public static Boolean AddExplosionRecipe(Block blockIn,List<Object> resultList){
		if(explosionRecipeMap.containsKey(blockIn)){
			return false;
		}else{
			
		}
		return true;
	}
	
}
