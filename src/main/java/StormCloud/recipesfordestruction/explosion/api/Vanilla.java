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
		ItemStack string = new ItemStack(Items.STRING,1);
		ItemStack iron = new ItemStack(Items.IRON_INGOT,1);
		
		
		addDebris(Item.getItemFromBlock(Blocks.CHEST), 6f, planks,planks,planks,planks,planks,planks,planks,planks);
		addDebris(Item.getItemFromBlock(Blocks.CRAFTING_TABLE), 4f, planks,planks,planks,planks);
		addDebris(Item.getItemFromBlock(Blocks.FURNACE), 9f, cobble,cobble,cobble,cobble,cobble,cobble,cobble,cobble);
		addDebris(Item.getItemFromBlock(Blocks.PLANKS), 2f, new ItemStack(Items.STICK,2));
		addDebris(Item.getItemFromBlock(Blocks.COBBLESTONE), 14f, new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)));
		addDebris(Item.getItemFromBlock(Blocks.LOG),7f,planks,planks,planks,planks);
		addDebris(Item.getItemFromBlock(Blocks.BED),4f,planks,planks,planks,wool,wool,wool);
		addDebris(Item.getItemFromBlock(Blocks.LEAVES),0.5f,stick);
		addDebris(Item.getItemFromBlock(Blocks.DISPENSER),8f,cobble,cobble,cobble,cobble,cobble,cobble,cobble,redstone,new ItemStack(Items.BOW, 1));
		addDebris(Items.BOW,2f,new ItemStack(Items.STICK,3),new ItemStack(Items.STRING,3));
		addDebris(Item.getItemFromBlock(Blocks.DROPPER),8f,cobble,cobble,cobble,cobble,cobble,cobble,cobble,redstone);
		addDebris(Item.getItemFromBlock(Blocks.RAIL),5f,stick,iron);
		addDebris(Item.getItemFromBlock(Blocks.PISTON),7f,cobble,cobble,cobble,cobble,redstone,planks,planks,planks,iron);
		addDebris(Item.getItemFromBlock(Blocks.STICKY_PISTON),7f,cobble,cobble,cobble,cobble,redstone,planks,planks,planks,iron,new ItemStack(Items.SLIME_BALL, 1));
		addDebris(Items.CAULDRON,10f,new ItemStack(Items.IRON_INGOT,7));
		addDebris(Item.getItemFromBlock(Blocks.NOTEBLOCK),6f,planks,planks,planks,planks,planks,planks,planks,planks,redstone);
		addDebris(Item.getItemFromBlock(Blocks.BOOKSHELF),4f,planks,planks,planks,planks,planks,planks,new ItemStack(Items.BOOK, 3));
		addDebris(Items.BOOK,2f,new ItemStack(Items.PAPER,3));
		addDebris(Item.getItemFromBlock(Blocks.OAK_FENCE),5f,planks,stick);
		//TODO: find a way to handle subitems, damage values and etc.
		
		
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
	
	private static void addMetaDebris(Item i, float f, int[] metas,ItemStack[]... items) {
		ExplosionRecipeHandler.addExplosionResult(i,f,metas,items);
	}
	
	
}
