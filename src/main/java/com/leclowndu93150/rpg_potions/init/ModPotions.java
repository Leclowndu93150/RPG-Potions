package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class ModPotions {
    public static final Potion SMOKE = registerPotion("smoke",
            new Potion(new MobEffectInstance(ModEffects.SMOKE, 200)));

    public static final Potion DECOY = registerPotion("decoy",
            new Potion(new MobEffectInstance(ModEffects.DECOY, 300)));

    public static final Potion KNOCKBACK = registerPotion("knockback",
            new Potion(new MobEffectInstance(ModEffects.KNOCKBACK, 1)));

    public static final Potion PHANTOM_ARMOR = registerPotion("phantom_armor",
            new Potion(new MobEffectInstance(ModEffects.PHANTOM_ARMOR, 6000)));

    public static final Potion PARALYSIS = registerPotion("paralysis",
            new Potion(new MobEffectInstance(ModEffects.PARALYSIS, 100)));

    public static final Potion PROJECTILE_REBOUND = registerPotion("projectile_rebound",
            new Potion(new MobEffectInstance(ModEffects.PROJECTILE_REBOUND, 300)));

    public static final Potion HEAT_MARK = registerPotion("heat_mark",
            new Potion(new MobEffectInstance(ModEffects.HEAT_MARK, 600)));

    public static final Potion BLACK_STAIN = registerPotion("black_stain",
            new Potion(new MobEffectInstance(ModEffects.BLACK_STAIN, 150)));

    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(BuiltInRegistries.POTION, new ResourceLocation(RPGPotions.MODID, name), potion);
    }

    public static void register() {
        RPGPotions.LOGGER.info("Registering potions for " + RPGPotions.MODID);
    }
}
