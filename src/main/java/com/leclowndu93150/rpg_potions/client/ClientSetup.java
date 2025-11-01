package com.leclowndu93150.rpg_potions.client;

import com.leclowndu93150.rpg_potions.client.renderer.DecoyRenderer;
import com.leclowndu93150.rpg_potions.init.ModEntities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.entity.NoopRenderer;

public class ClientSetup {
    
    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(ModEntities.DECOY, DecoyRenderer::new);
        EntityRendererRegistry.register(ModEntities.SMOKE_EMITTER, NoopRenderer::new);
    }
}
