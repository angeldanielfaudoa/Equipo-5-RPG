package rpg.items.Miscs;

import rpg.enums.ItemType;
import rpg.items.Item;

import java.io.Serializable;

// Clase para objetos de tipo Libro
public class Book extends Misc implements Serializable {

    @Override
    public void initItem(){
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

    }
}
