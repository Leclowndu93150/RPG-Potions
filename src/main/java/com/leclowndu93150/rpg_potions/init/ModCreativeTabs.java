package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;

public class ModCreativeTabs {
    public static final CreativeModeTab RPG_POTIONS_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(RPGPotions.MODID, "rpg_potions_tab"),
            FabricItemGroup.builder()
                .title(Component.translatable("itemGroup.rpg_potions"))
                .icon(() -> PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.SMOKE))
                .displayItems((parameters, output) -> {
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.SMOKE));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.SMOKE));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.SMOKE));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.DECOY));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.DECOY));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.DECOY));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.KNOCKBACK));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.KNOCKBACK));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.KNOCKBACK));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.PHANTOM_ARMOR));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.PHANTOM_ARMOR));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.PHANTOM_ARMOR));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.PARALYSIS));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.PARALYSIS));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.PARALYSIS));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.PROJECTILE_REBOUND));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.PROJECTILE_REBOUND));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.PROJECTILE_REBOUND));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.HEAT_MARK));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.HEAT_MARK));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.HEAT_MARK));
                    
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.BLACK_STAIN));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), ModPotions.BLACK_STAIN));
                    output.accept(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), ModPotions.BLACK_STAIN));
                })
                .build()
    );

    public static void register() {
        RPGPotions.LOGGER.info("Registering creative tabs for " + RPGPotions.MODID);
    }
}
