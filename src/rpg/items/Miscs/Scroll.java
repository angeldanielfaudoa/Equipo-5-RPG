package rpg.items.Miscs;


import rpg.enums.ItemType;
import rpg.items.Item;

import java.io.Serializable;

// Clase para objetos de tipo Pergamino
public class Scroll extends Misc implements Serializable {

    private String spell;
    private int manaCost;

    public Scroll() {
        this.spell = spell;
        this.manaCost = manaCost;
    }

    @Override
    public void use() {

    }

    public String getSpell() {
        return spell;
    }

    public int getManaCost() {
        return manaCost;
    }

    @Override
    public String toString() {
        return super.toString() + " - Spell: " + spell + ", Mana Cost: " + manaCost;
    }

    @Override
    protected void initItem() {
        this.itemType = ItemType.MISC;
        this.name = "Piel de lobo";
        this.description = "Una piel de lobo. Se puede vender por un buen precio.";
        this.price = 50;
        this.consumable = false;
        this.stackable = true;
        this.quantity = 1;

    }
}
