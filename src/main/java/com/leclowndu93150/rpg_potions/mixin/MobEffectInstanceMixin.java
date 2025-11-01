package com.leclowndu93150.rpg_potions.mixin;

import com.leclowndu93150.rpg_potions.event.HeatMarkEventHandler;
import com.leclowndu93150.rpg_potions.event.PhantomArmorEventHandler;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEffectInstance.class)
public class MobEffectInstanceMixin {
    
    @Shadow
    @Final
    private MobEffect effect;
    
    @Shadow
    private int duration;
    
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/effect/MobEffectInstance;tickDownDuration()I", shift = At.Shift.AFTER))
    private void onEffectExpire(LivingEntity livingEntity, Runnable runnable, CallbackInfoReturnable<Boolean> cir) {
        if (this.duration == 0) {
            if (this.effect == ModEffects.HEAT_MARK) {
                HeatMarkEventHandler.onEffectRemoved(livingEntity);
            }
            
            if (this.effect == ModEffects.PHANTOM_ARMOR) {
                PhantomArmorEventHandler.onEffectRemoved(livingEntity);
            }
        }
    }
}
