package rpg.items.Armors;

import rpg.enums.ArmorType;
import rpg.enums.ItemType;
import rpg.enums.Stats;
import rpg.items.Armors.Armor;

import java.util.HashMap;

public class GoldenArmor extends Armor {

    @Override
    protected void initItem() {
        armorType= ArmorType.HELMET;
        name = "Casco de madera";
        description = "Un casco de madera. No es muy resistente, pero es mejor que nada.";
        price = 10;
        stats = new HashMap<>();
        stats.put(Stats.DEFENSE, 2);
    }
    /**
     * Protect.
     */
    public void protect() {
        System.out.println("El casco de madera te protege de un golpe y se rompe.");
    }
}
