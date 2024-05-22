package com.archer2o2x.potion_upgrades.datagen;

import com.archer2o2x.potion_upgrades.items.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.NbtPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RepairItemRecipe;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.level.block.StructureBlock;
import net.minecraftforge.common.crafting.PartialNBTIngredient;
import net.minecraftforge.common.crafting.StrictNBTIngredient;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ModRecipes extends RecipeProvider {

    public ModRecipes(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipe) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.EMPTY_POTION_UPGRADE.get())
                .pattern("dnd")
                .pattern("n n")
                .pattern("dnd")
                .define('d', Items.DIAMOND)
                .define('n', Items.NETHERRACK)
                .unlockedBy("has_netherrack", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERRACK))
                .save(recipe);

        CompoundTag STRENGTH_POTION_NBT = new CompoundTag();
        STRENGTH_POTION_NBT.putString("Potion", "minecraft:strong_strength");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STRENGTH_POTION_UPGRADE.get())
                .pattern("ppp")
                .pattern("pup")
                .pattern("ppp")
                .define('p', PartialNBTIngredient.of(STRENGTH_POTION_NBT, Items.POTION))
                .define('u', ModItems.EMPTY_POTION_UPGRADE.get())
                .unlockedBy("has_netherrack", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERRACK))
                .save(recipe);



        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ModItems.STRENGTH_POTION_UPGRADE.get()),
                Ingredient.of(Items.DIAMOND_AXE),
                Ingredient.of(Items.PAPER),
                RecipeCategory.TOOLS,
                Items.DIAMOND_AXE
        );

    }

}
