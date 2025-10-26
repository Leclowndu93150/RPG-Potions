package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RPGPotions.MODID);
    
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RPG_POTIONS_TAB = 
            CREATIVE_MODE_TABS.register("rpg_potions_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.rpg_potions"))
                    .icon(() -> PotionContents.createItemStack(Items.POTION, ModPotions.SMOKE.getDelegate()))
                    .displayItems((parameters, output) -> {
                        output.accept(PotionContents.createItemStack(Items.POTION, ModPotions.SMOKE.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.SMOKE.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, ModPotions.SMOKE.getDelegate()));
                        
                        output.accept(PotionContents.createItemStack(Items.POTION, ModPotions.DECOY.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.DECOY.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, ModPotions.DECOY.getDelegate()));
                        
                        output.accept(PotionContents.createItemStack(Items.POTION, ModPotions.KNOCKBACK.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.KNOCKBACK.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, ModPotions.KNOCKBACK.getDelegate()));
                        
                        output.accept(PotionContents.createItemStack(Items.POTION, ModPotions.PHANTOM_ARMOR.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.PHANTOM_ARMOR.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, ModPotions.PHANTOM_ARMOR.getDelegate()));
                        
                        output.accept(PotionContents.createItemStack(Items.POTION, ModPotions.PARALYSIS.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.PARALYSIS.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, ModPotions.PARALYSIS.getDelegate()));
                        
                        output.accept(PotionContents.createItemStack(Items.POTION, ModPotions.PROJECTILE_REBOUND.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.PROJECTILE_REBOUND.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, ModPotions.PROJECTILE_REBOUND.getDelegate()));
                        
                        output.accept(PotionContents.createItemStack(Items.POTION, ModPotions.HEAT_MARK.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.HEAT_MARK.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, ModPotions.HEAT_MARK.getDelegate()));
                        
                        output.accept(PotionContents.createItemStack(Items.POTION, ModPotions.BLACK_STAIN.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.BLACK_STAIN.getDelegate()));
                        output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, ModPotions.BLACK_STAIN.getDelegate()));
                        
                        output.accept(ModItems.DECOY_SPAWN_EGG.get());
                    })
                    .build());
}
