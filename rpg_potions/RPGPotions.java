package com.leclowndu93150.rpg_potions;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import com.leclowndu93150.rpg_potions.init.ModEntities;
import com.leclowndu93150.rpg_potions.init.ModPotions;
import com.leclowndu93150.rpg_potions.init.ModCreativeTabs;
import com.leclowndu93150.rpg_potions.init.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(RPGPotions.MODID)
public class RPGPotions {
    public static final String MODID = "rpg_potions";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public RPGPotions(IEventBus modEventBus, ModContainer modContainer) {
        BLOCKS.register(modEventBus);
        
        ModItems.ITEMS.register(modEventBus);
        ModEffects.EFFECTS.register(modEventBus);
        ModPotions.POTIONS.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        
        modContainer.registerConfig(ModConfig.Type.COMMON, PotionConfig.SPEC);
    }


}
