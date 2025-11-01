package com.leclowndu93150.rpg_potions.brewing;

import com.leclowndu93150.rpg_potions.init.ModPotions;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public class PotionBrewingRegistry {
    
    public static void registerBrewingRecipes() {
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.CHARCOAL), ModPotions.SMOKE);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.CARVED_PUMPKIN), ModPotions.DECOY);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.TNT), ModPotions.KNOCKBACK);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.OBSIDIAN), ModPotions.PHANTOM_ARMOR);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.SLIME_BALL), ModPotions.PARALYSIS);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.ARROW), ModPotions.PROJECTILE_REBOUND);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.COMPASS), ModPotions.HEAT_MARK);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(Items.INK_SAC), ModPotions.BLACK_STAIN);
    }
}
