package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.entity.SmokeEmitterEntity;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.leclowndu93150.rpg_potions.RPGPotions.MODID;

@EventBusSubscriber(modid = MODID)
public class SmokeEventHandler {

    @SubscribeEvent
    public static void onPotionImpact(ProjectileImpactEvent event) {
        if (!(event.getProjectile() instanceof ThrownPotion thrownPotion)) {
            return;
        }

        if (!(event.getProjectile().level() instanceof ServerLevel serverLevel)) {
            return;
        }

        PotionContents potionContents = thrownPotion.getItem().get(DataComponents.POTION_CONTENTS);
        if (potionContents == null) {
            return;
        }

        MobEffectInstance smokeEffect = null;
        List<MobEffectInstance> remainingEffects = new ArrayList<>();

        for (MobEffectInstance effect : potionContents.getAllEffects()) {
            if (effect.getEffect().is(ModEffects.SMOKE.getKey())) {
                smokeEffect = effect;
            } else {
                remainingEffects.add(effect);
            }
        }

        if (smokeEffect == null) {
            return;
        }

        HitResult hitResult = event.getRayTraceResult();
        SmokeEmitterEntity emitter = new SmokeEmitterEntity(
                serverLevel,
                hitResult.getLocation().x,
                hitResult.getLocation().y,
                hitResult.getLocation().z,
                smokeEffect.getDuration()
        );
        serverLevel.addFreshEntity(emitter);

        if (remainingEffects.isEmpty()) {
            event.setCanceled(true);
            thrownPotion.discard();
        } else {
            ItemStack newStack = thrownPotion.getItem().copy();
            PotionContents newContents = new PotionContents(
                    Optional.empty(),
                    Optional.empty(),
                    remainingEffects
            );
            newStack.set(DataComponents.POTION_CONTENTS, newContents);
            thrownPotion.setItem(newStack);
        }
    }
    
    @SubscribeEvent
    public static void onLivingTick(EntityTickEvent.Post event) {
        if (!(event.getEntity() instanceof LivingEntity entity)) return;
        
        if (entity.hasEffect(ModEffects.SMOKE) && entity.level() instanceof ServerLevel serverLevel) {
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
