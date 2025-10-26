package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, RPGPotions.MODID);

    public static final DeferredHolder<Potion, Potion> SMOKE = POTIONS.register("smoke",
            () -> new Potion(new MobEffectInstance(ModEffects.SMOKE, 200)));

    public static final DeferredHolder<Potion, Potion> DECOY = POTIONS.register("decoy",
            () -> new Potion(new MobEffectInstance(ModEffects.DECOY, 300)));

    public static final DeferredHolder<Potion, Potion> KNOCKBACK = POTIONS.register("knockback",
            () -> new Potion(new MobEffectInstance(ModEffects.KNOCKBACK, 1)));

    public static final DeferredHolder<Potion, Potion> PHANTOM_ARMOR = POTIONS.register("phantom_armor",
            () -> new Potion(new MobEffectInstance(ModEffects.PHANTOM_ARMOR, 6000)));

    public static final DeferredHolder<Potion, Potion> PARALYSIS = POTIONS.register("paralysis",
            () -> new Potion(new MobEffectInstance(ModEffects.PARALYSIS, 100)));

    public static final DeferredHolder<Potion, Potion> PROJECTILE_REBOUND = POTIONS.register("projectile_rebound",
            () -> new Potion(new MobEffectInstance(ModEffects.PROJECTILE_REBOUND, 300)));

    public static final DeferredHolder<Potion, Potion> HEAT_MARK = POTIONS.register("heat_mark",
            () -> new Potion(new MobEffectInstance(ModEffects.HEAT_MARK, 600)));

    public static final DeferredHolder<Potion, Potion> BLACK_STAIN = POTIONS.register("black_stain",
            () -> new Potion(new MobEffectInstance(ModEffects.BLACK_STAIN, 150)));
}
