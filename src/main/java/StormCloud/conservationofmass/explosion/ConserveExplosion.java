package StormCloud.conservationofmass.explosion;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

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
				
				
				//My Block drop
				if (iblockstate.getMaterial() != Material.AIR && block.canDropFromExplosion(explosion)){
					System.out.println(block.getUnlocalizedName());
					
					
					switch(ExplosionRecipeHandler.getBlockExplosionRecipeType(block.getUnlocalizedName())){
					
					case DROP: //=================100% drop chance====================//
						block.dropBlockAsItemWithChance(this.worldObj, blockpos, this.worldObj.getBlockState(blockpos), 1.0F, 0);
						
						break;
						
					case BREAK://==================chance of breaking=================//
						
						smashBlock(block,blockpos);
						break;
					case ORE:
					case UNHANDLED: //===============vanilla===================//
					default:
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
	
	private void smashBlock(Block block, BlockPos blockpos){
		float distance = (float)Math.sqrt(blockpos.distanceSqToCenter(this.exploX, this.exploY, this.exploZ));
		float resistence = block.getExplosionResistance(this.worldObj, blockpos, null, explosion);
		float chance = ( ((size*4.0F) / (distance*0.5F)) / (resistence*1.0F));
		
		System.out.println("distance : "+distance+", resistance : "+resistence+", size : "+size+", chance = "+chance);
		
		chance =- (4 + (5 * this.worldObj.rand.nextFloat() ) );
		if(chance > 0){
			
			ArrayList<Item> dropList = new ArrayList<Item>();
			Collection<Item> debrisList = ExplosionRecipeHandler.getExplosionRecipeItems();
			for(Item item:debrisList){
				if(ExplosionRecipeHandler.getItemBreakable()){
					
				}else{
					dropList.
				}
				
				
			}
			
			for(Item item : dropList){
				EntityItem entityitem = new EntityItem(this.worldObj, blockpos.getX()+0.5,blockpos.getY()+0.5, blockpos.getZ()+0.5,new ItemStack(item,1,0,null));
				this.worldObj.spawnEntityInWorld(entityitem);
			}
		}else{
			block.dropBlockAsItemWithChance(this.worldObj, blockpos, this.worldObj.getBlockState(blockpos), 1.0F, 0);
		}
	}
}

