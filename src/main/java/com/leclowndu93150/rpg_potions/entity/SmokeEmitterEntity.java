package com.leclowndu93150.rpg_potions.entity;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEntities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class SmokeEmitterEntity extends Entity {
    private int lifeTicks = 0;
    private int duration;
    
    public SmokeEmitterEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }
    
    public SmokeEmitterEntity(Level level, double x, double y, double z, int duration) {
        super(ModEntities.SMOKE_EMITTER, level);
        this.setPos(x, y, z);
        this.duration = duration;
    }
    
    @Override
    protected void defineSynchedData() {
    }
    
    @Override
    public void tick() {
        super.tick();
        
        if (this.level() instanceof ServerLevel serverLevel) {
            int radius = PotionConfig.SMOKE_RADIUS;
            int density = PotionConfig.SMOKE_PARTICLE_DENSITY;
            
            for (int i = 0; i < density; i++) {
                double theta = this.random.nextDouble() * 2 * Math.PI;
                double phi = Math.acos(2 * this.random.nextDouble() - 1);
                double r = Math.cbrt(this.random.nextDouble()) * radius;
                
                double offsetX = r * Math.sin(phi) * Math.cos(theta);
                double offsetY = r * Math.sin(phi) * Math.sin(theta);
                double offsetZ = r * Math.cos(phi);
                
                serverLevel.sendParticles(
                    ParticleTypes.CAMPFIRE_COSY_SMOKE,
                    this.getX() + offsetX,
                    this.getY() + offsetY,
                    this.getZ() + offsetZ,
                    1,
                    0.0, 0.05, 0.0,
                    0.005
                );
            }
        }
        
        lifeTicks++;
        if (lifeTicks >= duration) {
            this.discard();
        }
    }
    
    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        this.lifeTicks = compound.getInt("LifeTicks");
        this.duration = compound.getInt("Duration");
    }
    
    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("LifeTicks", this.lifeTicks);
        compound.putInt("Duration", this.duration);
    }
}
