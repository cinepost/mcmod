package net.pixelswarm.mcmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.pixelswarm.mcmod.MCMod;
//import net.pixelswarm.mcomd.item.custom.DowsingRodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import net.minecraft.util.Identifier;


public class ModItems {
	//public static final Item GLASS_JAR = registerItem("glass_jar",
	//	new Item( new FabricItemSettings().group(ModItemGroup.)));

	public static final Item GLASS_JAR = registerItem("glass_jar",
		new Item( new FabricItemSettings()));

	public static final Item SWEET_BERRIES_JAM = registerItem("sweet_berries_jam",
		new Item( new FabricItemSettings().food(ModFoodComponents.SWEET_BERRIES_JAM)));

	public static final Item BUTTER = registerItem("butter",
		new Item( new FabricItemSettings().food(ModFoodComponents.BUTTER)));


	public static void addItemsToItemGroup() {
    addToItemGroup(ItemGroups.INGREDIENTS, GLASS_JAR);
    addToItemGroup(ItemGroups.FOOD_AND_DRINK, SWEET_BERRIES_JAM);
	addToItemGroup(ItemGroups.FOOD_AND_DRINK, BUTTER);
  }

	private static void addToItemGroup(ItemGroup group, Item item) {
    ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
  }

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(MCMod.MOD_ID, name), item);
	}

	public static void registerModItems() {
		MCMod.LOGGER.info("Registering Mod Items for " + MCMod.MOD_ID);

		addItemsToItemGroup();
	}
}