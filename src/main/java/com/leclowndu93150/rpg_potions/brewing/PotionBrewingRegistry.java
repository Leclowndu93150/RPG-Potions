package com.leclowndu93150.rpg_potions.brewing;

import com.leclowndu93150.rpg_potions.init.ModPotions;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public class PotionBrewingRegistry {
    
    public static void registerBrewingRecipes() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.CHARCOAL), getHolder(ModPotions.SMOKE));
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.CARVED_PUMPKIN), getHolder(ModPotions.DECOY));
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.TNT), getHolder(ModPotions.KNOCKBACK));
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.OBSIDIAN), getHolder(ModPotions.PHANTOM_ARMOR));
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.SLIME_BALL), getHolder(ModPotions.PARALYSIS));
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.ARROW), getHolder(ModPotions.PROJECTILE_REBOUND));
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.COMPASS), getHolder(ModPotions.HEAT_MARK));
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.INK_SAC), getHolder(ModPotions.BLACK_STAIN));
        });
    }
    
    private static Holder<Potion> getHolder(Potion potion) {
        return BuiltInRegistries.POTION.wrapAsHolder(potion);
    }
}
