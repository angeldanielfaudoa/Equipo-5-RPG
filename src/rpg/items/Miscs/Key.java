package rpg.items.Miscs;

import rpg.enums.ItemType;
import rpg.items.Item;

import java.io.Serializable;

// Clase para objetos de tipo Llave
public class Key extends Misc implements Serializable {

    private String doorId;

    public Key(){
        this.doorId = doorId;
    }

    public String getDoorId() {
        return doorId;
    }

    @Override
    public String toString() {
        return super.toString() + " - Unlocks Door ID: " + doorId;
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

    @Override
    public void use() {

    }
}
