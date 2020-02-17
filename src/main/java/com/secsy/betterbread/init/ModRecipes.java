package com.secsy.betterbread.init;

import com.secsy.betterbread.BetterBread;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid=BetterBread.MODID)
public class ModRecipes {
	
	public static void init() {
		GameRegistry.addSmelting(ModItems.dough, new ItemStack(Items.BREAD), 0.35F);	
	}
	
	
}
