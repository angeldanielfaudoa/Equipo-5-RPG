package rpg.items.Miscs;

import rpg.enums.ItemType;
import rpg.items.Miscs.Misc;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.io.Serializable;

/**
 * The type Wolf pelt.
 */
public class WolfPelt extends Misc implements Serializable {

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

    @Override
    public void use() {
        System.out.println("No puedes usar una piel de lobo.");
    }
}