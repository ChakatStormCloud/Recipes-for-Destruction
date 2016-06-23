package StormCloud.conservationofmass.proxy;

import StormCloud.conservationofmass.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		
	}
	
	public void init(FMLInitializationEvent event){
		try{
			MinecraftForge.EVENT_BUS.register(new EventHandler());
		}catch(Exception exception){
			exception.printStackTrace(); 
		}finally{
		}
	}
	
	public void postInit(FMLPostInitializationEvent event){
		
	}
}


