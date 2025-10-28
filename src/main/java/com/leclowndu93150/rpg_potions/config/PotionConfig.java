package com.leclowndu93150.rpg_potions.config;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import static com.leclowndu93150.rpg_potions.RPGPotions.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class PotionConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue SMOKE_DURATION;
    public static final ModConfigSpec.IntValue SMOKE_RADIUS;
    public static final ModConfigSpec.IntValue SMOKE_PARTICLE_DENSITY;

    public static final ModConfigSpec.DoubleValue DECOY_HEALTH;

    public static final ModConfigSpec.DoubleValue KNOCKBACK_STRENGTH;
    public static final ModConfigSpec.DoubleValue KNOCKBACK_VERTICAL_MULTIPLIER;

    public static final ModConfigSpec.IntValue PHANTOM_ARMOR_HITS;
    public static final ModConfigSpec.IntValue PHANTOM_ARMOR_VULNERABLE_DURATION;
    public static final ModConfigSpec.DoubleValue PHANTOM_ARMOR_VULNERABLE_MULTIPLIER;

    public static final ModConfigSpec.IntValue PARALYSIS_DURATION;
    public static final ModConfigSpec.DoubleValue PARALYSIS_SPEED_MULTIPLIER;

    public static final ModConfigSpec.IntValue PROJECTILE_REBOUND_DURATION;
    public static final ModConfigSpec.BooleanValue PROJECTILE_REBOUND_FULL_DAMAGE;

    public static final ModConfigSpec.IntValue HEAT_MARK_DURATION;
    public static final ModConfigSpec.DoubleValue HEAT_MARK_DAMAGE_MULTIPLIER;
    public static final ModConfigSpec.IntValue HEAT_MARK_GLOW_COLOR;

    public static final ModConfigSpec.IntValue BLACK_STAIN_DURATION;
    public static final ModConfigSpec.IntValue BLACK_STAIN_INTENSITY;

    static {
        BUILDER.push("Smoke Potion");
        SMOKE_DURATION = BUILDER.comment("Duration in ticks (20 ticks = 1 second)")
                .defineInRange("duration", 200, 20, 6000);
        SMOKE_RADIUS = BUILDER.comment("Radius of smoke cloud in blocks")
                .defineInRange("radius", 5, 1, 20);
        SMOKE_PARTICLE_DENSITY = BUILDER.comment("Particle density (higher = denser)")
                .defineInRange("particleDensity", 150, 10, 500);
        BUILDER.pop();

        BUILDER.push("Decoy Potion");
        DECOY_HEALTH = BUILDER.comment("Health of the decoy")
                .defineInRange("health", 20.0, 1.0, 100.0);
        BUILDER.pop();

        BUILDER.push("Knockback Potion");
        KNOCKBACK_STRENGTH = BUILDER.comment("Horizontal knockback strength")
                .defineInRange("strength", 3.0, 0.5, 10.0);
        KNOCKBACK_VERTICAL_MULTIPLIER = BUILDER.comment("Vertical knockback multiplier")
                .defineInRange("verticalMultiplier", 0.5, 0.0, 2.0);
        BUILDER.pop();

        BUILDER.push("Phantom Armor Potion");
        PHANTOM_ARMOR_HITS = BUILDER.comment("Number of hits blocked")
                .defineInRange("hitsBlocked", 3, 1, 10);
        PHANTOM_ARMOR_VULNERABLE_DURATION = BUILDER.comment("Vulnerable duration in ticks after armor breaks")
                .defineInRange("vulnerableDuration", 100, 20, 600);
        PHANTOM_ARMOR_VULNERABLE_MULTIPLIER = BUILDER.comment("Damage multiplier when vulnerable")
                .defineInRange("vulnerableMultiplier", 1.5, 1.0, 3.0);
        BUILDER.pop();

        BUILDER.push("Paralysis Potion");
        PARALYSIS_DURATION = BUILDER.comment("Duration in ticks")
                .defineInRange("duration", 100, 20, 600);
        PARALYSIS_SPEED_MULTIPLIER = BUILDER.comment("Speed multiplier (0.0 = can't move)")
                .defineInRange("speedMultiplier", 0.3, 0.0, 0.9);
        BUILDER.pop();

        BUILDER.push("Projectile Rebound Potion");
        PROJECTILE_REBOUND_DURATION = BUILDER.comment("Duration in ticks")
                .defineInRange("duration", 300, 20, 6000);
        PROJECTILE_REBOUND_FULL_DAMAGE = BUILDER.comment("Return projectiles with full damage")
                .define("fullDamage", true);
        BUILDER.pop();

        BUILDER.push("Heat Mark Potion");
        HEAT_MARK_DURATION = BUILDER.comment("Duration in ticks")
                .defineInRange("duration", 300, 20, 6000);
        HEAT_MARK_DAMAGE_MULTIPLIER = BUILDER.comment("Damage multiplier from caster")
                .defineInRange("damageMultiplier", 1.25, 1.0, 3.0);
        HEAT_MARK_GLOW_COLOR = BUILDER.comment("Glow color (RGB hex, e.g., 0xFF0000 for red)")
                .defineInRange("glowColor", 0xFF0000, 0x000000, 0xFFFFFF);
        BUILDER.pop();

        BUILDER.push("Black Stain Potion");
        BLACK_STAIN_DURATION = BUILDER.comment("Duration in ticks")
                .defineInRange("duration", 150, 20, 600);
        BLACK_STAIN_INTENSITY = BUILDER.comment("Intensity of the visual effect (0-100)")
                .defineInRange("intensity", 12, 0, 100);
        BUILDER.pop();
    }

    public static final ModConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
    }
}
