package com.leclowndu93150.rpg_potions.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class RPGPotionsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientSetup.registerEntityRenderers();
        HudRenderCallback.EVENT.register(new BlackStainOverlay());
    }
}
