package StormCloud.recipesfordestruction;

import StormCloud.recipesfordestruction.explosion.ConserveExplosion;
import net.minecraftforge.event.world.ExplosionEvent;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler{
	
	@SubscribeEvent
	public void onExplosionDetonate(ExplosionEvent.Detonate event){
		
		ConserveExplosion cExplosion = new ConserveExplosion(event.getWorld(),event.getExplosion(),event.getAffectedBlocks());
		cExplosion.Detonate(true); //This should only be true on the client...
		//I might have to make 2 event handlers one for the client, 1 for the server. should work... right?
		
		
	}
}
