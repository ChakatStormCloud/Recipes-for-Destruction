package StormCloud.conservationofmass;

import StormCloud.conservationofmass.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MainLib.MODID, name = MainLib.MODNAME , version = MainLib.VERSION)
public class ConservationOfMass {
	public static final String MODID = MainLib.MODID;
	public static final String VERSION = MainLib.VERSION;
	public static final String MODNAME = MainLib.MODNAME;
	
	@Mod.Instance(MainLib.MODID)
	public static ConservationOfMass instance;
	
	
	@SidedProxy(clientSide = MainLib.CLIENTCLASS, serverSide = MainLib.SERVERCLASS)
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
	
	

}