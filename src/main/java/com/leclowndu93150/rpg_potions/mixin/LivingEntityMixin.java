package com.leclowndu93150.rpg_potions.mixin;

import com.leclowndu93150.rpg_potions.event.HeatMarkEventHandler;
import com.leclowndu93150.rpg_potions.event.PhantomArmorEventHandler;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements com.leclowndu93150.rpg_potions.access.LivingEntityAccess {
    
    @Unique
    private CompoundTag rpg_potions$persistentData = new CompoundTag();
    
    @Override
    public CompoundTag rpg_potions$getPersistentData() {
        return rpg_potions$persistentData;
    }
    
    @Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z", at = @At("RETURN"))
    private void onEffectAdded(MobEffectInstance effectInstance, Entity source, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            LivingEntity self = (LivingEntity)(Object)this;
            
            if (effectInstance.getEffect() == ModEffects.HEAT_MARK && source instanceof LivingEntity livingSource) {
                HeatMarkEventHandler.onEffectAdded(self, livingSource);
            }
            
            if (effectInstance.getEffect() == ModEffects.PHANTOM_ARMOR) {
                PhantomArmorEventHandler.onEffectAdded(self);
            }
        }
    }
    
    
    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void onHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity)(Object)this;
        
        if (PhantomArmorEventHandler.shouldCancelDamage(self, amount)) {
            cir.setReturnValue(false);
        }
    }
    
    @ModifyVariable(method = "hurt", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private float modifyDamage(float amount, DamageSource source) {
        LivingEntity self = (LivingEntity)(Object)this;
        
        if (source.getEntity() instanceof LivingEntity attacker) {
            return HeatMarkEventHandler.modifyDamage(self, attacker, amount);
        }
        
        return amount;
    }
    
    @Inject(method = "jumpFromGround", at = @At("HEAD"), cancellable = true)
    private void onJump(CallbackInfo ci) {
        LivingEntity self = (LivingEntity)(Object)this;
        
        if (self.hasEffect(ModEffects.PARALYSIS)) {
            ci.cancel();
        }
    }
    
    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void saveCustomData(CompoundTag tag, CallbackInfo ci) {
        tag.put("rpg_potions_data", rpg_potions$persistentData);
    }
    
    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void loadCustomData(CompoundTag tag, CallbackInfo ci) {
        if (tag.contains("rpg_potions_data")) {
            rpg_potions$persistentData = tag.getCompound("rpg_potions_data");
        }
    }
}
