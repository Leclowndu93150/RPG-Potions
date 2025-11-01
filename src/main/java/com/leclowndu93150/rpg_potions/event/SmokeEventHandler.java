package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.entity.SmokeEmitterEntity;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.phys.HitResult;

public class SmokeEventHandler {
    
    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register((world) -> {
            for (var entity : world.getAllEntities()) {
                if (entity instanceof LivingEntity living && living.hasEffect(ModEffects.SMOKE)) {
                    onLivingTick(living, world);
                }
            }
        });
    }
    
    public static boolean onPotionImpact(ThrownPotion thrownPotion, HitResult hitResult) {
        if (!(thrownPotion.level() instanceof ServerLevel serverLevel)) {
            return true;
        }
        
        PotionContents potionContents = thrownPotion.getItem().get(DataComponents.POTION_CONTENTS);
        if (potionContents == null) {
            return true;
        }
        
        boolean hasSmokeEffect = false;
        int duration = 200;
        
        for (MobEffectInstance effect : potionContents.getAllEffects()) {
            if (effect.getEffect() == ModEffects.SMOKE) {
                hasSmokeEffect = true;
                duration = effect.getDuration();
                break;
            }
        }
        
        if (hasSmokeEffect) {
            SmokeEmitterEntity emitter = new SmokeEmitterEntity(
                    serverLevel,
                    hitResult.getLocation().x,
                    hitResult.getLocation().y,
                    hitResult.getLocation().z,
                    duration
            );
            serverLevel.addFreshEntity(emitter);
            
            thrownPotion.discard();
            return false;
        }
        return true;
    }
    
    private static void onLivingTick(LivingEntity entity, ServerLevel serverLevel) {
        int radius = PotionConfig.SMOKE_RADIUS;
        int density = PotionConfig.SMOKE_PARTICLE_DENSITY;
        
        for (int i = 0; i < density; i++) {
            double theta = entity.getRandom().nextDouble() * 2 * Math.PI;
            double phi = Math.acos(2 * entity.getRandom().nextDouble() - 1);
            double r = Math.cbrt(entity.getRandom().nextDouble()) * radius;
            
            double offsetX = r * Math.sin(phi) * Math.cos(theta);
            double offsetY = r * Math.sin(phi) * Math.sin(theta);
            double offsetZ = r * Math.cos(phi);
            
            serverLevel.sendParticles(
                ParticleTypes.CAMPFIRE_COSY_SMOKE,
                entity.getX() + offsetX,
                entity.getY() + offsetY,
                entity.getZ() + offsetZ,
                1,
                0.0, 0.05, 0.0,
                0.005
            );
        }
    }
}
