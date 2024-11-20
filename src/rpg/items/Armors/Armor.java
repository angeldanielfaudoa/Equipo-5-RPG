package rpg.items.Armors;


import rpg.enums.ArmorType;
import rpg.items.Equipment;

public abstract class Armor extends Equipment {
    protected ArmorType armorType;

    public ArmorType getArmorType() {
        return armorType;
    }

    public void protect() {
        // Implementar lógica de protección de la armadura
    }
}
