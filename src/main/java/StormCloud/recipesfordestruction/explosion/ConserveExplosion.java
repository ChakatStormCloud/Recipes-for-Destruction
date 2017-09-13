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
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;



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
		
		this.smoking = explosion.isSmoking;
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
				
				
				//My Block drop
				if (iblockstate.getMaterial() != Material.AIR && block.canDropFromExplosion(explosion)){
					//System.out.println(block.getUnlocalizedName());
					
					
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
		
		//ItemStack itemblock = block.getPickBlock(block.getDefaultState(), null, this.worldObj, blockpos, null);
		Item itemblock = block.getItemDropped(block.getDefaultState(), exploRNG, 0);
		
		float power = (size*4f)/distance;
		
		ArrayList<Item> start = new ArrayList<Item>();
		ArrayList<Item> drops = new ArrayList<Item>();
		start.add(itemblock);
		
		int i;
		System.out.println("Begining breakdown");
		while(start.size() > 0) {
			i = exploRNG.nextInt(start.size());
			Item item = start.get(i);
			Debris debby = ExplosionRecipeHandler.getDebris(start.get(i));
			if(debby == null) {System.out.println("Debby is NULL PANIC!!");}
			if(debby != null && power > debby.resistance) {
				for(Item item2: debby.result) {start.add(item2);}
				start.remove(item);
				power -= debby.resistance;
			}else{
				drops.add(item);
				start.remove(item);
			}
		}
		for(Item item : drops) {
			EntityItem entityitem = new EntityItem(this.worldObj, blockpos.getX()+0.5,blockpos.getY()+0.5, blockpos.getZ()+0.5,new ItemStack(item));
			this.worldObj.spawnEntityInWorld(entityitem);
		}
		start.clear();
		drops.clear();
	}
}

