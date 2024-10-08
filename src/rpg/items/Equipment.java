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

    public Equipment(String name, String description, int price, ItemType itemType, Slot slot, Rarity rarity) {
        super(name, description, price, itemType);
        this.slot = slot;
        this.rarity = rarity;
        this.stats = new HashMap<>();
    }

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
