package com.archer2o2x.potion_upgrades.creative_tab;

import com.archer2o2x.potion_upgrades.PotionUpgrades;
import com.archer2o2x.potion_upgrades.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {

    public static DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PotionUpgrades.MODID);

    public static RegistryObject<CreativeModeTab> MOD_TAB = TABS.register("creative_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FILLED_POTION_UPGRADE.get()))
                    .title(Component.translatable("creative_tab.name"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.EMPTY_POTION_UPGRADE.get());
                        pOutput.accept(ModItems.STRENGTH_POTION_UPGRADE.get());

                    }).build());


    public static void register(IEventBus bus) { TABS.register(bus); }


}
