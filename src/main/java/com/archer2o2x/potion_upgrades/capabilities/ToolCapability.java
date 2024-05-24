package com.archer2o2x.potion_upgrades.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;

import java.util.LinkedList;
import java.util.List;

public class ToolCapability {

    private List<String> UPGRADES = new LinkedList<>();
    private int MAX_UPGRADES = 1;

    public boolean addUpgrade(String upgradeName) {
        if (upgradeCount() >= MAX_UPGRADES) return false;
        return UPGRADES.add(upgradeName);
    }

    public boolean removeUpgrade(int index) {
        if (index < 0 && index >= MAX_UPGRADES) return false;
        UPGRADES.remove(index);
        return true;
    }

    public String getUpgrade(int index) {
        if (index < 0 && index >= MAX_UPGRADES) return null;
        return UPGRADES.get(index);
    }

    public int upgradeCount() {
        return UPGRADES.size();
    }

    public void copyFrom(ToolCapability other) {
        UPGRADES = other.UPGRADES;
        MAX_UPGRADES = other.MAX_UPGRADES;
    }

    public void saveNBTData(CompoundTag nbt) {
        ListTag list = new ListTag();

        for (int i = 0; i < UPGRADES.size(); i++) {
            list.add(StringTag.valueOf(UPGRADES.get(i)));
        }

        nbt.put("upgrades", list);
    }

    public void loadNBTData(CompoundTag nbt) {
        ListTag list = (ListTag) nbt.get("upgrades");

        for (int i = 0; i < UPGRADES.size(); i++) {
            UPGRADES.add(list.get(i).getAsString());
        }
    }

}
