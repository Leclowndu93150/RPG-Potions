package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.access.LivingEntityAccess;
import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;

import java.util.UUID;

public class HeatMarkEventHandler {
    
    public static final String CASTER_UUID_TAG = "rpg_potions:heat_mark_caster";
    
    public static void register() {
    }
    
    public static void onEffectAdded(LivingEntity entity, LivingEntity source) {
        System.out.println("Heat Mark applied to entity: " + entity.getUUID() + " by caster: " + source.getUUID());
        CompoundTag data = ((LivingEntityAccess)entity).rpg_potions$getPersistentData();
        data.putUUID(CASTER_UUID_TAG, source.getUUID());
    }
    
    public static void onEffectRemoved(LivingEntity entity) {
        entity.setGlowingTag(false);
        ((LivingEntityAccess)entity).rpg_potions$getPersistentData().remove(CASTER_UUID_TAG);
    }
    
    public static float modifyDamage(LivingEntity entity, LivingEntity attacker, float damage) {
        if (entity.hasEffect(ModEffects.HEAT_MARK)) {
            CompoundTag data = ((LivingEntityAccess)entity).rpg_potions$getPersistentData();
            
            if (data.hasUUID(CASTER_UUID_TAG)) {
                UUID casterUUID = data.getUUID(CASTER_UUID_TAG);
                
                if (attacker.getUUID().equals(casterUUID)) {
                    return (float) (damage * PotionConfig.HEAT_MARK_DAMAGE_MULTIPLIER);
                }
            }
        }
        return damage;
    }
}
