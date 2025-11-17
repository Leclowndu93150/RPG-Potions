package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

import static com.leclowndu93150.rpg_potions.RPGPotions.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class HeatMarkEventHandler {
    
    private static final String CASTER_UUID_TAG = "rpg_potions:heat_mark_caster";
    
    @SubscribeEvent
    public static void onEffectAdded(MobEffectEvent.Added event) {
        LivingEntity entity = event.getEntity();
        MobEffectInstance effectInstance = event.getEffectInstance();
        
        if (effectInstance.getEffect() == ModEffects.HEAT_MARK.get()) {
            if (event.getEffectSource() instanceof LivingEntity caster) {
                System.out.println("Heat Mark applied to entity: " + entity.getUUID() + " by caster: " + caster.getUUID());
                CompoundTag data = entity.getPersistentData();
                data.putUUID(CASTER_UUID_TAG, caster.getUUID());
            }
        }
    }

    @SubscribeEvent
    public static void onEffectRevmoed(MobEffectEvent.Remove event) {
        LivingEntity entity = event.getEntity();

        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect() == ModEffects.HEAT_MARK.get()) {
            entity.setGlowingTag(false);
            entity.getPersistentData().remove(CASTER_UUID_TAG);
        }
    }
    
    @SubscribeEvent
    public static void onEffectExpired(MobEffectEvent.Expired event) {
        LivingEntity entity = event.getEntity();
        
        if (event.getEffectInstance().getEffect() == ModEffects.HEAT_MARK.get()) {
            entity.setGlowingTag(false);
            entity.getPersistentData().remove(CASTER_UUID_TAG);
        }
    }
    
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        
        if (entity.hasEffect(ModEffects.HEAT_MARK.get())) {
            CompoundTag data = entity.getPersistentData();
            
            if (data.hasUUID(CASTER_UUID_TAG) && event.getSource().getEntity() instanceof LivingEntity attacker) {
                UUID casterUUID = data.getUUID(CASTER_UUID_TAG);
                
                if (attacker.getUUID().equals(casterUUID)) {
                    float damage = event.getAmount();
                    event.setAmount((float) (damage * PotionConfig.HEAT_MARK_DAMAGE_MULTIPLIER.get()));
                }
            }
        }
    }
}
