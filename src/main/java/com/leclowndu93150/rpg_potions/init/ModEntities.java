package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import com.leclowndu93150.rpg_potions.entity.DecoyEntity;
import com.leclowndu93150.rpg_potions.entity.SmokeEmitterEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static final EntityType<DecoyEntity> DECOY = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            ResourceLocation.fromNamespaceAndPath(RPGPotions.MODID, "decoy"),
            FabricEntityTypeBuilder.<DecoyEntity>create(MobCategory.MISC, (type, level) -> new DecoyEntity(type, level))
                    .dimensions(EntityDimensions.fixed(0.6F, 1.8F))
                    .trackRangeChunks(8)
                    .build()
    );
    
    public static final EntityType<SmokeEmitterEntity> SMOKE_EMITTER = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            ResourceLocation.fromNamespaceAndPath(RPGPotions.MODID, "smoke_emitter"),
            FabricEntityTypeBuilder.<SmokeEmitterEntity>create(MobCategory.MISC, (type, level) -> new SmokeEmitterEntity(type, level))
                    .dimensions(EntityDimensions.fixed(0.5F, 0.5F))
                    .trackRangeChunks(10)
                    .build()
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(DECOY, DecoyEntity.createAttributes());
        RPGPotions.LOGGER.info("Registering entities for " + RPGPotions.MODID);
    }
}
