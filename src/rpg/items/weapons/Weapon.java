package rpg.items.weapons;

import rpg.enums.WeaponType;
import rpg.enums.ItemType;
import rpg.items.Equipment;

public abstract class Weapon extends Equipment {
    protected WeaponType weaponType;

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void slash() {
        // Implementar lógica de ataque de arma
    }
}

