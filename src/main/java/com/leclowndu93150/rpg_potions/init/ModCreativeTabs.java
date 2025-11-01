package com.leclowndu93150.rpg_potions.init;

import com.leclowndu93150.rpg_potions.RPGPotions;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;

public class ModCreativeTabs {
    public static final CreativeModeTab RPG_POTIONS_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(RPGPotions.MODID, "rpg_potions_tab"),
            FabricItemGroup.builder()
                .title(Component.translatable("itemGroup.rpg_potions"))
                .icon(() -> PotionContents.createItemStack(Items.POTION, getHolder(ModPotions.SMOKE)))
                .displayItems((parameters, output) -> {
                    output.accept(PotionContents.createItemStack(Items.POTION, getHolder(ModPotions.SMOKE)));
                    output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, getHolder(ModPotions.SMOKE)));
                    output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, getHolder(ModPotions.SMOKE)));
                    
                    output.accept(PotionContents.createItemStack(Items.POTION, getHolder(ModPotions.DECOY)));
                    output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, getHolder(ModPotions.DECOY)));
                    output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, getHolder(ModPotions.DECOY)));
                    
                    output.accept(PotionContents.createItemStack(Items.POTION, getHolder(ModPotions.KNOCKBACK)));
                    output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, getHolder(ModPotions.KNOCKBACK)));
                    output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, getHolder(ModPotions.KNOCKBACK)));
                    
                    output.accept(PotionContents.createItemStack(Items.POTION, getHolder(ModPotions.PHANTOM_ARMOR)));
                    output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, getHolder(ModPotions.PHANTOM_ARMOR)));
                    output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, getHolder(ModPotions.PHANTOM_ARMOR)));
                    
                    output.accept(PotionContents.createItemStack(Items.POTION, getHolder(ModPotions.PARALYSIS)));
                    output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, getHolder(ModPotions.PARALYSIS)));
                    output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, getHolder(ModPotions.PARALYSIS)));
                    
                    output.accept(PotionContents.createItemStack(Items.POTION, getHolder(ModPotions.PROJECTILE_REBOUND)));
                    output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, getHolder(ModPotions.PROJECTILE_REBOUND)));
                    output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, getHolder(ModPotions.PROJECTILE_REBOUND)));
                    
                    output.accept(PotionContents.createItemStack(Items.POTION, getHolder(ModPotions.HEAT_MARK)));
                    output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, getHolder(ModPotions.HEAT_MARK)));
                    output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, getHolder(ModPotions.HEAT_MARK)));
                    
                    output.accept(PotionContents.createItemStack(Items.POTION, getHolder(ModPotions.BLACK_STAIN)));
                    output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, getHolder(ModPotions.BLACK_STAIN)));
                    output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, getHolder(ModPotions.BLACK_STAIN)));
                })
                .build()
    );
    
    private static Holder<Potion> getHolder(Potion potion) {
        return BuiltInRegistries.POTION.wrapAsHolder(potion);
    }

    public static void register() {
        RPGPotions.LOGGER.info("Registering creative tabs for " + RPGPotions.MODID);
    }
}
