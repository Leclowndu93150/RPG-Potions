package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RPGPotions.MODID);
    
    public static final DeferredItem<Item> DECOY_SPAWN_EGG = ITEMS.register("decoy_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.DECOY, 0xFFAA00, 0xFFFFFF, new Item.Properties()));
}
