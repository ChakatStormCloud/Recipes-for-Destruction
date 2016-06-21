package StormCloud.conservationofmass.proxy;

import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy {

	@SubscribeEvent
	public void explosionTriggeredDetonate2(ExplosionEvent.Detonate event){
		/*
		ConserveExplosion cExplosion = new ConserveExplosion(event.getWorld(),event.getExplosion(),event.getAffectedBlocks());
		cExplosion.Detonate();
		*/
		System.out.println("++++++++++++++++++++++SubscribeEvent caught it!!");
	}

}
