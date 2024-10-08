package rpg.inventory;

import rpg.items.*;
import rpg.items.Armors.Armor;
import rpg.items.Item;
import rpg.items.Misc;
import rpg.items.weapons.Weapon;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (!isFull()) {
            items.add(item);
        } else {
            System.out.println("El inventario está lleno.");
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public int getItemCount() {
        return items.size();
    }

    public boolean isFull() {
        return items.size() >= capacity;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public void increaseCapacity(int amount) {
        capacity += amount;
    }

    public ArrayList<Armor> listArmors() {
        ArrayList<Armor> armors = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Armor) {
                armors.add((Armor) item);
            }
        }
        return armors;
    }

    public ArrayList<Weapon> listWeapons() {
        ArrayList<Weapon> weapons = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Weapon) {
                weapons.add((Weapon) item);
            }
        }
        return weapons;
    }

    public ArrayList<Misc> listMisc() {
        ArrayList<Misc> miscItems = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Misc) {
                miscItems.add((Misc) item);
            }
        }
        return miscItems;
    }
}