package com.leclowndu93150.rpg_potions.event;

import com.leclowndu93150.rpg_potions.init.ModEffects;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.leclowndu93150.rpg_potions.RPGPotions.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class ParalysisEventHandler {
    
    @SubscribeEvent
    public static void onLivingJump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntity().hasEffect(ModEffects.PARALYSIS.get())) {
            event.getEntity().setDeltaMovement(event.getEntity().getDeltaMovement().multiply(1.0, 0.0, 1.0));
        }
    }
}
