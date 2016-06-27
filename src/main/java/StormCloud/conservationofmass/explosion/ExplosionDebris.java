package StormCloud.conservationofmass.explosion;

import net.minecraft.item.Item;

public class ExplosionDebris {
	public final Item item;
	public final int ammount;
	public final int weight;
	public final boolean onlyOne;
	/**
	 * 
	 * @param itemIn = The item of the debris like a stick
	 * @param ammountIn = the ammount of the item that should drop with this, like 2, for sticks
	 * @param weightIn = The more destroyed the block is, the smaller weights will be used, for example, a stick would be 1, a plank, 2.
	 * @param onlyOneIn = for special pieces that should there should only be one of, like the diamond in a jukebox.
	 */
	public ExplosionDebris(Item itemIn,int ammountIn,int weightIn){
		this(itemIn,ammountIn,weightIn,false);
	}
	public ExplosionDebris(Item itemIn,int weightIn,boolean onlyOneIn){
		this(itemIn,1,weightIn,onlyOneIn);
	}
	public ExplosionDebris(Item itemIn,int ammountIn,int weightIn,boolean onlyOneIn){
		item=itemIn;
		ammount=ammountIn;
		weight=weightIn;
		onlyOne=onlyOneIn;
	}
	
}
