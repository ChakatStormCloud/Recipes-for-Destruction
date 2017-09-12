package StormCloud.conservationofmass.proxy;

import StormCloud.conservationofmass.EventHandler;
import StormCloud.conservationofmass.explosion.ExplosionRecipeHandler;
import StormCloud.conservationofmass.explosion.api.APIhandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		ExplosionRecipeHandler.init();
	}
	
	public void init(FMLInitializationEvent event){
		
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		
		
	}
	public void postInit(FMLPostInitializationEvent event){
		APIhandler.addRecipes();
	}
}


