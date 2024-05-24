package com.archer2o2x.potion_upgrades.items;

import com.archer2o2x.potion_upgrades.PotionUpgrades;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.Color;
import java.util.HashMap;
import java.util.function.Supplier;

public class ModItems {

    public static HashMap<ResourceLocation, Color> ITEM_COLOURS = new HashMap<>();
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PotionUpgrades.MODID);

    public static RegistryObject<Item> EMPTY_POTION_UPGRADE = register("empty_potion_upgrade", new Color(55, 20, 20),
            () -> new Item(new Item.Properties()));

    public static RegistryObject<Item> FILLED_POTION_UPGRADE = register("filled_potion_upgrade", new Color(96, 232, 232),
            () -> new Item(new Item.Properties()));



    public static RegistryObject<Item> STRENGTH_POTION_UPGRADE = register("strength_potion_upgrade", new Color(255, 70, 70),
            () -> new Item(new Item.Properties()));





    public static RegistryObject<Item> register(String name, Color color, Supplier<Item> item) {
        ITEM_COLOURS.put(new ResourceLocation(PotionUpgrades.MODID, name), color);
        return ITEMS.register(name, item);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
