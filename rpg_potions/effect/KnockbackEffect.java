package com.leclowndu93150.rpg_potions.effect;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class KnockbackEffect extends MobEffect {
    public KnockbackEffect() {
        super(MobEffectCategory.HARMFUL, 0xFF4400);
    }
    
    @Override
    public boolean isInstantenous() {
        return true;
    }
    
    @Override
    public void applyInstantenousEffect(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity entity, int amplifier, double health) {
        if (!entity.level().isClientSide) {
            double strength = PotionConfig.KNOCKBACK_STRENGTH.get();
            double verticalMultiplier = PotionConfig.KNOCKBACK_VERTICAL_MULTIPLIER.get();
            
            Vec3 lookAngle = entity.getLookAngle().normalize();
            Vec3 knockback = new Vec3(
                -lookAngle.x * strength,
                verticalMultiplier * strength,
                -lookAngle.z * strength
            );
            
            entity.setDeltaMovement(entity.getDeltaMovement().add(knockback));
            entity.hurtMarked = true;
        }
    }
}
