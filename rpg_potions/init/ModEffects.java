package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import com.leclowndu93150.rpg_potions.effect.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, RPGPotions.MODID);

    public static final DeferredHolder<MobEffect, SmokeEffect> SMOKE = EFFECTS.register("smoke", SmokeEffect::new);
    public static final DeferredHolder<MobEffect, DecoyEffect> DECOY = EFFECTS.register("decoy", DecoyEffect::new);
    public static final DeferredHolder<MobEffect, KnockbackEffect> KNOCKBACK = EFFECTS.register("knockback", KnockbackEffect::new);
    public static final DeferredHolder<MobEffect, PhantomArmorEffect> PHANTOM_ARMOR = EFFECTS.register("phantom_armor", PhantomArmorEffect::new);
    public static final DeferredHolder<MobEffect, ParalysisEffect> PARALYSIS = EFFECTS.register("paralysis", ParalysisEffect::new);
    public static final DeferredHolder<MobEffect, ProjectileReboundEffect> PROJECTILE_REBOUND = EFFECTS.register("projectile_rebound", ProjectileReboundEffect::new);
    public static final DeferredHolder<MobEffect, HeatMarkEffect> HEAT_MARK = EFFECTS.register("heat_mark", HeatMarkEffect::new);
    public static final DeferredHolder<MobEffect, BlackStainEffect> BLACK_STAIN = EFFECTS.register("black_stain", BlackStainEffect::new);
}
