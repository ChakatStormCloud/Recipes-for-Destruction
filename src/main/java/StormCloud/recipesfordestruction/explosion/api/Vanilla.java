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
		
		//========================Add Debris=======================//
		
		addDebris(Blocks.CHEST, 6f, planks,planks,planks,planks,planks,planks,planks,planks);
		addDebris(Blocks.CRAFTING_TABLE, 4f, planks,planks,planks,planks);
		addDebris(Blocks.FURNACE, 9f, cobble,cobble,cobble,cobble,cobble,cobble,cobble,cobble);
		addDebris(Blocks.LIT_FURNACE, 9f, cobble,cobble,cobble,cobble,cobble,cobble,cobble,cobble);
		addDebris(Blocks.PLANKS, 3f, new ItemStack(Items.STICK,2));
		addDebris(Blocks.COBBLESTONE, 14f, new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)));
		addDebris(Blocks.BED,4f,planks,planks,planks,wool,wool,wool);
		addDebris(Blocks.LEAVES,0.5f,stick);
		addDebris(Blocks.LEAVES2,0.5f,stick);
		addDebris(Blocks.DISPENSER,8f,cobble,cobble,cobble,cobble,cobble,cobble,cobble,redstone,new ItemStack(Items.BOW, 1));
		addDebris(Items.BOW,2f,new ItemStack(Items.STICK,3),new ItemStack(Items.STRING,3));
		addDebris(Blocks.DROPPER,8f,cobble,cobble,cobble,cobble,cobble,cobble,cobble,redstone);
		addDebris(Blocks.PISTON,7f,cobble,cobble,cobble,cobble,redstone,planks,planks,planks,iron);
		addDebris(Blocks.STICKY_PISTON,7f,cobble,cobble,cobble,cobble,redstone,planks,planks,planks,iron,new ItemStack(Items.SLIME_BALL, 1));
		addDebris(Items.CAULDRON,10f,new ItemStack(Items.IRON_INGOT,7));
		addDebris(Blocks.NOTEBLOCK,6f,planks,planks,planks,planks,planks,planks,planks,planks,redstone);
		addDebris(Blocks.BOOKSHELF,4f,planks,planks,planks,planks,planks,planks,new ItemStack(Items.BOOK, 3));
		addDebris(Items.BOOK,2f,new ItemStack(Items.PAPER,3));
		
		addDebris(Blocks.BRICK_BLOCK,8f,new ItemStack(Items.BRICK,4,0));
		addDebris(Blocks.BRICK_STAIRS,8f,new ItemStack(Items.BRICK,6,0));
		
		addDebris(Blocks.SANDSTONE,6f,new ItemStack(Blocks.SAND,4,0));
		addDebris(Blocks.SANDSTONE_STAIRS,6f,new ItemStack(Blocks.SANDSTONE,1,0));
		addDebris(Blocks.RED_SANDSTONE,6f,new ItemStack(Blocks.SAND,4,1));
		addDebris(Blocks.RED_SANDSTONE_STAIRS,6f,new ItemStack(Blocks.RED_SANDSTONE,1,0));
		
		addDebris(Blocks.OAK_DOOR,4f, new ItemStack(Blocks.PLANKS,2,0));
		addDebris(Blocks.OAK_FENCE,4f, new ItemStack(Blocks.PLANKS,1,0),stick);
		addDebris(Blocks.OAK_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,0),new ItemStack(Items.STICK,4));
		addDebris(Blocks.OAK_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,0));
		
		addDebris(Blocks.SPRUCE_DOOR,4f, new ItemStack(Blocks.PLANKS,2,1));
		addDebris(Blocks.SPRUCE_FENCE,4f, new ItemStack(Blocks.PLANKS,1,1),stick);
		addDebris(Blocks.SPRUCE_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,1),new ItemStack(Items.STICK,4));
		addDebris(Blocks.SPRUCE_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,1));
		
		addDebris(Blocks.BIRCH_DOOR,4f, new ItemStack(Blocks.PLANKS,2,2));
		addDebris(Blocks.BIRCH_FENCE,4f, new ItemStack(Blocks.PLANKS,1,2),stick);
		addDebris(Blocks.BIRCH_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,2),new ItemStack(Items.STICK,4));
		addDebris(Blocks.BIRCH_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,2));
		
		addDebris(Blocks.JUNGLE_DOOR,4f, new ItemStack(Blocks.PLANKS,2,3));
		addDebris(Blocks.JUNGLE_FENCE,4f, new ItemStack(Blocks.PLANKS,1,3),stick);
		addDebris(Blocks.JUNGLE_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,3),new ItemStack(Items.STICK,4));
		addDebris(Blocks.JUNGLE_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,3));
		
		addDebris(Blocks.ACACIA_DOOR,4f, new ItemStack(Blocks.PLANKS,2,4));
		addDebris(Blocks.ACACIA_FENCE,4f, new ItemStack(Blocks.PLANKS,1,4),stick);
		addDebris(Blocks.ACACIA_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,4),new ItemStack(Items.STICK,4));
		addDebris(Blocks.ACACIA_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,4));
		
		addDebris(Blocks.DARK_OAK_DOOR,4f, new ItemStack(Blocks.PLANKS,2,5));
		addDebris(Blocks.DARK_OAK_FENCE,4f, new ItemStack(Blocks.PLANKS,1,5),stick);
		addDebris(Blocks.DARK_OAK_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,5),new ItemStack(Items.STICK,4));
		addDebris(Blocks.DARK_OAK_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,5));
		
		addDebris(Blocks.RAIL,5f,stick,new ItemStack(Items.IRON_INGOT,1));
		addDebris(Blocks.ACTIVATOR_RAIL,5f,iron,stick);
		addDebris(Blocks.DETECTOR_RAIL,5f,iron,new ItemStack(Blocks.STONE,1,0));
		addDebris(Blocks.GOLDEN_RAIL,5f,new ItemStack(Items.GOLD_INGOT,1,0),stick);
		
		
		addMetaDebris(Item.getItemFromBlock(Blocks.STONEBRICK),8f,new int[][]{{0,3},{1},{2}},
				new ItemStack[][]{{new ItemStack(Blocks.STONEBRICK,1,2)},{new ItemStack(Blocks.MOSSY_COBBLESTONE,1)},{new ItemStack(Blocks.COBBLESTONE,1)}});
		addMetaDebris(Item.getItemFromBlock(Blocks.LOG),6f,new int[][]{{0,4,8,12},{1,5,9,13},{2,6,10,14},{3,7,11,15}},
				new ItemStack[][]{{new ItemStack(Blocks.PLANKS,4,0)},{new ItemStack(Blocks.PLANKS,4,1)},{new ItemStack(Blocks.PLANKS,4,2)},{new ItemStack(Blocks.PLANKS,4,3)}});
		addMetaDebris(Item.getItemFromBlock(Blocks.LOG2),6f,new int[][]{{0,4,8,12},{1,5,9,13}},
				new ItemStack[][]{{new ItemStack(Blocks.PLANKS,4,4)},{new ItemStack(Blocks.PLANKS,4,5)}});
		
		addMetaDebris(Item.getItemFromBlock(Blocks.STONE_SLAB),6f,new int[][]{{0,5,8,13},{1,9},{2,10},{3,11},{4,12},{6,14},{7,15}},
				new ItemStack[][]{{new ItemStack(Blocks.STONE_SLAB,1,3)},{new ItemStack(Blocks.SAND,2,0)},{stick},
				{new ItemStack(Blocks.GRAVEL,1,0)},{new ItemStack(Items.BRICK,2,0)},{new ItemStack(Items.NETHERBRICK,2,0)},
				{new ItemStack(Items.QUARTZ,2,0)}});
		
		addDebris(Item.getItemFromBlock(Blocks.STONE_SLAB2),6f,new ItemStack(Blocks.SAND,2,1));
		
		addMetaDebris(Item.getItemFromBlock(Blocks.DOUBLE_STONE_SLAB),8f,new int[][]{{0,5,8},{1,9},{2},{3},{4},{6},{7,15}},
				new ItemStack[][]{{cobble},{new ItemStack(Blocks.SAND,4,0)},{planks},
				{new ItemStack(Blocks.GRAVEL,1,0)},{new ItemStack(Items.BRICK,4,0)},
				{new ItemStack(Items.NETHERBRICK,4,0)},{new ItemStack(Items.QUARTZ,4,0)}});
		addDebris(Item.getItemFromBlock(Blocks.DOUBLE_STONE_SLAB2),8f,new ItemStack(Blocks.SAND,4,1));
		
		
		//========================Add Recipes=======================//
		addRecipe(Blocks.BRICK_BLOCK,RecipeType.BREAK);
		addRecipe(Blocks.BRICK_STAIRS,RecipeType.BREAK);
		
		addRecipe(Blocks.STONE_SLAB,RecipeType.BREAK);
		addRecipe(Blocks.STONE_SLAB2,RecipeType.BREAK);
		addRecipe(Blocks.DOUBLE_STONE_SLAB,RecipeType.BREAK);
		addRecipe(Blocks.DOUBLE_STONE_SLAB2,RecipeType.BREAK);
		
		addRecipe(Blocks.SANDSTONE,RecipeType.BREAK);
		addRecipe(Blocks.SANDSTONE_STAIRS,RecipeType.BREAK);
		addRecipe(Blocks.RED_SANDSTONE,RecipeType.BREAK);
		addRecipe(Blocks.RED_SANDSTONE_STAIRS,RecipeType.BREAK);
		
		addRecipe(Blocks.OAK_DOOR,RecipeType.BREAK);
		addRecipe(Blocks.OAK_FENCE,RecipeType.BREAK);
		addRecipe(Blocks.OAK_FENCE_GATE,RecipeType.BREAK);
		addRecipe(Blocks.OAK_STAIRS,RecipeType.BREAK);
		
		addRecipe(Blocks.SPRUCE_DOOR,RecipeType.BREAK);
		addRecipe(Blocks.SPRUCE_FENCE,RecipeType.BREAK);
		addRecipe(Blocks.SPRUCE_FENCE_GATE,RecipeType.BREAK);
		addRecipe(Blocks.SPRUCE_STAIRS,RecipeType.BREAK);
		
		addRecipe(Blocks.BIRCH_DOOR,RecipeType.BREAK);
		addRecipe(Blocks.BIRCH_FENCE,RecipeType.BREAK);
		addRecipe(Blocks.BIRCH_FENCE_GATE,RecipeType.BREAK);
		addRecipe(Blocks.BIRCH_STAIRS,RecipeType.BREAK);
		
		addRecipe(Blocks.JUNGLE_DOOR,RecipeType.BREAK);
		addRecipe(Blocks.JUNGLE_FENCE,RecipeType.BREAK);
		addRecipe(Blocks.JUNGLE_FENCE_GATE,RecipeType.BREAK);
		addRecipe(Blocks.JUNGLE_STAIRS,RecipeType.BREAK);
		
		addRecipe(Blocks.ACACIA_DOOR,RecipeType.BREAK);
		addRecipe(Blocks.ACACIA_FENCE,RecipeType.BREAK);
		addRecipe(Blocks.ACACIA_FENCE_GATE,RecipeType.BREAK);
		addRecipe(Blocks.ACACIA_STAIRS,RecipeType.BREAK);
		
		addRecipe(Blocks.DARK_OAK_DOOR,RecipeType.BREAK);
		addRecipe(Blocks.DARK_OAK_FENCE,RecipeType.BREAK);
		addRecipe(Blocks.DARK_OAK_FENCE_GATE,RecipeType.BREAK);
		addRecipe(Blocks.DARK_OAK_STAIRS,RecipeType.BREAK);
		
		addRecipe(Blocks.RAIL,RecipeType.BREAK);
		addRecipe(Blocks.ACTIVATOR_RAIL,RecipeType.BREAK);
		addRecipe(Blocks.DETECTOR_RAIL,RecipeType.BREAK);
		addRecipe(Blocks.GOLDEN_RAIL,RecipeType.BREAK);
		
		addRecipe(Blocks.BOOKSHELF,RecipeType.BREAK);
		addRecipe(Blocks.NOTEBLOCK,RecipeType.BREAK);
		addRecipe(Blocks.CAULDRON,RecipeType.BREAK);
		addRecipe(Blocks.STICKY_PISTON,RecipeType.BREAK);
		addRecipe(Blocks.PISTON,RecipeType.BREAK);
		addRecipe(Blocks.FARMLAND,RecipeType.DROP);
		addRecipe(Blocks.GRASS_PATH,RecipeType.DROP);
		addRecipe(Blocks.DIRT,RecipeType.DROP);
		addRecipe(Blocks.GRASS,RecipeType.DROP);
		addRecipe(Blocks.STONE,RecipeType.BREAK);
		addRecipe(Blocks.CHEST,RecipeType.BREAK);
		addRecipe(Blocks.CRAFTING_TABLE,RecipeType.BREAK);
		addRecipe(Blocks.FURNACE, RecipeType.BREAK);
		addRecipe(Blocks.LIT_FURNACE, RecipeType.BREAK);
		addRecipe(Blocks.COBBLESTONE, RecipeType.BREAK);
		addRecipe(Blocks.PLANKS, RecipeType.BREAK);
		addRecipe(Blocks.SAND,RecipeType.DROP);
		addRecipe(Blocks.LOG,RecipeType.BREAK);
		addRecipe(Blocks.LOG2,RecipeType.BREAK);
		addRecipe(Blocks.BED,RecipeType.BREAK);
		addRecipe(Blocks.LEAVES,RecipeType.BREAK);
		addRecipe(Blocks.LEAVES2,RecipeType.BREAK);
		addRecipe(Blocks.DROPPER,RecipeType.BREAK);
		addRecipe(Blocks.DISPENSER,RecipeType.BREAK);
		addRecipe(Blocks.STONEBRICK,RecipeType.BREAK);
		
	}
	
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
