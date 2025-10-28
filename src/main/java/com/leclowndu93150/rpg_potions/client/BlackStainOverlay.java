package com.leclowndu93150.rpg_potions.client;

import com.leclowndu93150.rpg_potions.RPGPotions;
import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;

@EventBusSubscriber(modid = RPGPotions.MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class BlackStainOverlay {
    
    @SubscribeEvent
    public static void onRenderGui(RenderGuiLayerEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        
        if (player != null && player.hasEffect(ModEffects.BLACK_STAIN)) {
            GuiGraphics guiGraphics = event.getGuiGraphics();
            int screenWidth = mc.getWindow().getGuiScaledWidth();
            int screenHeight = mc.getWindow().getGuiScaledHeight();
            
            int intensity = PotionConfig.BLACK_STAIN_INTENSITY.get();
            float alpha = intensity / 100.0f;
            int darkColor = (int)(alpha * 255) << 24;
            guiGraphics.fill(0, 0, screenWidth, screenHeight, darkColor);
        }
    }
}
