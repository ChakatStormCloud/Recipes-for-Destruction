package StormCloud.recipesfordestruction.explosion.api;

import StormCloud.recipesfordestruction.explosion.ExplosionRecipeHandler;
import StormCloud.recipesfordestruction.explosion.ExplosionRecipeHandler.RecipeType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class Vanilla {
	
	public static void addRecipes(){
		System.out.println("Trying to add recipes");
		Item planks = Item.getItemFromBlock(Blocks.PLANKS); 
		Item stick = Items.STICK;
		Item cobble = Item.getItemFromBlock(Blocks.COBBLESTONE);
		Item wool = Item.getItemFromBlock(Blocks.WOOL);
		Item redstone = Items.REDSTONE;
		Item string =Items.STRING;
		Item iron = Items.IRON_INGOT;
		
		addDebris(Item.getItemFromBlock(Blocks.CHEST), 6f, planks,planks,planks,planks,planks,planks,planks,planks);
		addDebris(Item.getItemFromBlock(Blocks.CRAFTING_TABLE), 4f, planks,planks,planks,planks);
		addDebris(Item.getItemFromBlock(Blocks.FURNACE), 9f, cobble,cobble,cobble,cobble,cobble,cobble,cobble,cobble);
		addDebris(planks, 2f, stick,stick);
		addDebris(cobble, 14f, Item.getItemFromBlock(Blocks.GRAVEL));
		addDebris(Item.getItemFromBlock(Blocks.LOG),7f,planks,planks,planks,planks);
		addDebris(Item.getItemFromBlock(Blocks.BED),4f,planks,planks,planks,wool,wool,wool);
		addDebris(Item.getItemFromBlock(Blocks.LEAVES),0.5f,stick);
		addDebris(Item.getItemFromBlock(Blocks.DISPENSER),8f,cobble,cobble,cobble,cobble,cobble,cobble,cobble,redstone,Items.BOW);
		addDebris(Items.BOW,2f,stick,stick,stick,string,string,string);
		addDebris(Item.getItemFromBlock(Blocks.DROPPER),8f,cobble,cobble,cobble,cobble,cobble,cobble,cobble,redstone);
		addDebris(Item.getItemFromBlock(Blocks.RAIL),5f,stick,Items.IRON_INGOT);
		addDebris(Item.getItemFromBlock(Blocks.PISTON),7f,cobble,cobble,cobble,cobble,redstone,planks,planks,planks,Items.IRON_INGOT);
		addDebris(Item.getItemFromBlock(Blocks.STICKY_PISTON),7f,cobble,cobble,cobble,cobble,redstone,planks,planks,planks,Items.IRON_INGOT,Items.SLIME_BALL);
		addDebris(Items.CAULDRON,10f,iron,iron,iron,iron,iron,iron,iron);
		addDebris(Item.getItemFromBlock(Blocks.NOTEBLOCK),6f,planks,planks,planks,planks,planks,planks,planks,planks,redstone);
		addDebris(Item.getItemFromBlock(Blocks.BOOKSHELF),4f,planks,planks,planks,planks,planks,planks,Items.BOOK,Items.BOOK,Items.BOOK);
		addDebris(Items.BOOK,2f,Items.PAPER,Items.PAPER,Items.PAPER);
		
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
		addRecipe(Blocks.BED,RecipeType.BREAK);
		addRecipe(Blocks.LEAVES,RecipeType.BREAK);
		addRecipe(Blocks.DROPPER,RecipeType.BREAK);
		addRecipe(Blocks.DISPENSER,RecipeType.BREAK);
	}
	//maybe 
	private static void addRecipe(Block b, RecipeType r){
		ExplosionRecipeHandler.handleBlockExplosion(b,r);
	}
	private static void addDebris(Item i, float f, Item... items ){
		ExplosionRecipeHandler.addExplosionResult(i,f,items);
	}
	
	
}
