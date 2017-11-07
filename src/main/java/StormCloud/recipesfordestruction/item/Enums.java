package StormCloud.recipesfordestruction.item;

import net.minecraft.util.IStringSerializable;
import StormCloud.recipesfordestruction.item.IMetaEnum;

public class Enums {
	
	public static enum MetalDebrisTypes  implements IStringSerializable, IMetaEnum{
		IRON_NUGGET(0,"ironNugget"),
		IRON_SCRAPS(1,"ironScraps"),
		GOLD_SCRAPS(2,"goldScraps");
		
		private int ID;
		private String name;
		
		private MetalDebrisTypes(int ID,String name){
			this.ID = ID;
			this.name = name;
		}
		
		public int getMeta(){
			return this.ID;
		}
		
		public String getName(){
			return this.toString();
		}
		
		public String getMetaName(){
			return this.name;
		}
	}
	
	public static enum OreChunkTypes implements IStringSerializable, IMetaEnum{
		IRON_CHUNK(0,"ironChunk"),
		GOLD_CHUNK(1,"goldChunk");
		
		private int ID;
		private String name;
		
		private OreChunkTypes(int ID,String name){
			this.ID = ID;
			this.name = name;
		}
		
		public int getMeta(){
			return this.ID;
		}
		
		public String getName(){
			return this.toString();
		}
		
		public String getMetaName(){
			return this.name;
		}
	}
	public static enum RubbleTypes implements IStringSerializable, IMetaEnum{
		STONE(0,"stone"),
		PURPUR(1,"purpur"),
		PURPURPILE(2,"purpurPile");
		
		
		private int ID;
		private String name;
		
		private RubbleTypes(int ID,String name){
			this.ID = ID;
			this.name = name;
		}
		
		public int getMeta(){
			return this.ID;
		}
		
		public String getName(){
			return this.toString();
		}
		
		public String getMetaName(){
			return this.name;
		}
		
	}
}
