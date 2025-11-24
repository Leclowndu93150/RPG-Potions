package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.entity.SmokeEmitterEntity;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

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

        ItemStack potionStack = thrownPotion.getItem();
        List<MobEffectInstance> allEffects = PotionUtils.getMobEffects(potionStack);

        MobEffectInstance smokeEffect = null;
        for (MobEffectInstance effect : allEffects) {
            if (effect.getEffect() == ModEffects.SMOKE.get()) {
                smokeEffect = effect;
                break;
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

        List<MobEffectInstance> remainingEffects = allEffects.stream()
                .filter(e -> e.getEffect() != ModEffects.SMOKE.get())
                .toList();

        if (remainingEffects.isEmpty()) {
            event.setCanceled(true);
            thrownPotion.discard();
        } else {
            ItemStack newStack = new ItemStack(potionStack.getItem());
            newStack.setTag(potionStack.getTag() != null ? potionStack.getTag().copy() : null);
            PotionUtils.setPotion(newStack, Potions.WATER);
            PotionUtils.setCustomEffects(newStack, remainingEffects);
            if (potionStack.hasCustomHoverName()) {
                newStack.setHoverName(potionStack.getHoverName());
            }
            thrownPotion.setItem(newStack);
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
