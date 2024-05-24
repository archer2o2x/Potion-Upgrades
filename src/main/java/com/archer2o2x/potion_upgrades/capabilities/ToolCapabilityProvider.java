package com.archer2o2x.potion_upgrades.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToLongBiFunction;

public class ToolCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<ToolCapability> TOOL_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() { });

    private ToolCapability toolCapability = null;

    private final LazyOptional<ToolCapability> optional = LazyOptional.of(this::createToolCapability);

    private ToolCapability createToolCapability() {
        if (this.toolCapability != null) return this.toolCapability;
        this.toolCapability = new ToolCapability();
        return this.toolCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == TOOL_CAPABILITY) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createToolCapability().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createToolCapability().loadNBTData(nbt);
    }
}
