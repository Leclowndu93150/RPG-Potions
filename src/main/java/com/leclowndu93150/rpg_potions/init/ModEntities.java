package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import com.leclowndu93150.rpg_potions.entity.DecoyEntity;
import com.leclowndu93150.rpg_potions.entity.SmokeEmitterEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RPGPotions.MODID);
    
    public static final RegistryObject<EntityType<DecoyEntity>> DECOY = ENTITY_TYPES.register("decoy",
            () -> EntityType.Builder.<DecoyEntity>of((entityType, level) -> new DecoyEntity(entityType, level), MobCategory.MISC)
                    .sized(0.6F, 1.8F)
                    .clientTrackingRange(8)
                    .build("decoy"));
    
    public static final RegistryObject<EntityType<SmokeEmitterEntity>> SMOKE_EMITTER = ENTITY_TYPES.register("smoke_emitter",
            () -> EntityType.Builder.<SmokeEmitterEntity>of((entityType, level) -> new SmokeEmitterEntity(entityType, level), MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(10)
                    .updateInterval(10)
                    .build("smoke_emitter"));
    
    @Mod.EventBusSubscriber(modid = RPGPotions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class EntityAttributeRegistry {
        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(DECOY.get(), DecoyEntity.createAttributes().build());
        }
    }
}
