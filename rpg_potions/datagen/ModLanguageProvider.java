package com.leclowndu93150.rpg_potions.datagen;

import com.leclowndu93150.rpg_potions.RPGPotions;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import com.leclowndu93150.rpg_potions.init.ModEntities;
import com.leclowndu93150.rpg_potions.init.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    
    public ModLanguageProvider(PackOutput output) {
        super(output, RPGPotions.MODID, "en_us");
    }
    
    @Override
    protected void addTranslations() {
        add(ModEffects.SMOKE.get(), "Smoke");
        add(ModEffects.DECOY.get(), "Decoy");
        add(ModEffects.KNOCKBACK.get(), "Knockback");
        add(ModEffects.PHANTOM_ARMOR.get(), "Phantom Armor");
        add(ModEffects.PARALYSIS.get(), "Mild Paralysis");
        add(ModEffects.PROJECTILE_REBOUND.get(), "Projectile Rebound");
        add(ModEffects.HEAT_MARK.get(), "Heat Mark");
        add(ModEffects.BLACK_STAIN.get(), "Black Stain");
        
        add("item.minecraft.potion.effect.smoke", "Potion of Smoke");
        add("item.minecraft.splash_potion.effect.smoke", "Splash Potion of Smoke");
        add("item.minecraft.lingering_potion.effect.smoke", "Lingering Potion of Smoke");
        
        add("item.minecraft.potion.effect.decoy", "Potion of Decoy");
        add("item.minecraft.splash_potion.effect.decoy", "Splash Potion of Decoy");
        add("item.minecraft.lingering_potion.effect.decoy", "Lingering Potion of Decoy");
        
        add("item.minecraft.potion.effect.knockback", "Potion of Knockback");
        add("item.minecraft.splash_potion.effect.knockback", "Splash Potion of Knockback");
        add("item.minecraft.lingering_potion.effect.knockback", "Lingering Potion of Knockback");
        
        add("item.minecraft.potion.effect.phantom_armor", "Potion of Phantom Armor");
        add("item.minecraft.splash_potion.effect.phantom_armor", "Splash Potion of Phantom Armor");
        add("item.minecraft.lingering_potion.effect.phantom_armor", "Lingering Potion of Phantom Armor");
        
        add("item.minecraft.potion.effect.paralysis", "Potion of Mild Paralysis");
        add("item.minecraft.splash_potion.effect.paralysis", "Splash Potion of Mild Paralysis");
        add("item.minecraft.lingering_potion.effect.paralysis", "Lingering Potion of Mild Paralysis");
        
        add("item.minecraft.potion.effect.projectile_rebound", "Potion of Projectile Rebound");
        add("item.minecraft.splash_potion.effect.projectile_rebound", "Splash Potion of Projectile Rebound");
        add("item.minecraft.lingering_potion.effect.projectile_rebound", "Lingering Potion of Projectile Rebound");
        
        add("item.minecraft.potion.effect.heat_mark", "Potion of Heat Mark");
        add("item.minecraft.splash_potion.effect.heat_mark", "Splash Potion of Heat Mark");
        add("item.minecraft.lingering_potion.effect.heat_mark", "Lingering Potion of Heat Mark");
        
        add("item.minecraft.potion.effect.black_stain", "Potion of Black Stain");
        add("item.minecraft.splash_potion.effect.black_stain", "Splash Potion of Black Stain");
        add("item.minecraft.lingering_potion.effect.black_stain", "Lingering Potion of Black Stain");
        
        add("itemGroup.rpg_potions", "RPG Potions");
        
        add(ModEntities.DECOY.get(), "Decoy");
        add(ModItems.DECOY_SPAWN_EGG.get(), "Decoy Spawn Egg");
    }
}
