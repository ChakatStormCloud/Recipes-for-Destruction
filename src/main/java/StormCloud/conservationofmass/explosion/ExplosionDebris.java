package StormCloud.conservationofmass.explosion;


import net.minecraft.item.Item;

public class ExplosionDebris {
	public final Item item;
	public final int ammount;
	public final int weight;
	public final int mass;
	public final int maxDropped;
	public int dropped;
	/**
	 * Constructor Alias
	 * @param itemIn = The item of the debris like a stick
	 * @param weightIn = range of 1 to 16, lower values for "more destroyed" debris, higher for more "intact" debris
	 * @param massIn = the mass of the debris, have to keep with physics.
	 * @param maxDroppedIn = If only a certain amount of an item should ever come from an item, like 1 diamond from a jukebox.
	 */
	public ExplosionDebris(Item itemIn,int weightIn,int massIn,int maxDroppedIn){
		this(itemIn,1,weightIn,massIn,maxDroppedIn);
	}	
	/**
	 * Constructor
	 * @param itemIn = The item of the debris like a stick
	 * @param ammountIn = the ammount of the item that should drop with this, like 2, for sticks
	 * @param weightIn = range of 1 to 16, lower values for "more destroyed" debris, higher for more "intact" debris
	 * @param massIn = the mass of the debris, have to keep with physics.
	 * @param maxDroppedIn = If only a certain amount of an item should ever come from an item, like 1 diamond from a jukebox.
	 */
	public ExplosionDebris(Item itemIn,int ammountIn,int weightIn,int massIn,int maxDroppedIn){
		item=itemIn;
		ammount=ammountIn;
		weight=weightIn;
		mass=massIn;
		maxDropped=maxDroppedIn;
	}
	
}
