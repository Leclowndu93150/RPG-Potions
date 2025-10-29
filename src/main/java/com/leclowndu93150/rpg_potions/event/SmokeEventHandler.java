package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.entity.SmokeEmitterEntity;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.leclowndu93150.rpg_potions.RPGPotions.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class SmokeEventHandler {
    
    @SubscribeEvent
    public static void onPotionImpact(ProjectileImpactEvent event) {
        if (!(event.getProjectile() instanceof ThrownPotion thrownPotion)) {
            return;
        }
        
        if (!(event.getProjectile().level() instanceof ServerLevel serverLevel)) {
            return;
        }
        
        net.minecraft.world.item.alchemy.Potion potion = net.minecraft.world.item.alchemy.PotionUtils.getPotion(thrownPotion.getItem());
        if (potion == null) {
            return;
        }
        
        boolean hasSmokeEffect = false;
        int duration = 200;
        
        for (MobEffectInstance effect : potion.getEffects()) {
            if (effect.getEffect() == ModEffects.SMOKE.get()) {
                hasSmokeEffect = true;
                duration = effect.getDuration();
                break;
            }
        }
        
        if (hasSmokeEffect) {
            HitResult hitResult = event.getRayTraceResult();
            
            SmokeEmitterEntity emitter = new SmokeEmitterEntity(
                    serverLevel,
                    hitResult.getLocation().x,
                    hitResult.getLocation().y,
                    hitResult.getLocation().z,
                    duration
            );
            serverLevel.addFreshEntity(emitter);
            
            event.setCanceled(true);
            thrownPotion.discard();
        }
    }
    
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        
        if (entity.hasEffect(ModEffects.SMOKE.get()) && entity.level() instanceof ServerLevel serverLevel) {
            int radius = PotionConfig.SMOKE_RADIUS.get();
            int density = PotionConfig.SMOKE_PARTICLE_DENSITY.get();
            
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
}
