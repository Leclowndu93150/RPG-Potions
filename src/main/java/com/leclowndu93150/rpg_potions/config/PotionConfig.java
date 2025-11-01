package com.leclowndu93150.rpg_potions.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PotionConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("rpg_potions.json");
    
    private static ConfigData config = new ConfigData();
    
    public static int SMOKE_DURATION;
    public static int SMOKE_RADIUS;
    public static int SMOKE_PARTICLE_DENSITY;
    
    public static double DECOY_HEALTH;
    
    public static double KNOCKBACK_STRENGTH;
    public static double KNOCKBACK_VERTICAL_MULTIPLIER;
    
    public static int PHANTOM_ARMOR_HITS;
    public static int PHANTOM_ARMOR_VULNERABLE_DURATION;
    public static double PHANTOM_ARMOR_VULNERABLE_MULTIPLIER;
    
    public static int PARALYSIS_DURATION;
    public static double PARALYSIS_SPEED_MULTIPLIER;
    
    public static int PROJECTILE_REBOUND_DURATION;
    public static boolean PROJECTILE_REBOUND_FULL_DAMAGE;
    
    public static int HEAT_MARK_DURATION;
    public static double HEAT_MARK_DAMAGE_MULTIPLIER;
    public static int HEAT_MARK_GLOW_COLOR;
    
    public static int BLACK_STAIN_DURATION;
    public static int BLACK_STAIN_INTENSITY;
    
    public static void init() {
        loadConfig();
        applyConfig();
    }
    
    private static void loadConfig() {
        if (Files.exists(CONFIG_PATH)) {
            try {
                String json = Files.readString(CONFIG_PATH);
                config = GSON.fromJson(json, ConfigData.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            saveConfig();
        }
    }
    
    private static void saveConfig() {
        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            String json = GSON.toJson(config);
            Files.writeString(CONFIG_PATH, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void applyConfig() {
        SMOKE_DURATION = config.smokeDuration;
        SMOKE_RADIUS = config.smokeRadius;
        SMOKE_PARTICLE_DENSITY = config.smokeParticleDensity;
        
        DECOY_HEALTH = config.decoyHealth;
        
        KNOCKBACK_STRENGTH = config.knockbackStrength;
        KNOCKBACK_VERTICAL_MULTIPLIER = config.knockbackVerticalMultiplier;
        
        PHANTOM_ARMOR_HITS = config.phantomArmorHits;
        PHANTOM_ARMOR_VULNERABLE_DURATION = config.phantomArmorVulnerableDuration;
        PHANTOM_ARMOR_VULNERABLE_MULTIPLIER = config.phantomArmorVulnerableMultiplier;
        
        PARALYSIS_DURATION = config.paralysisDuration;
        PARALYSIS_SPEED_MULTIPLIER = config.paralysisSpeedMultiplier;
        
        PROJECTILE_REBOUND_DURATION = config.projectileReboundDuration;
        PROJECTILE_REBOUND_FULL_DAMAGE = config.projectileReboundFullDamage;
        
        HEAT_MARK_DURATION = config.heatMarkDuration;
        HEAT_MARK_DAMAGE_MULTIPLIER = config.heatMarkDamageMultiplier;
        HEAT_MARK_GLOW_COLOR = config.heatMarkGlowColor;
        
        BLACK_STAIN_DURATION = config.blackStainDuration;
        BLACK_STAIN_INTENSITY = config.blackStainIntensity;
    }
    
    private static class ConfigData {
        int smokeDuration = 200;
        int smokeRadius = 5;
        int smokeParticleDensity = 150;
        
        double decoyHealth = 20.0;
        
        double knockbackStrength = 3.0;
        double knockbackVerticalMultiplier = 0.5;
        
        int phantomArmorHits = 3;
        int phantomArmorVulnerableDuration = 100;
        double phantomArmorVulnerableMultiplier = 1.5;
        
        int paralysisDuration = 100;
        double paralysisSpeedMultiplier = 0.3;
        
        int projectileReboundDuration = 300;
        boolean projectileReboundFullDamage = true;
        
        int heatMarkDuration = 300;
        double heatMarkDamageMultiplier = 1.25;
        int heatMarkGlowColor = 0xFF0000;
        
        int blackStainDuration = 150;
        int blackStainIntensity = 5;
    }
}
