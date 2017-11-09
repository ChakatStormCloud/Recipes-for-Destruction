package StormCloud.recipesfordestruction;

import StormCloud.recipesfordestruction.init.ItemsHandler;
import StormCloud.recipesfordestruction.init.RecipeHandler;
import StormCloud.recipesfordestruction.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = MainLib.MODID, name = MainLib.MODNAME , version = MainLib.VERSION)
public class RecipesForDestruction {
	public static final String MODID = MainLib.MODID;
	public static final String VERSION = MainLib.VERSION;
	public static final String MODNAME = MainLib.MODNAME;
	
	@Mod.Instance(MainLib.MODID)
	public static RecipesForDestruction instance;
	
	
	@SidedProxy(clientSide = MainLib.CLIENTCLASS, serverSide = MainLib.SERVERCLASS)
	public static CommonProxy proxy;
	
	@SubscribeEvent
	public void registerItems(final RegistryEvent.Register<Item> event) {
		ItemsHandler.register(event);
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		ItemsHandler.init();
		
		RecipeHandler.registerOreDict();
		
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		RecipeHandler.registerCraftingRecipies();
		RecipeHandler.registerSmeltingRecipies();
		
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
	
	

}