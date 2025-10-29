package com.leclowndu93150.rpg_potions;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import com.leclowndu93150.rpg_potions.init.ModEntities;
import com.leclowndu93150.rpg_potions.init.ModPotions;
import com.leclowndu93150.rpg_potions.init.ModCreativeTabs;
import com.leclowndu93150.rpg_potions.init.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(RPGPotions.MODID)
public class RPGPotions {
    public static final String MODID = "rpg_potions";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RPGPotions() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModEffects.EFFECTS.register(modEventBus);
        ModPotions.POTIONS.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PotionConfig.SPEC);
    }


}
