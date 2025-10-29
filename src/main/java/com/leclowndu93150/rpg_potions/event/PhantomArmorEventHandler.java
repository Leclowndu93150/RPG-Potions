package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.leclowndu93150.rpg_potions.RPGPotions.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class PhantomArmorEventHandler {
    
    private static final String HITS_BLOCKED_TAG = "rpg_potions:phantom_armor_hits";
    
    @SubscribeEvent
    public static void onEffectAdded(MobEffectEvent.Added event) {
        if (event.getEffectInstance().getEffect() == (ModEffects.PHANTOM_ARMOR.get())) {
            event.getEntity().getPersistentData().putInt(HITS_BLOCKED_TAG, 0);
        }
    }
    
    @SubscribeEvent
    public static void onEffectRemoved(MobEffectEvent.Remove event) {
        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect() == (ModEffects.PHANTOM_ARMOR.get())) {
            event.getEntity().getPersistentData().remove(HITS_BLOCKED_TAG);
        }
    }
    
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        CompoundTag data = entity.getPersistentData();

        if (entity.hasEffect(ModEffects.PHANTOM_ARMOR.get())) {
            int hitsBlocked = data.getInt(HITS_BLOCKED_TAG);
            int maxHits = PotionConfig.PHANTOM_ARMOR_HITS.get();

            if (hitsBlocked < maxHits) {
                event.setAmount(0);
                data.putInt(HITS_BLOCKED_TAG, hitsBlocked + 1);

                if (hitsBlocked + 1 >= maxHits) {
                    entity.removeEffect(ModEffects.PHANTOM_ARMOR.get());
                }
            }
        }
    }
}
