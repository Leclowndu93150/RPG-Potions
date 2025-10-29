package com.leclowndu93150.rpg_potions.brewing;

import com.leclowndu93150.rpg_potions.init.ModPotions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static com.leclowndu93150.rpg_potions.RPGPotions.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotionBrewingRegistry {
    
    @SubscribeEvent
    public static void registerBrewingRecipes(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                Ingredient.of(Items.CHARCOAL),
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.SMOKE.get())
            );
            BrewingRecipeRegistry.addRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                Ingredient.of(Items.CARVED_PUMPKIN),
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.DECOY.get())
            );
            BrewingRecipeRegistry.addRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                Ingredient.of(Items.TNT),
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.KNOCKBACK.get())
            );
            BrewingRecipeRegistry.addRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                Ingredient.of(Items.OBSIDIAN),
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.PHANTOM_ARMOR.get())
            );
            BrewingRecipeRegistry.addRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                Ingredient.of(Items.SLIME_BALL),
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.PARALYSIS.get())
            );
            BrewingRecipeRegistry.addRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                Ingredient.of(Items.ARROW),
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.PROJECTILE_REBOUND.get())
            );
            BrewingRecipeRegistry.addRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                Ingredient.of(Items.COMPASS),
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.HEAT_MARK.get())
            );
            BrewingRecipeRegistry.addRecipe(
                Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD)),
                Ingredient.of(Items.INK_SAC),
                PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.BLACK_STAIN.get())
            );
        });
    }
}
