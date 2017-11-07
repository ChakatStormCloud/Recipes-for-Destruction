package StormCloud.recipesfordestruction.explosion;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import StormCloud.recipesfordestruction.explosion.ExplosionRecipeHandler.Debris;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;



public class BetterExplosion{	
	
	
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
	
	
	public BetterExplosion(World worldIn,Explosion explosionIn,List<BlockPos> affectedblocksIn){
		
		this.exploRNG = new Random();
		this.worldObj = worldIn;
		this.explosion = explosionIn;
		this.affectedBlockPosList = Lists.<BlockPos>newArrayList();
		this.affectedBlockPosList.addAll(affectedblocksIn);
		
		this.smoking = explosion.damagesTerrain;
		this.flaming = explosion.causesFire;
		
		this.exploX = explosion.x;
		this.exploY = explosion.y;
		this.exploZ = explosion.z;
		
		this.size = explosion.size;
		
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
					double d6 = (double)MathHelper.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
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
				
				
				//My Block drop
				if (iblockstate.getMaterial() != Material.AIR){
					
					if (block.canDropFromExplosion(this.explosion)) {
						switch(ExplosionRecipeHandler.getHandledType(block)){
						
						case DROP: //=================100% drop chance====================//
							block.dropBlockAsItemWithChance(this.worldObj, blockpos, this.worldObj.getBlockState(blockpos), 1.0F, 0);
							
							break;
							
						case BREAK://==================chance of breaking=================//
							
							betterSmashBlock(block,blockpos);
							break;
							
						case UNHANDLED: //===============vanilla===================//
							block.dropBlockAsItemWithChance(this.worldObj, blockpos, this.worldObj.getBlockState(blockpos), 1.0F / this.size, 0);
							break;
							
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
	
	private void betterSmashBlock(Block block, BlockPos blockpos) {
		float distance = (float)Math.sqrt(blockpos.distanceSqToCenter(this.exploX, this.exploY, this.exploZ));
		
		ItemStack blockstack = block.getPickBlock(block.getExtendedState(worldObj.getBlockState(blockpos),worldObj, blockpos),
					null, worldObj, blockpos,
					this.explosion.getExplosivePlacedBy() instanceof EntityPlayer ? (EntityPlayer)this.explosion.getExplosivePlacedBy() : null  );
		float power = ((size*4f)/distance)+exploRNG.nextFloat();
		
		ArrayList<ItemStack> stacksIn = new ArrayList<ItemStack>();
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		stacksIn.add(blockstack);
		
		int i;
		while(stacksIn.size() > 0) {
			
			i = exploRNG.nextInt(stacksIn.size());
			ItemStack itemstack = stacksIn.get(i);
			Debris debby = ExplosionRecipeHandler.getDebris(itemstack.getItem());
			
			if(debby != null && power > debby.resistance) {
				for(ItemStack item2: debby.getResults(itemstack)) {
					if(item2.getCount() > 1) {
						for(int p=0; p < item2.getCount();p++) {
							ItemStack item3 = item2.copy();
							item3.setCount(1);
							stacksIn.add(item3);
						}
					}else {
						stacksIn.add(item2);
					}
				}
				
				stacksIn.remove(itemstack);
				power -= debby.resistance;
				
			}else{
				
				drops.add(itemstack);
				stacksIn.remove(itemstack);
			} 
		}
		for(ItemStack itemstack : drops) {
			EntityItem entityitem = new EntityItem(this.worldObj, blockpos.getX()+0.5,blockpos.getY()+0.5, blockpos.getZ()+0.5,itemstack);
			this.worldObj.spawnEntity(entityitem);
		}
		stacksIn.clear();
		drops.clear();
	}
}

