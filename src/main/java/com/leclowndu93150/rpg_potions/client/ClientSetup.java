package com.leclowndu93150.rpg_potions.client;

import com.leclowndu93150.rpg_potions.RPGPotions;
import com.leclowndu93150.rpg_potions.client.renderer.DecoyRenderer;
import com.leclowndu93150.rpg_potions.init.ModEntities;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RPGPotions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.DECOY.get(), DecoyRenderer::new);
        event.registerEntityRenderer(ModEntities.SMOKE_EMITTER.get(), NoopRenderer::new);
    }
}
