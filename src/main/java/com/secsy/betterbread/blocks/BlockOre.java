package com.secsy.betterbread.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockOre extends BlockBasic {
	
	private Item itemDrop;
	private int minDrop = 1;
	private int maxDrop = 3;

	public BlockOre(String name, Material material, Item toDrop, int maxDrop) {
		super(name, material);
		this.itemDrop = toDrop;
		this.maxDrop = maxDrop;
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	//Checks if itemDrop is null, if true drop the block, if false drop the item
	@Override
	public Item getItemDropped(IBlockState state, Random random, int i) {
		return itemDrop==null?Item.getItemFromBlock(this):itemDrop;
	}
	
	//Returns the number of items dropped between minDrop and maxDrop
	@Override
	public int quantityDropped(Random random) {
		return this.minDrop + random.nextInt(this.maxDrop - this.minDrop + 1);
	}

}
