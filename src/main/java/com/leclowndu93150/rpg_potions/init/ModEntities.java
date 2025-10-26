package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import com.leclowndu93150.rpg_potions.entity.DecoyEntity;
import com.leclowndu93150.rpg_potions.entity.SmokeEmitterEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, RPGPotions.MODID);
    
    public static final DeferredHolder<EntityType<?>, EntityType<DecoyEntity>> DECOY = ENTITY_TYPES.register("decoy",
            () -> EntityType.Builder.<DecoyEntity>of((entityType, level) -> new DecoyEntity(entityType, level), MobCategory.MISC)
                    .sized(0.6F, 1.8F)
                    .clientTrackingRange(8)
                    .build("decoy"));
    
    public static final DeferredHolder<EntityType<?>, EntityType<SmokeEmitterEntity>> SMOKE_EMITTER = ENTITY_TYPES.register("smoke_emitter",
            () -> EntityType.Builder.<SmokeEmitterEntity>of((entityType, level) -> new SmokeEmitterEntity(entityType, level), MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(10)
                    .updateInterval(10)
                    .build("smoke_emitter"));
    
    @EventBusSubscriber(modid = RPGPotions.MODID, bus = EventBusSubscriber.Bus.MOD)
    public static class EntityAttributeRegistry {
        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(DECOY.get(), DecoyEntity.createAttributes().build());
        }
    }
}
