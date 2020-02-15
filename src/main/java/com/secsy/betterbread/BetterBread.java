package com.secsy.betterbread;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.secsy.betterbread.init.ModBlocks;
import com.secsy.betterbread.init.ModItems;
import com.secsy.betterbread.init.ModRecipes;
import com.secsy.betterbread.util.handlers.CraftingHandler;

@Mod(modid = BetterBread.MODID, name = BetterBread.NAME, version = BetterBread.VERSION)
public class BetterBread {
	
	@Instance
	public static BetterBread instance;
	
	public static final String MODID = "betterbread";
	public static final String NAME = "Better Bread";
	public static final String VERSION = "1.0";
	public static final String ACCEPTED_MINECRAFT_VERSIONS = "[1.12]";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(MODID + " :preInit");
		
		ModItems.init();
		ModBlocks.init();
		ModRecipes.init();
		
		CraftingHandler.removeRecipes();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(MODID + " :init");
	}
	
	@EventHandler
	public void postInit(FMLPreInitializationEvent event) {
		System.out.println(MODID + " :postInit");
	}
}
