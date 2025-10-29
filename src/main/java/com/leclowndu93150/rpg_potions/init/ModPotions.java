package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, RPGPotions.MODID);

    public static final RegistryObject<Potion> SMOKE = POTIONS.register("smoke",
            () -> new Potion(new MobEffectInstance(ModEffects.SMOKE.get(), 200)));

    public static final RegistryObject<Potion> DECOY = POTIONS.register("decoy",
            () -> new Potion(new MobEffectInstance(ModEffects.DECOY.get(), 300)));

    public static final RegistryObject<Potion> KNOCKBACK = POTIONS.register("knockback",
            () -> new Potion(new MobEffectInstance(ModEffects.KNOCKBACK.get(), 1)));

    public static final RegistryObject<Potion> PHANTOM_ARMOR = POTIONS.register("phantom_armor",
            () -> new Potion(new MobEffectInstance(ModEffects.PHANTOM_ARMOR.get(), 6000)));

    public static final RegistryObject<Potion> PARALYSIS = POTIONS.register("paralysis",
            () -> new Potion(new MobEffectInstance(ModEffects.PARALYSIS.get(), 100)));

    public static final RegistryObject<Potion> PROJECTILE_REBOUND = POTIONS.register("projectile_rebound",
            () -> new Potion(new MobEffectInstance(ModEffects.PROJECTILE_REBOUND.get(), 300)));

    public static final RegistryObject<Potion> HEAT_MARK = POTIONS.register("heat_mark",
            () -> new Potion(new MobEffectInstance(ModEffects.HEAT_MARK.get(), 600)));

    public static final RegistryObject<Potion> BLACK_STAIN = POTIONS.register("black_stain",
            () -> new Potion(new MobEffectInstance(ModEffects.BLACK_STAIN.get(), 150)));
}
