package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RPGPotions.MODID);
    
    public static final RegistryObject<CreativeModeTab> RPG_POTIONS_TAB = CREATIVE_MODE_TABS.register("rpg_potions_tab",
            () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.rpg_potions"))
                .icon(() -> PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.SMOKE.get()))
                .displayItems((parameters, output) -> {
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.SMOKE.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.SMOKE.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.SMOKE.get()));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.DECOY.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.DECOY.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.DECOY.get()));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.KNOCKBACK.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.KNOCKBACK.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.KNOCKBACK.get()));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.PHANTOM_ARMOR.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.PHANTOM_ARMOR.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.PHANTOM_ARMOR.get()));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.PARALYSIS.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.PARALYSIS.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.PARALYSIS.get()));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.PROJECTILE_REBOUND.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.PROJECTILE_REBOUND.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.PROJECTILE_REBOUND.get()));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.HEAT_MARK.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.HEAT_MARK.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.HEAT_MARK.get()));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.BLACK_STAIN.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.BLACK_STAIN.get()));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.BLACK_STAIN.get()));
                })
                .build());
}
