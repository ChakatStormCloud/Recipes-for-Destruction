package StormCloud.lawofconservation.explosion;

import java.util.List;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

/*
public class ConserveExplosion extends Explosion{

	public ConserveExplosion(World worldIn, Entity entityIn, double x, double y, double z, float size, boolean flaming, boolean smoking) {
		super(worldIn, entityIn, x, y, z, size, flaming, smoking);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doExplosionB(boolean spawnParticles){
		
	}
	
	
}
*/

@SuppressWarnings("unused") // TODO: remove this tag after I finish the class
public class ConserveExplosion{	
	private final World worldObj;
	private final Explosion explosion;
	private List<BlockPos> affectedPositions;
	private Boolean smoking;
	private Boolean flaming;
	public ConserveExplosion(World worldIn,Explosion explosionIn,List<BlockPos> affectedblocksIn){
		this.worldObj = worldIn;
		this.explosion = explosionIn;
		this.affectedPositions = affectedblocksIn;
		this.smoking = false; //well crap...
		this.flaming = false; //how am I supposed to get these...
	}
	
	public void Start(){
		//Do I even need this to do anything??
	}
	
	public void Detonate() {
		explosion.clearAffectedBlockPositions();
		
	}
	
}

