package com.secsy.betterbread.util.handlers;

import java.util.ArrayList;

import com.google.common.collect.Lists;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class CraftingHandler {
	
	public static void registerRecipes() {
		
	}
	
	public static void removeRecipes() {
		ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
		ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValuesCollection());
		for (IRecipe recipe : recipes) {
			ItemStack output = recipe.getRecipeOutput();
			if (output.getItem() == Item.getByNameOrId("minecraft:bread")) {
				System.out.println("Removing the recipe for " + recipe.getRecipeOutput().getUnlocalizedName() + "...");
				recipeRegistry.remove(recipe.getRegistryName());
			}
				
		}
	}
}
