package rpg.entities;

import rpg.entities.enemies.Enemy;
import rpg.enums.Stats;
import rpg.exceptions.ItemNotFoundException;
import rpg.inventory.Inventory;
import rpg.items.Item;
import rpg.items.Miscs.Misc;
import rpg.utils.cache.Randomized;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;

public class Player extends GameCharacter implements Serializable {
    private String name;
    private int defenseBonus = 0; // Campo para almacenar el bono de defensa
    private HashMap<Stats, Integer> stats;

    public void save(int slot) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("files/save" + slot + ".dat"));
            out.writeObject(this);
            out.close();
            System.out.println("Game saved");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving the game");
        }
    }

    public static Player load(int slot) {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream
                    ("files/save" + slot + ".dat"));
            Player player = (Player) in.readObject();
            in.close();
            return player;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error loading the game");
        }
        return null;
    }

    public int getLife() {
        return this.stats.get(Stats.HP);
    }

    // Usar una poción para aumentar la vida
    public void usePotion(int extraLife) {
        int currentHP = this.stats.get(Stats.HP); // Obtener el valor actual de HP
        this.stats.put(Stats.HP, currentHP + extraLife); // Actualizar el valor de HP en el mapa
        System.out.println(this.name + " usa una poción. Vida adicional: " + extraLife);
    }

    // Equipar un arma que aumenta el ataque
    public void equipWeapon(int extraAttack) {
        int currentAttack = this.stats.get(Stats.ATTACK);
        this.stats.put(Stats.ATTACK, currentAttack + extraAttack);
        System.out.println(this.name + " equipa un arma. Ataque aumentado en: " + extraAttack);
    }

    // Equipar una armadura que otorga defensa adicional
    public void equipArmor(int defense) {
        this.defenseBonus = defense;  // Asigna el bono de defensa de la armadura
        System.out.println(this.name + " equipa una armadura. Defensa adicional: " + defense);
    }

    // Atacar a un enemigo y aplicar daño extra si tiene un arma equipada
    public int attack(Enemy enemy, int weaponDamageBonus) {
        int attackPower = this.stats.get(Stats.ATTACK) + weaponDamageBonus;
        enemy.takeDamage(attackPower);
        System.out.println(this.name + " ataca al enemigo con " + attackPower + " de daño.");
        return attackPower;
    }

    // Recibir daño, aplicando el bono de defensa
    public void receiveDamage(int damage) {
        int reducedDamage = Math.max(damage - defenseBonus, 0);  // Reducir daño basado en defensa
        int currentHP = this.stats.get(Stats.HP);
        this.stats.put(Stats.HP, Math.max(currentHP - reducedDamage, 0)); // Evitar que HP baje de 0
        System.out.println(this.name + " recibe " + reducedDamage + " de daño tras aplicar la defensa. Vida restante: " + this.stats.get(Stats.HP));
    }

    private int life;

    public void takeDamage (int damage){
        life = damage;
        if (life < 0){
            life = 0;
        }
    }

    // Comprobar si el jugador está muerto
    public boolean isDead() {
        return this.stats.get(Stats.HP) <= 0;
    }


    // Comprobar si el jugador está vivo
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }

    private final Inventory inventory;

    public Player(String name) {

        super(name);
        inventory = new Inventory(15);
    }

    public boolean tryToFlee() {

        return Randomized.getRandomBoolean();
    }

    public void levelUp() {

        stats.put(Stats.LEVEL, stats.get(Stats.LEVEL) + 1);
        stats.put(Stats.MAX_HP, stats.get(Stats.MAX_HP) + Randomized.getRandomInt(5, 10));
        stats.put(Stats.HP, stats.get(Stats.MAX_HP));
        stats.put(Stats.MAX_MP, stats.get(Stats.MAX_MP) + Randomized.getRandomInt(2, 5));
        stats.put(Stats.MP, stats.get(Stats.MAX_MP));
        stats.put(Stats.ATTACK, stats.get(Stats.ATTACK) + Randomized.getRandomInt(1, 3));
        stats.put(Stats.DEFENSE, stats.get(Stats.DEFENSE) + Randomized.getRandomInt(1, 3));
        stats.put(Stats.NEEDED_EXPERIENCE, stats.get(Stats.NEEDED_EXPERIENCE) + 50);
        stats.put(Stats.EXPERIENCE, 0);
    }

    @Override
    protected void initCharacter() {

        stats.put(Stats.LEVEL, 1);
        stats.put(Stats.MAX_HP, 100);
        stats.put(Stats.HP, 100);
        stats.put(Stats.MAX_MP, 50);
        stats.put(Stats.MP, 50);
        stats.put(Stats.ATTACK, 10);
        stats.put(Stats.DEFENSE, 5);
        stats.put(Stats.EXPERIENCE, 0);
        stats.put(Stats.NEEDED_EXPERIENCE, 100);
        stats.put(Stats.GOLD, 0);
    }

    public void addItemToInventory(Item item) {

        if (item instanceof Misc misc) {
            if (misc.isStackable()) {
                boolean found = false;
                for (Item i : inventory.listMisc()) {
                    if (i.getName().equals(misc.getName())) {
                        misc.increaseQuantity(1);
                        inventory.removeItem(i);
                        inventory.addItem(misc);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    inventory.addItem(item);
                }
            } else {
                inventory.addItem(item);
            }
        } else {
            inventory.addItem(item);
        }
    }

    public void removeItemFromInventory(Item item) {

        if (item instanceof Misc misc) {
            if (misc.isStackable()) {
                for (Item i : inventory.listMisc()) {
                    if (i.getName().equals(item.getName())) {
                        misc.decreaseQuantity(1);
                        if (misc.getQuantity() == 0) {
                            inventory.removeItem(i);
                        }
                        break;
                    }
                }
            } else {
                inventory.removeItem(item);
            }
        } else {
            inventory.removeItem(item);
        }
    }

    public void sellItem(Item item) {

       /* try {
            Item getItem = inventory.getItem(item);
            if (getItem instanceof Misc misc) {
                if (misc.isStackable()) {
                    if (misc.getQuantity() > 1) {
                        misc.decreaseQuantity(1);
                    } else {
                        inventory.removeItem(item);
                    }
                }
            } else {
                inventory.removeItem(getItem);
            }
        } catch (ItemNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
    }

    public void showInventory() {

       /* StringBuilder content = new StringBuilder("Inventory: \n");
        String format = """
                Name: %s, Price: %d
                Description: %s
                """;
        String formatQuantity = """
                Name: %s, Price: %d, Quantity: %d
                Description: %s
                """;
        for (Item item : inventory.getItems()) {

            if (item instanceof Misc misc) {
                if (misc.isStackable()) {
                    content.append(String.format(formatQuantity, item.getName(),
                            item.getPrice(), misc.getQuantity(), item.getDescription()));
                } else {
                    content.append(String.format(format, item.getName(), item.getPrice(),
                            item.getDescription()));
                }
            } else {
                content.append(String.format(format, item.getName(), item.getPrice(),
                        item.getDescription()));
            }
        }
        JOptionPane.showMessageDialog(null, content.toString());*/
    }

    public Inventory getInventory() {
        return inventory;
    }
}