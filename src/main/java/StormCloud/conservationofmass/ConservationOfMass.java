package StormCloud.conservationofmass;

import StormCloud.conservationofmass.proxy.CommonProxy;

import net.minecraft.init.Blocks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = MainLib.MODID, name = MainLib.MODNAME , version = MainLib.VERSION)
public class ConservationOfMass {
	public static final String MODID = MainLib.MODID;
	public static final String VERSION = MainLib.VERSION;
	public static final String MODNAME = MainLib.MODNAME;
	
	@Mod.Instance(MainLib.MODID)
	public static ConservationOfMass instance;
	
	
	@SidedProxy(clientSide="com.bedrockminer.tutorial.CombinedClientProxy", serverSide="com.bedrockminer.tutorial.DedicatedServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// some example code
		System.out.println("DIRT BLOCK >> " + Blocks.DIRT.getUnlocalizedName());
	}
	
	

}