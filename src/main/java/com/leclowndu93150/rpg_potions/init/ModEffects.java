package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import com.leclowndu93150.rpg_potions.effect.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RPGPotions.MODID);

    public static final RegistryObject<MobEffect> SMOKE = EFFECTS.register("smoke", SmokeEffect::new);
    public static final RegistryObject<MobEffect> DECOY = EFFECTS.register("decoy", DecoyEffect::new);
    public static final RegistryObject<MobEffect> KNOCKBACK = EFFECTS.register("knockback", KnockbackEffect::new);
    public static final RegistryObject<MobEffect> PHANTOM_ARMOR = EFFECTS.register("phantom_armor", PhantomArmorEffect::new);
    public static final RegistryObject<MobEffect> PARALYSIS = EFFECTS.register("paralysis", ParalysisEffect::new);
    public static final RegistryObject<MobEffect> PROJECTILE_REBOUND = EFFECTS.register("projectile_rebound", ProjectileReboundEffect::new);
    public static final RegistryObject<MobEffect> HEAT_MARK = EFFECTS.register("heat_mark", HeatMarkEffect::new);
    public static final RegistryObject<MobEffect> BLACK_STAIN = EFFECTS.register("black_stain", BlackStainEffect::new);
}
