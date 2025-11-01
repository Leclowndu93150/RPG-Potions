package com.leclowndu93150.rpg_potions.mixin;

import com.leclowndu93150.rpg_potions.event.ProjectileReboundEventHandler;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Projectile.class)
public class ProjectileMixin {
    
    @Inject(method = "onHit", at = @At("HEAD"), cancellable = true)
    private void onProjectileHit(HitResult hitResult, CallbackInfo ci) {
        Projectile self = (Projectile)(Object)this;
        
        if (!ProjectileReboundEventHandler.onProjectileHit(self, hitResult)) {
            ci.cancel();
        }
    }
}
