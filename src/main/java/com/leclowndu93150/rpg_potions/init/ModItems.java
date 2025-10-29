package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RPGPotions.MODID);
    
    public static final RegistryObject<Item> DECOY_SPAWN_EGG = ITEMS.register("decoy_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.DECOY, 0xFFAA00, 0xFFFFFF, new Item.Properties()));
}
