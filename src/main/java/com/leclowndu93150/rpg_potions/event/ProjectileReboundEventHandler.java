package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.leclowndu93150.rpg_potions.RPGPotions.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class ProjectileReboundEventHandler {
    
    @SubscribeEvent
    public static void onProjectileImpact(ProjectileImpactEvent event) {
        if (!(event.getRayTraceResult() instanceof EntityHitResult entityHit)) return;
        
        Projectile projectile = event.getProjectile();
        Entity target = entityHit.getEntity();
        
        if (target instanceof LivingEntity livingTarget && livingTarget.hasEffect(ModEffects.PROJECTILE_REBOUND.get())) {
            Entity shooter = projectile.getOwner();
            
            if (shooter != null && shooter != target) {
                event.setCanceled(true);
                
                Vec3 direction = shooter.position().subtract(projectile.position()).normalize();
                projectile.setDeltaMovement(direction.scale(1.5));
                projectile.setOwner(target);
                
                if (projectile instanceof AbstractArrow arrow) {
                    if (!PotionConfig.PROJECTILE_REBOUND_FULL_DAMAGE.get()) {
                        arrow.setBaseDamage(arrow.getBaseDamage() * 0.75);
                    }
                }
            }
        }
    }
}
