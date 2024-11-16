package rpg.items.weapons;

import rpg.enums.WeaponType;
import rpg.enums.ItemType;
import rpg.items.Equipment;

public class Weapon extends Equipment {
    private WeaponType weaponType;

    public Weapon(String name, String description, int price, WeaponType weaponType) {
        super(name, description, price, ItemType.WEAPON, slot, rarity);
        this.weaponType = weaponType;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void slash() {
        // Implementar lógica de ataque de arma
    }
}

