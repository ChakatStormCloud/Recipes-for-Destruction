package StormCloud.recipesfordestruction.init;

import java.util.ArrayList;

//import java.util.ArrayList;

import StormCloud.recipesfordestruction.MainLib;
import StormCloud.recipesfordestruction.Utility;
import StormCloud.recipesfordestruction.item.IMetaEnum;
import StormCloud.recipesfordestruction.item.Enums.MetalDebrisTypes;
import StormCloud.recipesfordestruction.item.Enums.OreChunkTypes;
import StormCloud.recipesfordestruction.item.Enums.RubbleTypes;
import StormCloud.recipesfordestruction.item.ItemMetalBits;
import StormCloud.recipesfordestruction.item.ItemMulch;
import StormCloud.recipesfordestruction.item.ItemOreChunk;
import StormCloud.recipesfordestruction.item.ItemRubble;
import net.minecraft.client.renderer.block.model.ModelBakery;
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
	public static Item itemRubble;
	
	public static void init(){
		Utility.getLogger().info("Items - init");
		itemMulch = new ItemMulch("itemMulch");
		itemSplinters = null;
		itemMetalBits = new ItemMetalBits("itemMetalBits");
		itemOreChunk = new ItemOreChunk("itemOreChunk");
		itemRubble = new ItemRubble("itemRubble");
		
	}
	
	public static void register() {
		Utility.getLogger().info("Items - register");
		
		registerItem(itemMulch);
		registerItem(itemMetalBits);
		registerItem(itemOreChunk);
		registerItem(itemRubble);
		
	}
	
	public static void registerRenders() {
		Utility.getLogger().info("Items - register renders");
		registerRender(itemMulch);
		registerRenderMeta(itemMetalBits,MetalDebrisTypes.values());
		registerRenderMeta(itemOreChunk,OreChunkTypes.values());
		registerRenderMeta(itemRubble,RubbleTypes.values());
	}
	
	
	public static void registerItem(Item item){
		GameRegistry.register(item);
		Utility.getLogger().info("Registered item: " + item.getUnlocalizedName().substring(5));
	}

	public static void registerRender(Item item){
		Utility.getLogger().debug("getting resource loc...");
		ResourceLocation resloc = new ResourceLocation(MainLib.MODID, item.getUnlocalizedName().substring(5));
		
		Utility.getLogger().debug("getting modelresource location...");
		ModelResourceLocation modresloc = new ModelResourceLocation(resloc, "inventory");
		
		Utility.getLogger().debug("setting resource location in model loader...");
		ModelLoader.setCustomModelResourceLocation(item, 0, modresloc);
		
		Utility.getLogger().info("Registered render for item: " + item.getUnlocalizedName().substring(5));
	}
	
	
	public static void registerRenderMeta(Item item,IMetaEnum[] enums){
		ArrayList<ResourceLocation> list = new ArrayList<ResourceLocation>();
		
		for(IMetaEnum e:enums){
			
			ModelLoader.setCustomModelResourceLocation(item, (e).getMeta(), new ModelResourceLocation(new ResourceLocation(MainLib.MODID, item.getUnlocalizedName().substring(5) + "_" + e.getMetaName()), "inventory"));
			Utility.getLogger().info("Registered render for item: " + item.getUnlocalizedName().substring(5) + "." + e.getMetaName());
			
			list.add(new ResourceLocation(MainLib.MODID,e.getMetaName()));
		}
		// Thanks to irc.furnet.org/#CodingFurs for help with this little mess
		ModelBakery.registerItemVariants(item,list.toArray(new ResourceLocation[list.size()]));
		
	}
	
}
