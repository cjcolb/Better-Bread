package com.secsy.betterbread.init;

import java.util.ArrayList;

import com.secsy.betterbread.BetterBread;
import com.secsy.betterbread.items.ItemBasic;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=BetterBread.MODID)
public class ModItems {
	
	public static Item salt;
	public static Item flour;
	public static Item dough;
	public static Item butter;
	
	private static ArrayList<Item> items = new ArrayList<Item>();
	
	public static void init() {
		salt = new ItemBasic("salt");
		items.add(salt);
		flour = new ItemBasic("flour");
		items.add(flour);
		dough = new ItemBasic("dough");
		items.add(dough);
		butter = new ItemBasic("butter");
		items.add(butter);
		
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		for (Item item : items) {
			event.getRegistry().register(item);
		}
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		for (Item item : items) {
			registerRender(item);
		}
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
