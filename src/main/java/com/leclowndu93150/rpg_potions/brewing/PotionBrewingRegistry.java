package com.leclowndu93150.rpg_potions.brewing;

import com.leclowndu93150.rpg_potions.init.ModPotions;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

import static com.leclowndu93150.rpg_potions.RPGPotions.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
public class PotionBrewingRegistry {
    
    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        var builder = event.getBuilder();
        
        builder.addMix(Potions.AWKWARD, Items.CHARCOAL, ModPotions.SMOKE.getDelegate());
        builder.addMix(Potions.AWKWARD, Items.CARVED_PUMPKIN, ModPotions.DECOY.getDelegate());
        builder.addMix(Potions.AWKWARD, Items.TNT, ModPotions.KNOCKBACK.getDelegate());
        builder.addMix(Potions.AWKWARD, Items.OBSIDIAN, ModPotions.PHANTOM_ARMOR.getDelegate());
        builder.addMix(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.PARALYSIS.getDelegate());
        builder.addMix(Potions.AWKWARD, Items.ARROW, ModPotions.PROJECTILE_REBOUND.getDelegate());
        builder.addMix(Potions.AWKWARD, Items.COMPASS, ModPotions.HEAT_MARK.getDelegate());
        builder.addMix(Potions.AWKWARD, Items.INK_SAC, ModPotions.BLACK_STAIN.getDelegate());
    }
}
