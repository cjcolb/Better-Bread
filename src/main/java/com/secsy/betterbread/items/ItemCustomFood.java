package com.secsy.betterbread.items;

import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood {

	public ItemCustomFood(String name, int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}

}
