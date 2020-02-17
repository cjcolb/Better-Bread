package com.secsy.betterbread.gen;

import java.util.Random;

import com.google.common.base.Predicate;
import com.secsy.betterbread.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {

	private void runGenerator(IBlockState block, int amount, int chance, int minHeight, int maxHeight,
			Predicate<IBlockState> toReplace, World world, Random rand, int chunkX, int chunkZ) {
		if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) {
			throw new IllegalArgumentException("Illegal height constraints for World Generation... fix it.");
		}
		
		WorldGenMinable generator = new WorldGenMinable(block, amount, toReplace);
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chance; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			generator.generate(world, rand, new BlockPos(x,y,z));
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		case -1:		//Nether
		  break;
		case 0:		//Overworld
			runGenerator(ModBlocks.salt_ore.getDefaultState(), 8, 20, 12, 128, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
		  break;
		case 1:		//End
		  break;
		default:		//Everything else
		  break;
		}
	}

}
