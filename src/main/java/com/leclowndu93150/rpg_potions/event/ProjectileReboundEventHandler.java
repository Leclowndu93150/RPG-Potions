package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ProjectileReboundEventHandler {
    
    public static void register() {
    }
    
    public static boolean onProjectileHit(Projectile projectile, HitResult hitResult) {
        if (!(hitResult instanceof EntityHitResult entityHit)) return true;
        
        Entity target = entityHit.getEntity();
        
        if (target instanceof LivingEntity livingTarget && livingTarget.hasEffect(ModEffects.PROJECTILE_REBOUND)) {
            Entity shooter = projectile.getOwner();
            
            if (shooter != null && shooter != target) {
                Vec3 direction = shooter.position().subtract(projectile.position()).normalize();
                projectile.setDeltaMovement(direction.scale(1.5));
                projectile.setOwner(target);
                
                if (projectile instanceof AbstractArrow arrow) {
                    if (!PotionConfig.PROJECTILE_REBOUND_FULL_DAMAGE) {
                        arrow.setBaseDamage(arrow.getBaseDamage() * 0.75);
                    }
                }
                
                return false;
            }
        }
        return true;
    }
}
