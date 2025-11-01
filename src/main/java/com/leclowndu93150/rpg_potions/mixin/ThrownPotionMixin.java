package com.leclowndu93150.rpg_potions.mixin;

import com.leclowndu93150.rpg_potions.event.SmokeEventHandler;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownPotion.class)
public class ThrownPotionMixin {
    
    @Inject(method = "onHit", at = @At("HEAD"), cancellable = true)
    private void onPotionHit(HitResult hitResult, CallbackInfo ci) {
        ThrownPotion self = (ThrownPotion)(Object)this;
        
        if (!SmokeEventHandler.onPotionImpact(self, hitResult)) {
            ci.cancel();
        }
    }
}
