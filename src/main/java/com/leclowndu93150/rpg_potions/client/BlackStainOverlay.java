package com.leclowndu93150.rpg_potions.client;

import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

public class BlackStainOverlay implements HudRenderCallback {
    
    @Override
    public void onHudRender(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        
        if (player != null && player.hasEffect(ModEffects.BLACK_STAIN)) {
            int screenWidth = mc.getWindow().getGuiScaledWidth();
            int screenHeight = mc.getWindow().getGuiScaledHeight();
            
            int intensity = PotionConfig.BLACK_STAIN_INTENSITY;
            float alpha = (100 - intensity) / 100.0f;
            int darkColor = ((int)(alpha * 255) << 24);
            guiGraphics.fill(0, 0, screenWidth, screenHeight, darkColor);
        }
    }
}
