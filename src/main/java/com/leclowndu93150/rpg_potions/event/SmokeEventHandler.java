package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import static com.leclowndu93150.rpg_potions.RPGPotions.MODID;

@EventBusSubscriber(modid = MODID)
public class SmokeEventHandler {
    
    @SubscribeEvent
    public static void onLivingTick(EntityTickEvent.Post event) {
        if (!(event.getEntity() instanceof LivingEntity entity)) return;
        
        if (entity.hasEffect(ModEffects.SMOKE) && entity.level() instanceof ServerLevel serverLevel) {
            int radius = PotionConfig.SMOKE_RADIUS.get();
            int density = PotionConfig.SMOKE_PARTICLE_DENSITY.get();
            
            for (int i = 0; i < density; i++) {
                double offsetX = (entity.getRandom().nextDouble() - 0.5) * radius * 2;
                double offsetY = entity.getRandom().nextDouble() * 2;
                double offsetZ = (entity.getRandom().nextDouble() - 0.5) * radius * 2;
                
                serverLevel.sendParticles(
                    ParticleTypes.CAMPFIRE_COSY_SMOKE,
                    entity.getX() + offsetX,
                    entity.getY() + offsetY,
                    entity.getZ() + offsetZ,
                    1,
                    0.0, 0.1, 0.0,
                    0.01
                );
            }
        }
    }
}
