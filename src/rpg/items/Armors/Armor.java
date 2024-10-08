package rpg.items.Armors;


import rpg.enums.ArmorType;
import rpg.enums.Slot;
import rpg.enums.Rarity;
import rpg.enums.ItemType;
import rpg.items.Equipment;

public class Armor extends Equipment {
    private ArmorType armorType;

    public Armor(String name, String description, int price, ArmorType armorType, Slot slot, Rarity rarity) {
        super(name, description, price, ItemType.ARMOR, slot, rarity);
        this.armorType = armorType;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void protect() {
        // Implementar lógica de protección de la armadura
    }
}
