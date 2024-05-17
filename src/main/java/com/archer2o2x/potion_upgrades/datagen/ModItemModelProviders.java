package com.archer2o2x.potion_upgrades.datagen;

import com.archer2o2x.potion_upgrades.PotionUpgrades;
import com.archer2o2x.potion_upgrades.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProviders extends ItemModelProvider {
    public ModItemModelProviders(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PotionUpgrades.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItemWithCutout(ModItems.EMPTY_POTION_UPGRADE, "filled_potion_upgrade", "cutout_potion_upgrade");
        simpleItemWithCutout(ModItems.FILLED_POTION_UPGRADE, "filled_potion_upgrade", "cutout_potion_upgrade");
        simpleItemWithCutout(ModItems.STRENGTH_POTION_UPGRADE, "filled_potion_upgrade", "cutout_potion_upgrade");

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return simpleItem(item, item.getId());
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item, ResourceLocation path) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PotionUpgrades.MODID,"item/" + path.getPath()));
    }

    private ItemModelBuilder simpleItemWithCutout(RegistryObject<Item> item, String path, String cutout) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(PotionUpgrades.MODID,"item/" + path))
                .texture("layer1", new ResourceLocation(PotionUpgrades.MODID, "item/" + cutout));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PotionUpgrades.MODID, "block/" + item.getId().getPath()));
    }
}
