package com.leclowndu93150.rpg_potions.client;

import com.leclowndu93150.rpg_potions.RPGPotions;
import com.leclowndu93150.rpg_potions.config.PotionConfig;
import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RPGPotions.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class BlackStainOverlay {
    
    @SubscribeEvent
    public static void onRenderGui(RenderGuiOverlayEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        
        if (player != null && player.hasEffect(ModEffects.BLACK_STAIN.get())) {
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
