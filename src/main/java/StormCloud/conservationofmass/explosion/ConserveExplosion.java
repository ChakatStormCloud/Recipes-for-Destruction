package StormCloud.conservationofmass.explosion;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;


// TODO: remove this tag after I finish the class
public class ConserveExplosion{	
	
	
	private final World worldObj;
	private final Explosion explosion;
	private final List<BlockPos> affectedBlockPosList;
	private final Boolean smoking;
	private final Boolean flaming;
	private final Double exploX;
	private final Double exploY;
	private final Double exploZ;
	private final Float size;
	private final Random exploRNG;
	
	
	public ConserveExplosion(World worldIn,Explosion explosionIn,List<BlockPos> affectedblocksIn){
		
		this.exploRNG = new Random();
		this.worldObj = worldIn;
		this.explosion = explosionIn;
		this.affectedBlockPosList = Lists.<BlockPos>newArrayList();
		this.affectedBlockPosList.addAll(affectedblocksIn);
		
		this.smoking = explosion.isSmoking; //well crap...
		this.flaming = explosion.isFlaming;
		
		this.exploX = explosion.explosionX;
		this.exploY = explosion.explosionY;
		this.exploZ = explosion.explosionZ;
		
		this.size = explosion.explosionSize;
		
	}
	
	
	
	public void Detonate(Boolean spawnParticles) {
		explosion.clearAffectedBlockPositions();
		
		
		if (this.smoking){
			for (BlockPos blockpos : this.affectedBlockPosList){
				IBlockState iblockstate = this.worldObj.getBlockState(blockpos);
				Block block = iblockstate.getBlock();
				
				
				if (spawnParticles){
					
					double d0 = (double)((float)blockpos.getX() + this.worldObj.rand.nextFloat());
					double d1 = (double)((float)blockpos.getY() + this.worldObj.rand.nextFloat());
					double d2 = (double)((float)blockpos.getZ() + this.worldObj.rand.nextFloat());
					double d3 = d0 - this.exploX;
					double d4 = d1 - this.exploY;
					double d5 = d2 - this.exploZ;
					double d6 = (double)MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
					d3 = d3 / d6;
					d4 = d4 / d6;
					d5 = d5 / d6;
					double d7 = 0.5D / (d6 / (double)this.size + 0.1D);
					d7 = d7 * (double)(this.worldObj.rand.nextFloat() * this.worldObj.rand.nextFloat() + 0.3F);
					d3 = d3 * d7;
					d4 = d4 * d7;
					d5 = d5 * d7;
					this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, (d0 + this.exploX) / 2.0D, (d1 + this.exploY) / 2.0D, (d2 + this.exploZ) / 2.0D, d3, d4, d5, new int[0]);
					this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, d3, d4, d5, new int[0]);
				}
				
				//Vanilla block drop
				/*
				if (iblockstate.getMaterial() != Material.AIR){
					if (block.canDropFromExplosion(explosion)){
						block.dropBlockAsItemWithChance(this.worldObj, blockpos, this.worldObj.getBlockState(blockpos), 1.0F, 0);
					}
					
					block.onBlockExploded(this.worldObj, blockpos, explosion);
				}
				*/
				//My Block drop
				if (iblockstate.getMaterial() != Material.AIR){
					switch(ExplosionRecipeHandler.GetBlockExplosionRecipeType(block)){
					case 1: //100% drop chance
						if (block.canDropFromExplosion(explosion)){
							block.dropBlockAsItemWithChance(this.worldObj, blockpos, this.worldObj.getBlockState(blockpos), 1.0F, 0);
						}
						
					case 2://chance of breaking
						
						
					default: //vanilla
						if (block.canDropFromExplosion(explosion)){
							block.dropBlockAsItemWithChance(this.worldObj, blockpos, this.worldObj.getBlockState(blockpos), 1.0F / this.size, 0);
						}
					}
					block.onBlockExploded(this.worldObj, blockpos, explosion);
				}
				
				
			}
		}
		
		
		if (this.flaming){
			for (BlockPos blockpos1 : this.affectedBlockPosList)
			{
				if (this.worldObj.getBlockState(blockpos1).getMaterial() == Material.AIR && this.worldObj.getBlockState(blockpos1.down()).isFullBlock() && this.exploRNG.nextInt(3) == 0)
				{
					this.worldObj.setBlockState(blockpos1, Blocks.FIRE.getDefaultState());
				}
			}
		}
	}
	
}

