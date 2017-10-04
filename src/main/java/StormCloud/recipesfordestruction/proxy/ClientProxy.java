package StormCloud.recipesfordestruction.proxy;

import StormCloud.recipesfordestruction.init.ItemsHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	@Override
	public void preInit(FMLPreInitializationEvent event){
		ItemsHandler.registerRenders();
		super.preInit(event);
	}
	@Override
	public void init(FMLInitializationEvent event){
		super.init(event);
		
	}
	@Override
	public void postInit(FMLPostInitializationEvent event){
		super.postInit(event);
		StormCloud.recipesfordestruction.EventHandler.particles = true;
	}
	
}
