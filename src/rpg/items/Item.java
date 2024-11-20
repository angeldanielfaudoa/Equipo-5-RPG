package rpg.items;

import rpg.enums.ItemType;

import java.io.Serializable;

public abstract class Item implements Serializable {
    protected String name;
    protected String description;
    protected int price;
    protected ItemType itemType;

    public Item() {
        initItem();
    }

    protected abstract void initItem();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
