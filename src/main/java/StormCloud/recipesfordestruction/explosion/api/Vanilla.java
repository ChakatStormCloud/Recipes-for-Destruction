package StormCloud.recipesfordestruction.explosion.api;

import StormCloud.recipesfordestruction.explosion.ExplosionRecipeHandler;
import StormCloud.recipesfordestruction.explosion.ExplosionRecipeHandler.RecipeType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class Vanilla {
	
	public static void addRecipes(){
		System.out.println("Trying to add recipes");
		ItemStack planks = new ItemStack(Item.getItemFromBlock(Blocks.PLANKS),1); 
		ItemStack stick = new ItemStack(Items.STICK,1);
		ItemStack cobble = new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE),1);
		ItemStack wool = new ItemStack(Item.getItemFromBlock(Blocks.WOOL),1);
		ItemStack redstone = new ItemStack(Items.REDSTONE,1);
		ItemStack iron = new ItemStack(Items.IRON_INGOT,1);
		
		
		addDebris(Blocks.CHEST, 6f, planks,planks,planks,planks,planks,planks,planks,planks);
		addDebris(Blocks.CRAFTING_TABLE, 4f, planks,planks,planks,planks);
		addDebris(Blocks.FURNACE, 9f, cobble,cobble,cobble,cobble,cobble,cobble,cobble,cobble);
		addDebris(Blocks.PLANKS, 2f, new ItemStack(Items.STICK,2));
		addDebris(Blocks.COBBLESTONE, 14f, new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)));
		addDebris(Blocks.BED,4f,planks,planks,planks,wool,wool,wool);
		addDebris(Blocks.LEAVES,0.5f,stick);
		addDebris(Blocks.DISPENSER,8f,cobble,cobble,cobble,cobble,cobble,cobble,cobble,redstone,new ItemStack(Items.BOW, 1));
		addDebris(Items.BOW,2f,new ItemStack(Items.STICK,3),new ItemStack(Items.STRING,3));
		addDebris(Blocks.DROPPER,8f,cobble,cobble,cobble,cobble,cobble,cobble,cobble,redstone);
		addDebris(Blocks.RAIL,5f,stick,iron);
		addDebris(Blocks.PISTON,7f,cobble,cobble,cobble,cobble,redstone,planks,planks,planks,iron);
		addDebris(Blocks.STICKY_PISTON,7f,cobble,cobble,cobble,cobble,redstone,planks,planks,planks,iron,new ItemStack(Items.SLIME_BALL, 1));
		addDebris(Items.CAULDRON,10f,new ItemStack(Items.IRON_INGOT,7));
		addDebris(Blocks.NOTEBLOCK,6f,planks,planks,planks,planks,planks,planks,planks,planks,redstone);
		addDebris(Blocks.BOOKSHELF,4f,planks,planks,planks,planks,planks,planks,new ItemStack(Items.BOOK, 3));
		addDebris(Items.BOOK,2f,new ItemStack(Items.PAPER,3));
		addDebris(Blocks.OAK_FENCE,5f,planks,stick);
		addDebris(Blocks.SPRUCE_FENCE,5f,new ItemStack(Blocks.PLANKS,1,1),stick);
		addDebris(Blocks.BIRCH_FENCE,5f,new ItemStack(Blocks.PLANKS,1,2),stick);
		addDebris(Blocks.JUNGLE_FENCE,5f,new ItemStack(Blocks.PLANKS,1,3),stick);
		addDebris(Blocks.ACACIA_FENCE,5f,new ItemStack(Blocks.PLANKS,1,4),stick);
		addDebris(Blocks.DARK_OAK_FENCE,5f,new ItemStack(Blocks.PLANKS,1,5),stick);
		addMetaDebris(Item.getItemFromBlock(Blocks.LOG),6f,new int[][]{{0,4,8,12},{1,5,9,13},{2,6,10,14},{3,7,11,15}},
				new ItemStack[][]{{new ItemStack(Blocks.PLANKS,4,0)},{new ItemStack(Blocks.PLANKS,4,1)},{new ItemStack(Blocks.PLANKS,4,2)},{new ItemStack(Blocks.PLANKS,4,3)}});
		addMetaDebris(Item.getItemFromBlock(Blocks.LOG2),6f,new int[][]{{0,4,8,12},{1,5,9,13}},
				new ItemStack[][]{{new ItemStack(Blocks.PLANKS,4,4)},{new ItemStack(Blocks.PLANKS,4,5)}});
		
		addRecipe(Blocks.OAK_FENCE,RecipeType.BREAK);
		addRecipe(Blocks.BOOKSHELF,RecipeType.BREAK);
		addRecipe(Blocks.NOTEBLOCK,RecipeType.BREAK);
		addRecipe(Blocks.CAULDRON,RecipeType.BREAK);
		addRecipe(Blocks.STICKY_PISTON,RecipeType.BREAK);
		addRecipe(Blocks.PISTON,RecipeType.BREAK);
		addRecipe(Blocks.RAIL,RecipeType.BREAK);
		addRecipe(Blocks.FARMLAND,RecipeType.DROP);
		addRecipe(Blocks.GRASS_PATH,RecipeType.DROP);
		addRecipe(Blocks.DIRT,RecipeType.DROP);
		addRecipe(Blocks.GRASS,RecipeType.DROP);
		addRecipe(Blocks.STONE,RecipeType.BREAK);
		addRecipe(Blocks.CHEST,RecipeType.BREAK);
		addRecipe(Blocks.CRAFTING_TABLE,RecipeType.BREAK);
		addRecipe(Blocks.FURNACE, RecipeType.BREAK);
		addRecipe(Blocks.COBBLESTONE, RecipeType.BREAK);
		addRecipe(Blocks.PLANKS, RecipeType.BREAK);
		addRecipe(Blocks.SAND,RecipeType.DROP);
		addRecipe(Blocks.LOG,RecipeType.BREAK);
		addRecipe(Blocks.LOG2,RecipeType.BREAK);
		addRecipe(Blocks.BED,RecipeType.BREAK);
		addRecipe(Blocks.LEAVES,RecipeType.BREAK);
		addRecipe(Blocks.DROPPER,RecipeType.BREAK);
		addRecipe(Blocks.DISPENSER,RecipeType.BREAK);
		
		
	}
	//maybe 
	private static void addRecipe(Block b, RecipeType r){
		ExplosionRecipeHandler.handleBlockExplosion(b,r);
	}
	private static void addDebris(Item i, float f, ItemStack... items ){
		ExplosionRecipeHandler.addExplosionResult(i,f,items);
	}
	private static void addDebris(Block b, float f, ItemStack... items ) {
		addDebris(Item.getItemFromBlock(b),f,items);
	}
	
	private static void addMetaDebris(Item i, float f, int[][] metas,ItemStack[]... items) {
		ExplosionRecipeHandler.addExplosionResult(i,f,metas,items);
	}
	
	
	
}
