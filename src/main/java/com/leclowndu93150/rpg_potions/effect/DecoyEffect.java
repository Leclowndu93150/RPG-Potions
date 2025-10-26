package com.leclowndu93150.rpg_potions.effect;

import com.leclowndu93150.rpg_potions.entity.DecoyEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;

public class DecoyEffect extends MobEffect {
    public DecoyEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFFAA00);
    }
    
    @Override
    public boolean isInstantenous() {
        return true;
    }
    
    @Override
    public void applyInstantenousEffect(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity entity, int amplifier, double health) {
        if (!entity.level().isClientSide && entity instanceof Player player) {
            DecoyEntity decoy = new DecoyEntity(entity.level(), player);
            decoy.setPos(player.getX(), player.getY(), player.getZ());
            entity.level().addFreshEntity(decoy);
        }
    }
}
