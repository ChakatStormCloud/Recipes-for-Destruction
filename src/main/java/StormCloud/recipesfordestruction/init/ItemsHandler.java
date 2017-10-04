package StormCloud.recipesfordestruction.init;

import java.util.ArrayList;

//import java.util.ArrayList;

import StormCloud.recipesfordestruction.MainLib;
import StormCloud.recipesfordestruction.Utility;
import StormCloud.recipesfordestruction.item.Enums.IMetaEnum;
import StormCloud.recipesfordestruction.item.Enums.MetalDebrisTypes;
import StormCloud.recipesfordestruction.item.Enums.OreChunkTypes;
import StormCloud.recipesfordestruction.item.ItemMetalBits;
import StormCloud.recipesfordestruction.item.ItemOreChunk;
import net.minecraft.client.renderer.block.model.ModelBakery;
//import StormCloud.madengineering.backend.handlers.Enumnums.IMetaEnum;
//import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemsHandler {
	public static Item itemMulch;
	public static Item itemSplinters;
	public static Item itemMetalBits;
	public static Item itemOreChunk;
	
	public static void init(){
		itemMulch = null;
		itemSplinters = null;
		itemMetalBits = new ItemMetalBits("itemMetalBits");
		itemOreChunk = new ItemOreChunk("itemOreChunk");
		
		
	}
	
	public static void register() {
		registerItem(itemMetalBits);
		registerItem(itemOreChunk);
		
	}
	
	public static void registerRenders() {
		registerRenderMeta(itemMetalBits,MetalDebrisTypes.values());
		registerRenderMeta(itemOreChunk,OreChunkTypes.values());
		
	}
	
	
	public static void registerItem(Item item){
		GameRegistry.register(item);
		Utility.getLogger().info("Registered item: " + item.getUnlocalizedName().substring(5));
	}

	public static void registerRender(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(MainLib.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utility.getLogger().info("Registered render for item: " + item.getUnlocalizedName().substring(5));
	}
	
	
	public static void registerRenderMeta(Item item,IMetaEnum[] enums){
		ArrayList<ResourceLocation> list = new ArrayList<ResourceLocation>();
		
		for(IMetaEnum e:enums){
			
			ModelLoader.setCustomModelResourceLocation(item, (e).getMeta(), new ModelResourceLocation(new ResourceLocation(MainLib.MODID, item.getUnlocalizedName().substring(5) + "_" + e.toString()), "inventory"));
			Utility.getLogger().info("Registered render for item: " + item.getUnlocalizedName().substring(5) + "." + e.toString());
			
			list.add(new ResourceLocation(MainLib.MODID,e.toString()));
		}
		// Thanks to irc.furnet.org/#CodingFurs for help with this little mess
		ModelBakery.registerItemVariants(item,list.toArray(new ResourceLocation[list.size()]));
		
	}
	
}
