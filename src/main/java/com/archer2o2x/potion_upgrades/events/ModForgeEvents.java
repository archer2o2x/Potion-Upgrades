package com.archer2o2x.potion_upgrades.events;

import com.archer2o2x.potion_upgrades.PotionUpgrades;
import com.archer2o2x.potion_upgrades.capabilities.ToolCapability;
import com.archer2o2x.potion_upgrades.capabilities.ToolCapabilityProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

@Mod.EventBusSubscriber(modid = PotionUpgrades.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModForgeEvents {

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) { event.register(ToolCapability.class); }

    @SubscribeEvent
    public static void onAttachCapabilitiesItemStack(AttachCapabilitiesEvent<Entity> event) {
        if (!event.getObject().getCapability(ToolCapabilityProvider.TOOL_CAPABILITY).isPresent()) {
            event.addCapability(new ResourceLocation(PotionUpgrades.MODID, "properties"), new ToolCapabilityProvider());
        }
    }

}
