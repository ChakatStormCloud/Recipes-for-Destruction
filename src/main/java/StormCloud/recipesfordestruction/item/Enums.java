package StormCloud.recipesfordestruction.item;

import net.minecraft.util.IStringSerializable;

public class Enums {
	public interface IMetaEnum{
		public int getMeta();
		public String getName();
	}
	
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
			return ID;
		}
		
		public String getName(){
			return name;
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
			return ID;
		}
		
		public String getName(){
			return name;
		}
	}
}
