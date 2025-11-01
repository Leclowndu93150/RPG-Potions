package com.leclowndu93150.rpg_potions;

import com.leclowndu93150.rpg_potions.brewing.PotionBrewingRegistry;
import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.event.*;
import com.leclowndu93150.rpg_potions.init.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownPotion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RPGPotions implements ModInitializer {
    public static final String MODID = "rpg_potions";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        PotionConfig.init();
        
        ModItems.register();
        ModEffects.register();
        ModPotions.register();
        ModEntities.register();
        ModCreativeTabs.register();
        
        PotionBrewingRegistry.registerBrewingRecipes();
        
        ParalysisEventHandler.register();
        HeatMarkEventHandler.register();
        ProjectileReboundEventHandler.register();
        PhantomArmorEventHandler.register();
        SmokeEventHandler.register();
    }
}
