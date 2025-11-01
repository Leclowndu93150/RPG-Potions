package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.access.LivingEntityAccess;
import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;

public class PhantomArmorEventHandler {
    
    public static final String HITS_BLOCKED_TAG = "rpg_potions:phantom_armor_hits";
    
    public static void register() {
    }
    
    public static void onEffectAdded(LivingEntity entity) {
        ((LivingEntityAccess)entity).rpg_potions$getPersistentData().putInt(HITS_BLOCKED_TAG, 0);
    }
    
    public static void onEffectRemoved(LivingEntity entity) {
        ((LivingEntityAccess)entity).rpg_potions$getPersistentData().remove(HITS_BLOCKED_TAG);
    }
    
    public static boolean shouldCancelDamage(LivingEntity entity, float amount) {
        CompoundTag data = ((LivingEntityAccess)entity).rpg_potions$getPersistentData();

        if (entity.hasEffect(ModEffects.PHANTOM_ARMOR)) {
            int hitsBlocked = data.getInt(HITS_BLOCKED_TAG);
            int maxHits = PotionConfig.PHANTOM_ARMOR_HITS;

            if (hitsBlocked < maxHits) {
                data.putInt(HITS_BLOCKED_TAG, hitsBlocked + 1);

                if (hitsBlocked + 1 >= maxHits) {
                    entity.removeEffect(ModEffects.PHANTOM_ARMOR);
                }
                return true;
            }
        }
        return false;
    }
}
