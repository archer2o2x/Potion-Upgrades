package com.archer2o2x.potion_upgrades.datagen;

import com.archer2o2x.potion_upgrades.PotionUpgrades;
import com.archer2o2x.potion_upgrades.items.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = PotionUpgrades.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new ModItemModelProviders(packOutput, existingFileHelper));

    }

    @SubscribeEvent
    public static void registerItemColours(RegisterColorHandlersEvent.Item event) {

        event.register((itemStack, tintIndex) -> {
            if (tintIndex != 1) return Integer.MAX_VALUE;//255 << 24 + 255 << 16 + 255 << 8 + 255;

            Color color = ModItems.ITEM_COLOURS.getOrDefault(new ResourceLocation(PotionUpgrades.MODID, itemStack.getItem().toString()), null);

            if (color == null) return Integer.MAX_VALUE;//255 << 24 + 255 << 16 + 255 << 8 + 255;

            return (255 << 24) +
                    (color.getRed() << 16) +
                    (color.getGreen() << 8) +
                    color.getBlue();
        },
                ModItems.EMPTY_POTION_UPGRADE.get(),
                ModItems.FILLED_POTION_UPGRADE.get(),
                ModItems.STRENGTH_POTION_UPGRADE.get()
        );

    }

}
