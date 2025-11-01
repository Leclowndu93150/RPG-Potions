package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

public class ModItems {
    public static final Item DECOY_SPAWN_EGG = registerItem("decoy_spawn_egg",
            new SpawnEggItem(ModEntities.DECOY, 0xFFAA00, 0xFFFFFF, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(RPGPotions.MODID, name), item);
    }

    public static void register() {
        RPGPotions.LOGGER.info("Registering items for " + RPGPotions.MODID);
    }
}
