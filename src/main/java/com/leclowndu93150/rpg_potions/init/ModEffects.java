package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import com.leclowndu93150.rpg_potions.effect.*;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

public class ModEffects {
    public static final Holder<MobEffect> SMOKE = registerEffect("smoke", new SmokeEffect());
    public static final Holder<MobEffect> DECOY = registerEffect("decoy", new DecoyEffect());
    public static final Holder<MobEffect> KNOCKBACK = registerEffect("knockback", new KnockbackEffect());
    public static final Holder<MobEffect> PHANTOM_ARMOR = registerEffect("phantom_armor", new PhantomArmorEffect());
    public static final Holder<MobEffect> PARALYSIS = registerEffect("paralysis", new ParalysisEffect());
    public static final Holder<MobEffect> PROJECTILE_REBOUND = registerEffect("projectile_rebound", new ProjectileReboundEffect());
    public static final Holder<MobEffect> HEAT_MARK = registerEffect("heat_mark", new HeatMarkEffect());
    public static final Holder<MobEffect> BLACK_STAIN = registerEffect("black_stain", new BlackStainEffect());

    private static Holder<MobEffect> registerEffect(String name, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(RPGPotions.MODID, name), effect);
    }

    public static void register() {
        RPGPotions.LOGGER.info("Registering effects for " + RPGPotions.MODID);
    }
}
