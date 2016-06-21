package StormCloud.lawofconservation;

import StormCloud.lawofconservation.explosion.ConserveExplosion;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = LawOfConservation.MODID, version = LawOfConservation.VERSION)
public class LawOfConservation {
    public static final String MODID = "lawofconvervation";
    public static final String VERSION = "0.1";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        System.out.println("DIRT BLOCK >> " + Blocks.DIRT.getUnlocalizedName());
    }
    /*
    @EventHandler
    public void explosionTriggered(ExplosionEvent.Start event){
    	
    }
    */
    @EventHandler
    public void explosionTriggeredDetonate(ExplosionEvent.Detonate event){
    	ConserveExplosion cExplosion = new ConserveExplosion(event.getWorld(),event.getExplosion(),event.getAffectedBlocks());
    	cExplosion.Detonate();
    	
    }
}