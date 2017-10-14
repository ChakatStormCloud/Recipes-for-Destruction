package StormCloud.recipesfordestruction.explosion.api;



import StormCloud.recipesfordestruction.Utility;
import StormCloud.recipesfordestruction.explosion.ExplosionRecipeHandler;
import StormCloud.recipesfordestruction.explosion.ExplosionRecipeHandler.RecipeType;
import StormCloud.recipesfordestruction.init.ItemsHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class Vanilla {
	
	public static void addRecipes(){
		Utility.getLogger().info("Trying to add vanilla recipes");
		ItemStack planks = new ItemStack(Item.getItemFromBlock(Blocks.PLANKS),1); 
		ItemStack stick = new ItemStack(Items.STICK,1);
		ItemStack cobble = new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE),1);
		ItemStack wool = new ItemStack(Item.getItemFromBlock(Blocks.WOOL),1);
		ItemStack redstone = new ItemStack(Items.REDSTONE,1);
		ItemStack iron = new ItemStack(Items.IRON_INGOT,1);
		
		//========================Add Debris=======================//
		addDebris(Items.BLAZE_ROD,2f,new ItemStack(Items.BLAZE_POWDER,2));
		
		addDebris(Blocks.GOLD_BLOCK,10f,new ItemStack(Items.GOLD_INGOT,9));
		addDebris(Items.GOLD_INGOT,7f,new ItemStack(ItemsHandler.itemMetalBits,9,2));
		addDebris(Blocks.IRON_BLOCK,10f,new ItemStack(Items.IRON_INGOT,9));
		addDebris(Items.IRON_INGOT,7f,new ItemStack(ItemsHandler.itemMetalBits,9,1));
		addDebris(Blocks.LAPIS_BLOCK,10f,new ItemStack(Items.DYE,9,4));
		addDebris(Blocks.REDSTONE_BLOCK,10f,new ItemStack(Items.REDSTONE,9));
		addDebris(Blocks.EMERALD_BLOCK,10f,new ItemStack(Items.EMERALD,9));
		addDebris(Blocks.DIAMOND_BLOCK,10f,new ItemStack(Items.DIAMOND,9));
		addDebris(Blocks.COAL_BLOCK,10f,new ItemStack(Items.COAL,9));
		addDebris(Blocks.QUARTZ_BLOCK,10f,new ItemStack(Items.QUARTZ,4));
		addDebris(Blocks.QUARTZ_STAIRS,10f,new ItemStack(Items.QUARTZ,6));
		
		addDebris(Blocks.CHEST, 7f, planks,planks,planks,planks,planks,planks,planks,planks);
		addDebris(Blocks.CRAFTING_TABLE, 5f, planks,planks,planks,planks);
		addDebris(Blocks.FURNACE, 9f, cobble,cobble,cobble,cobble,cobble,cobble,cobble,cobble);
		addDebris(Blocks.PLANKS, 4f, new ItemStack(Items.STICK,2));
		addDebris(Blocks.COBBLESTONE, 14f, new ItemStack(ItemsHandler.itemRubble,4,0));
		addDebris(Items.BED,6f,planks,planks,planks,wool,wool,wool);
		addDebris(Blocks.LEAVES,1f,stick);
		addDebris(Blocks.LEAVES2,1f,stick);
		addDebris(Blocks.DISPENSER,9f,cobble,cobble,cobble,cobble,cobble,cobble,cobble,redstone,new ItemStack(Items.BOW, 1));
		addDebris(Items.BOW,3f,new ItemStack(Items.STICK,3),new ItemStack(Items.STRING,3));
		addDebris(Blocks.DROPPER,9f,cobble,cobble,cobble,cobble,cobble,cobble,cobble,redstone);
		addDebris(Blocks.PISTON,8f,cobble,cobble,cobble,cobble,redstone,planks,planks,planks,iron);
		addDebris(Blocks.STICKY_PISTON,8f,cobble,cobble,cobble,cobble,redstone,planks,planks,planks,iron,new ItemStack(Items.SLIME_BALL, 1));
		addDebris(Items.CAULDRON,10f,new ItemStack(Items.IRON_INGOT,7));
		addDebris(Blocks.NOTEBLOCK,6f,planks,planks,planks,planks,planks,planks,planks,planks,redstone);
		addDebris(Blocks.BOOKSHELF,6f,planks,planks,planks,planks,planks,planks,new ItemStack(Items.BOOK, 3));
		addDebris(Items.BOOK,3f,new ItemStack(Items.PAPER,3));
		addDebris(Blocks.JUKEBOX,7f,new ItemStack(Blocks.PLANKS,8,0),new ItemStack(Items.DIAMOND,1,0));
		
		addMetaDebris(Items.DYE,4f,new int[][] {{0,1,2,3,5,6,7,8,9,10,11,12,13,14,15},{4}},
				new ItemStack[][] {{new ItemStack(ItemsHandler.itemMulch,1)},{new ItemStack(Items.DYE,1,4)}});
		
		//mulch
		addDebris(Items.WHEAT,4f,new ItemStack(ItemsHandler.itemMulch,2));
		addDebris(Blocks.MELON_BLOCK,6f,new ItemStack(Items.MELON,4));
		addDebris(Items.MELON,3f,new ItemStack(ItemsHandler.itemMulch,1));
		addDebris(Blocks.PUMPKIN,6f,new ItemStack(ItemsHandler.itemMulch,4));
		addDebris(Items.BEETROOT,4f,new ItemStack(ItemsHandler.itemMulch,2));
		addDebris(Items.CARROT,4f,new ItemStack(ItemsHandler.itemMulch,2));
		addDebris(Items.POTATO,4f,new ItemStack(ItemsHandler.itemMulch,2));
		addDebris(Items.NETHER_WART,4f,new ItemStack(ItemsHandler.itemMulch,1));
		addDebris(Blocks.NETHER_WART,4f,new ItemStack(ItemsHandler.itemMulch,1));
		addDebris(Blocks.CACTUS,4f,new ItemStack(ItemsHandler.itemMulch,2));
		addDebris(Items.REEDS,4f,new ItemStack(ItemsHandler.itemMulch,2));
		addDebris(Blocks.YELLOW_FLOWER,4f,new ItemStack(ItemsHandler.itemMulch,1));
		addDebris(Blocks.RED_FLOWER,4f,new ItemStack(ItemsHandler.itemMulch,1));
		addDebris(Blocks.BROWN_MUSHROOM,4f,new ItemStack(ItemsHandler.itemMulch,1));
		addDebris(Blocks.RED_MUSHROOM,4f,new ItemStack(ItemsHandler.itemMulch,1));
		
		addDebris(Blocks.BRICK_BLOCK,8f,new ItemStack(Items.BRICK,4,0));
		addDebris(Blocks.BRICK_STAIRS,8f,new ItemStack(Items.BRICK,6,0));
		addDebris(Blocks.NETHER_BRICK,8f,new ItemStack(Items.NETHERBRICK,4,0));
		addDebris(Blocks.NETHER_BRICK_FENCE,6f,new ItemStack(Items.NETHERBRICK,4,0));
		addDebris(Blocks.NETHER_BRICK_STAIRS,6f,new ItemStack(Items.NETHERBRICK,6,0));
		
		addDebris(Blocks.SANDSTONE,6f,new ItemStack(Blocks.SAND,4,0));
		addDebris(Blocks.SANDSTONE_STAIRS,6f,new ItemStack(Blocks.SANDSTONE,1,0));
		addDebris(Blocks.RED_SANDSTONE,6f,new ItemStack(Blocks.SAND,4,1));
		addDebris(Blocks.RED_SANDSTONE_STAIRS,6f,new ItemStack(Blocks.RED_SANDSTONE,1,0));
		
		addDebris(Items.OAK_DOOR,4f, new ItemStack(Blocks.PLANKS,2,0));
		addDebris(Blocks.OAK_FENCE,4f, new ItemStack(Blocks.PLANKS,1,0),stick);
		addDebris(Blocks.OAK_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,0),new ItemStack(Items.STICK,4));
		addDebris(Blocks.OAK_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,0));
		
		addDebris(Items.SPRUCE_DOOR,4f, new ItemStack(Blocks.PLANKS,2,1));
		addDebris(Blocks.SPRUCE_FENCE,4f, new ItemStack(Blocks.PLANKS,1,1),stick);
		addDebris(Blocks.SPRUCE_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,1),new ItemStack(Items.STICK,4));
		addDebris(Blocks.SPRUCE_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,1));
		
		addDebris(Items.BIRCH_DOOR,4f, new ItemStack(Blocks.PLANKS,2,2));
		addDebris(Blocks.BIRCH_FENCE,4f, new ItemStack(Blocks.PLANKS,1,2),stick);
		addDebris(Blocks.BIRCH_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,2),new ItemStack(Items.STICK,4));
		addDebris(Blocks.BIRCH_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,2));
		
		addDebris(Items.JUNGLE_DOOR,4f, new ItemStack(Blocks.PLANKS,2,3));
		addDebris(Blocks.JUNGLE_FENCE,4f, new ItemStack(Blocks.PLANKS,1,3),stick);
		addDebris(Blocks.JUNGLE_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,3),new ItemStack(Items.STICK,4));
		addDebris(Blocks.JUNGLE_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,3));
		
		addDebris(Items.ACACIA_DOOR,4f, new ItemStack(Blocks.PLANKS,2,4));
		addDebris(Blocks.ACACIA_FENCE,4f, new ItemStack(Blocks.PLANKS,1,4),stick);
		addDebris(Blocks.ACACIA_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,4),new ItemStack(Items.STICK,4));
		addDebris(Blocks.ACACIA_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,4));
		
		addDebris(Items.DARK_OAK_DOOR,4f, new ItemStack(Blocks.PLANKS,2,5));
		addDebris(Blocks.DARK_OAK_FENCE,4f, new ItemStack(Blocks.PLANKS,1,5),stick);
		addDebris(Blocks.DARK_OAK_FENCE_GATE,6f, new ItemStack(Blocks.PLANKS,2,5),new ItemStack(Items.STICK,4));
		addDebris(Blocks.DARK_OAK_STAIRS,3f, new ItemStack(Blocks.PLANKS,1,5));
		
		addDebris(Blocks.RAIL,6f,stick,new ItemStack(ItemsHandler.itemMetalBits,3,1));
		addDebris(Blocks.ACTIVATOR_RAIL,6f,iron,stick);
		addDebris(Blocks.DETECTOR_RAIL,6f,iron,new ItemStack(ItemsHandler.itemRubble,1,0));
		addDebris(Blocks.GOLDEN_RAIL,6f,new ItemStack(Items.GOLD_INGOT,1,0),stick);
		
		addDebris(Blocks.HOPPER,14f,new ItemStack(Items.IRON_INGOT,5,0),new ItemStack(Blocks.CHEST,1,0));
		addDebris(Items.BREWING_STAND,5f,new ItemStack(Items.BLAZE_ROD,1),new ItemStack(Blocks.COBBLESTONE,3));
		addDebris(Items.IRON_DOOR,14f,new ItemStack(Items.IRON_INGOT,2));
		addDebris(Blocks.IRON_TRAPDOOR,14f,new ItemStack(Items.IRON_INGOT,4));
		
		addDebris(Blocks.LADDER,4f,new ItemStack(Items.STICK,2));
		addDebris(Items.SIGN,4f,new ItemStack(Blocks.PLANKS,2));
		addDebris(Blocks.LEVER,4f, stick, cobble);
		addDebris(Blocks.STONE_PRESSURE_PLATE,6f,new ItemStack(ItemsHandler.itemRubble,8));
		addDebris(Blocks.WOODEN_PRESSURE_PLATE,4f,new ItemStack(Blocks.PLANKS,2));
		addDebris(Blocks.STONE_BUTTON,5f,new ItemStack(Blocks.STONE,1));
		addDebris(Blocks.WOODEN_BUTTON,3f,new ItemStack(Blocks.PLANKS,1));
		addDebris(Blocks.REDSTONE_TORCH,2f,stick,new ItemStack(Items.REDSTONE,1));
		addDebris(Items.REPEATER,4f,new ItemStack(Blocks.REDSTONE_TORCH,2),new ItemStack(Blocks.STONE,3),redstone);
		addDebris(Items.COMPARATOR,4f,new ItemStack(Blocks.REDSTONE_TORCH,3),new ItemStack(Blocks.STONE,3),new ItemStack(Items.QUARTZ,1));
		addDebris(Blocks.REDSTONE_LAMP,4f,new ItemStack(Blocks.GLOWSTONE,1),new ItemStack(Items.REDSTONE,4));
		addDebris(Blocks.GLOWSTONE,4f,new ItemStack(Items.GLOWSTONE_DUST,4));
		
		addDebris(Blocks.STONE_BRICK_STAIRS,7f, new ItemStack(Blocks.STONE_STAIRS,1,0));
		addDebris(Blocks.STONE_STAIRS,14f,new ItemStack(ItemsHandler.itemRubble,6,0));
		
		addMetaDebris(Item.getItemFromBlock(Blocks.STONEBRICK),8f,new int[][]{{0,3},{1},{2}},
				new ItemStack[][]{{new ItemStack(Blocks.STONEBRICK,1,2)},{new ItemStack(Blocks.MOSSY_COBBLESTONE,1)},{new ItemStack(Blocks.COBBLESTONE,1)}});
		addMetaDebris(Item.getItemFromBlock(Blocks.LOG),6f,new int[][]{{0,4,8,12},{1,5,9,13},{2,6,10,14},{3,7,11,15}},
				new ItemStack[][]{{new ItemStack(Blocks.PLANKS,4,0)},{new ItemStack(Blocks.PLANKS,4,1)},{new ItemStack(Blocks.PLANKS,4,2)},{new ItemStack(Blocks.PLANKS,4,3)}});
		addMetaDebris(Item.getItemFromBlock(Blocks.LOG2),6f,new int[][]{{0,4,8,12},{1,5,9,13}},
				new ItemStack[][]{{new ItemStack(Blocks.PLANKS,4,4)},{new ItemStack(Blocks.PLANKS,4,5)}});
		
		addMetaDebris(Item.getItemFromBlock(Blocks.STONE_SLAB),9f,new int[][]{{0,5,8,13},{1,9},{2,10},{3,11},{4,12},{6,14},{7,15}},
				new ItemStack[][]{{new ItemStack(Blocks.STONE_SLAB,1,3)},{new ItemStack(Blocks.SAND,2,0)},{stick},
				{new ItemStack(ItemsHandler.itemRubble,2,0)},{new ItemStack(Items.BRICK,2,0)},{new ItemStack(Items.NETHERBRICK,2,0)},
				{new ItemStack(Items.QUARTZ,2,0)}});
		
		addDebris(Item.getItemFromBlock(Blocks.STONE_SLAB2),6f,new ItemStack(Blocks.SAND,2,1));
		
		
		
		
		//========================Add Recipes=======================//
		//Type Drop
		addRecipe(Blocks.FARMLAND,RecipeType.DROP);
		addRecipe(Blocks.GRASS_PATH,RecipeType.DROP);
		addRecipe(Blocks.DIRT,RecipeType.DROP);
		addRecipe(Blocks.GRASS,RecipeType.DROP);
		addRecipe(Blocks.SAND,RecipeType.DROP);
		addRecipe(Blocks.GRAVEL,RecipeType.DROP);
		addRecipe(Blocks.NETHERRACK,RecipeType.DROP);
		addRecipe(Blocks.SOUL_SAND,RecipeType.DROP);
		addRecipe(Blocks.CLAY,RecipeType.DROP);
		addRecipe(Blocks.TRIPWIRE,RecipeType.DROP);
		addRecipe(Blocks.GLOWSTONE,RecipeType.DROP);
		
		//Drop for now, TODO: add custom items for dropping
		addRecipe(Blocks.WOOL,RecipeType.DROP);
		addRecipe(Blocks.IRON_ORE,RecipeType.DROP);
		addRecipe(Blocks.GOLD_ORE,RecipeType.DROP);
		addRecipe(Blocks.COAL_ORE,RecipeType.DROP);
		addRecipe(Blocks.LAPIS_ORE,RecipeType.DROP);
		addRecipe(Blocks.EMERALD_ORE,RecipeType.DROP);
		addRecipe(Blocks.REDSTONE_ORE,RecipeType.DROP);
		addRecipe(Blocks.LIT_REDSTONE_ORE,RecipeType.DROP);
		addRecipe(Blocks.QUARTZ_ORE,RecipeType.DROP);
		addRecipe(Blocks.DIAMOND_ORE,RecipeType.DROP);//diamond + cobble?
		addRecipe(Blocks.IRON_BARS,RecipeType.DROP);
		//Unhandled for now, add something
		addRecipe(Blocks.TORCH,RecipeType.UNHANDLED);
		
		
		//intentionally unhandled, I might do something with this, but probably not.
		addRecipe(Blocks.PORTAL,RecipeType.UNHANDLED);
		addRecipe(Blocks.CAKE,RecipeType.UNHANDLED);
		addRecipe(Blocks.ICE,RecipeType.UNHANDLED);
		addRecipe(Blocks.SNOW,RecipeType.UNHANDLED);
		addRecipe(Blocks.SNOW_LAYER,RecipeType.UNHANDLED);
		addRecipe(Blocks.TNT,RecipeType.UNHANDLED);
		
		
		//========Type Break
		addRecipe(Blocks.LADDER,RecipeType.BREAK);
		addRecipe(Blocks.STANDING_SIGN,RecipeType.BREAK);
		addRecipe(Blocks.WALL_SIGN,RecipeType.BREAK);
		addRecipe(Blocks.BREWING_STAND,RecipeType.BREAK);
		
		addRecipe(Blocks.IRON_DOOR,RecipeType.BREAK);
		addRecipe(Blocks.IRON_TRAPDOOR,RecipeType.BREAK);
		
		//BREAK, TODO: find something
		addRecipe(Blocks.WHEAT,RecipeType.BREAK);
		addRecipe(Blocks.MELON_BLOCK,RecipeType.BREAK);
		addRecipe(Blocks.MELON_STEM,RecipeType.BREAK);
		addRecipe(Blocks.PUMPKIN,RecipeType.BREAK);
		addRecipe(Blocks.LIT_PUMPKIN,RecipeType.BREAK);
		addRecipe(Blocks.PUMPKIN_STEM,RecipeType.BREAK);
		addRecipe(Blocks.VINE,RecipeType.BREAK);
		addRecipe(Blocks.BEETROOTS,RecipeType.BREAK);
		addRecipe(Blocks.CARROTS,RecipeType.BREAK);
		addRecipe(Blocks.POTATOES,RecipeType.BREAK);
		addRecipe(Blocks.COCOA,RecipeType.BREAK);
		addRecipe(Blocks.NETHER_WART,RecipeType.BREAK);
		addRecipe(Blocks.CACTUS,RecipeType.BREAK);
		addRecipe(Blocks.REEDS,RecipeType.BREAK);
		addRecipe(Blocks.YELLOW_FLOWER,RecipeType.BREAK);
		addRecipe(Blocks.RED_FLOWER,RecipeType.BREAK);
		addRecipe(Blocks.BROWN_MUSHROOM,RecipeType.BREAK);
		addRecipe(Blocks.RED_MUSHROOM,RecipeType.BREAK);
		
		//matrialblocks
		addRecipe(Blocks.GOLD_BLOCK,RecipeType.BREAK);
		addRecipe(Blocks.IRON_BLOCK,RecipeType.BREAK);
		addRecipe(Blocks.LAPIS_BLOCK,RecipeType.BREAK);
		addRecipe(Blocks.REDSTONE_BLOCK,RecipeType.BREAK);
		addRecipe(Blocks.EMERALD_BLOCK,RecipeType.BREAK);
		addRecipe(Blocks.DIAMOND_BLOCK,RecipeType.BREAK);
		addRecipe(Blocks.COAL_BLOCK,RecipeType.BREAK);
		addRecipe(Blocks.QUARTZ_BLOCK,RecipeType.BREAK);
		addRecipe(Blocks.QUARTZ_STAIRS,RecipeType.BREAK);
		
		//redstone
		addRecipe(Blocks.LEVER,RecipeType.BREAK);
		addRecipe(Blocks.STONE_PRESSURE_PLATE,RecipeType.BREAK);
		addRecipe(Blocks.WOODEN_PRESSURE_PLATE,RecipeType.BREAK);
		addRecipe(Blocks.STONE_BUTTON,RecipeType.BREAK);
		addRecipe(Blocks.WOODEN_BUTTON,RecipeType.BREAK);
		addRecipe(Blocks.REDSTONE_TORCH,RecipeType.BREAK);
		addRecipe(Blocks.UNLIT_REDSTONE_TORCH,RecipeType.BREAK);
		addRecipe(Blocks.UNPOWERED_REPEATER,RecipeType.BREAK);
		addRecipe(Blocks.POWERED_REPEATER,RecipeType.BREAK);
		addRecipe(Blocks.POWERED_COMPARATOR,RecipeType.BREAK);
		addRecipe(Blocks.UNPOWERED_COMPARATOR,RecipeType.BREAK);
		addRecipe(Blocks.REDSTONE_LAMP,RecipeType.BREAK);
		addRecipe(Blocks.LIT_REDSTONE_LAMP,RecipeType.BREAK);
		
		//bricks
		addRecipe(Blocks.BRICK_BLOCK,RecipeType.BREAK);
		addRecipe(Blocks.BRICK_STAIRS,RecipeType.BREAK);
		
		addRecipe(Blocks.NETHER_BRICK,RecipeType.BREAK);
		addRecipe(Blocks.NETHER_BRICK_FENCE,RecipeType.BREAK);
		addRecipe(Blocks.NETHER_BRICK_STAIRS,RecipeType.BREAK);
		
		//StoneBrick/slabs
		addRecipe(Blocks.STONE_SLAB,RecipeType.BREAK);
		addRecipe(Blocks.STONE_SLAB2,RecipeType.BREAK);
		addRecipe(Blocks.DOUBLE_STONE_SLAB,RecipeType.BREAK);
		addRecipe(Blocks.DOUBLE_STONE_SLAB2,RecipeType.BREAK);
		addRecipe(Blocks.STONE_BRICK_STAIRS,RecipeType.BREAK);
		
		//sandstone
		addRecipe(Blocks.SANDSTONE,RecipeType.BREAK);
		addRecipe(Blocks.SANDSTONE_STAIRS,RecipeType.BREAK);
		addRecipe(Blocks.RED_SANDSTONE,RecipeType.BREAK);
		addRecipe(Blocks.RED_SANDSTONE_STAIRS,RecipeType.BREAK);
		
		//ALL THE WOODS
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
		
		//Rails
		addRecipe(Blocks.RAIL,RecipeType.BREAK);
		addRecipe(Blocks.ACTIVATOR_RAIL,RecipeType.BREAK);
		addRecipe(Blocks.DETECTOR_RAIL,RecipeType.BREAK);
		addRecipe(Blocks.GOLDEN_RAIL,RecipeType.BREAK);
		
		addRecipe(Blocks.BOOKSHELF,RecipeType.BREAK);
		addRecipe(Blocks.NOTEBLOCK,RecipeType.BREAK);
		addRecipe(Blocks.JUKEBOX,RecipeType.BREAK);
		addRecipe(Blocks.CAULDRON,RecipeType.BREAK);
		addRecipe(Blocks.STICKY_PISTON,RecipeType.BREAK);
		addRecipe(Blocks.PISTON,RecipeType.BREAK);
		
		addRecipe(Blocks.STONE,RecipeType.BREAK);
		addRecipe(Blocks.CHEST,RecipeType.BREAK);
		addRecipe(Blocks.CRAFTING_TABLE,RecipeType.BREAK);
		addRecipe(Blocks.FURNACE, RecipeType.BREAK);
		addRecipe(Blocks.LIT_FURNACE, RecipeType.BREAK);
		addRecipe(Blocks.COBBLESTONE, RecipeType.BREAK);
		addRecipe(Blocks.PLANKS, RecipeType.BREAK);
		addRecipe(Blocks.LOG,RecipeType.BREAK);
		addRecipe(Blocks.LOG2,RecipeType.BREAK);
		addRecipe(Blocks.BED,RecipeType.BREAK);
		addRecipe(Blocks.LEAVES,RecipeType.BREAK);
		addRecipe(Blocks.LEAVES2,RecipeType.BREAK);
		addRecipe(Blocks.DROPPER,RecipeType.BREAK);
		addRecipe(Blocks.DISPENSER,RecipeType.BREAK);
		addRecipe(Blocks.HOPPER,RecipeType.BREAK);
		
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
	
	private static void addMetaDebris(Item i, float f, int[][] metas,ItemStack[][] items) {
		ExplosionRecipeHandler.addExplosionResult(i,f,metas,items);
	}
	
}
