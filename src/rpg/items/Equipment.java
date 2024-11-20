package rpg.items;


import rpg.enums.Rarity;
import rpg.enums.Slot;
import rpg.enums.ItemType;
import rpg.enums.Stats;
import rpg.interfaces.Equipable;

import java.util.HashMap;

public abstract class Equipment extends Item implements Equipable {
    protected Slot slot;
    protected Rarity rarity;
    protected HashMap<Stats, Integer> stats;

    @Override
    public void equip() {
        // Implementar lógica de equipamiento
    }

    @Override
    public void unequip() {
        // Implementar lógica de desequipamiento
    }

    public Slot getSlot() {
        return slot;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}
