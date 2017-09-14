package StormCloud.recipesfordestruction;

import StormCloud.recipesfordestruction.explosion.BetterExplosion;
import net.minecraftforge.event.world.ExplosionEvent;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler{
	
	public static boolean particles = false;
	
	@SubscribeEvent
	public void onExplosionDetonate(ExplosionEvent.Detonate event){
		
		BetterExplosion betterExplosion = new BetterExplosion(event.getWorld(),event.getExplosion(),event.getAffectedBlocks());
		betterExplosion.Detonate(particles); 
		
		
	}
}
