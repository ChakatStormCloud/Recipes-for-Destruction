package StormCloud.conservationofmass.explosion;

import net.minecraft.item.Item;

public class ProbabilityItem {
	
	public final Item item;
	public final Integer ammount;
	public ProbabilityItem(Item itemIn,int ammountIn) {
		this.item = itemIn;
		this.ammount = ammountIn;
	}

}
