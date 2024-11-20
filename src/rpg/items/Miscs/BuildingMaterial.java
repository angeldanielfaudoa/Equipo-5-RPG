package rpg.items.Miscs;

import rpg.enums.ItemType;
import rpg.items.Item;

import java.io.Serializable;

// Clase para objetos de tipo Material de Construcción
public class BuildingMaterial extends Misc implements Serializable {

    private String materialType;
    private int quantity;

    public String getMaterialType() {
        return materialType;
    }

    @Override
    public void use() {

    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return super.toString() + " - Material Type: " + materialType + ", Quantity: " + quantity;
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