package StormCloud.conservationofmass.explosion;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ExplosionRecipeHandler {
	
	private static HashMap<String,List<Object>> explosionRecipeMap;
	private static Boolean initialized = false;
	
	public static void init(){
		if (initialized){
			explosionRecipeMap = Maps.newHashMap();
			initialized = true;
		}
	}
	/**
	 * For checking if any recipe has been added
	 * @param Block.getUnlocalizedName()
	 * @return true if there's a recipe, false if not
	 */
	public static Boolean IsBlockHandled(String string){
		return(GetBlockExplosionRecipeType(string) != 0);
	}
	/**
	 *@param string
	 *@return 0; Unhandled, default to vanilla
	 *@return 1; Drop normally with 100% chance, for things like dirt, stone, bricks, etc.
	 *@return 2; Drop advanced with a chance of smashing into debris
	**/	
	public static Integer GetBlockExplosionRecipeType(String string){
		if (explosionRecipeMap.containsKey(string)){
			return 2;
		}
		
		
		
		
		return 0;
	}
	
	@Nullable
	public static List<ItemStack> GetExplosionResult(String string){
		if (IsBlockHandled(string)){
			List<ItemStack> list = null;
			//list.add(e);
			
			return list;
		}
		return null;
	}
	
	public static Boolean AddExplosionRecipe(String string,List<Object> resultList){
		if(explosionRecipeMap.containsKey(string)){
			return false;
		}else{
			
		}
		return true;
	}
	
}
