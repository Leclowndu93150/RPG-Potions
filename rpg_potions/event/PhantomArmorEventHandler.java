package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

import static com.leclowndu93150.rpg_potions.RPGPotions.MODID;

@EventBusSubscriber(modid = MODID)
public class PhantomArmorEventHandler {
    
    private static final String HITS_BLOCKED_TAG = "rpg_potions:phantom_armor_hits";
    
    @SubscribeEvent
    public static void onEffectAdded(MobEffectEvent.Added event) {
        if (event.getEffectInstance().getEffect().is(ModEffects.PHANTOM_ARMOR)) {
            event.getEntity().getPersistentData().putInt(HITS_BLOCKED_TAG, 0);
        }
    }
    
    @SubscribeEvent
    public static void onEffectRemoved(MobEffectEvent.Remove event) {
        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect().is(ModEffects.PHANTOM_ARMOR)) {
            event.getEntity().getPersistentData().remove(HITS_BLOCKED_TAG);
        }
    }
    
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();
        CompoundTag data = entity.getPersistentData();
        
        if (entity.hasEffect(ModEffects.PHANTOM_ARMOR)) {
            int hitsBlocked = data.getInt(HITS_BLOCKED_TAG);
            int maxHits = PotionConfig.PHANTOM_ARMOR_HITS.get();
            
            if (hitsBlocked < maxHits) {
                event.getContainer().setNewDamage(0);
                data.putInt(HITS_BLOCKED_TAG, hitsBlocked + 1);
                
                if (hitsBlocked + 1 >= maxHits) {
                    entity.removeEffect(ModEffects.PHANTOM_ARMOR);
                }
            }
        }
    }
}
