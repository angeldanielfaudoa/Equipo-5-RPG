package rpg.inventory;

import rpg.items.Armors.Armor; // Importa la clase Armor del paquete de armaduras.
import rpg.items.Item; // Importa la clase base Item.
import rpg.items.Miscs.Misc;
import rpg.items.weapons.Weapon; // Importa la clase Weapon del paquete de armas.

import java.util.ArrayList; // Importa la clase ArrayList para usar listas dinámicas.

public class Inventory {
    private ArrayList<Item> items; // Lista que almacena los ítems del inventario.
    private int capacity; // Capacidad máxima del inventario.

    /**
     * Constructor que inicializa el inventario con una capacidad específica
     * @param capacity Capacidad máxima del inventario
     */
    public Inventory(int capacity) {
        this.capacity = capacity; // Asigna la capacidad del inventario.
        this.items = new ArrayList<>(); // Inicializa la lista de ítems.
    }

    /**
     * Método para agregar un ítem al inventario
     * @param item Ítem a agregar
     */
    public void addItem(Item item) {
        if (!isFull()) { // Verifica si el inventario no está lleno.
            items.add(item); // Agrega el ítem a la lista.
        } else {
            System.out.println("El inventario está lleno."); // Mensaje de error si el inventario está lleno.
        }
    }

    /**
     * Método para remover un ítem del inventario
     * @param item Ítem a remover
     */
    public void removeItem(Item item) {
        items.remove(item); // Elimina el ítem de la lista.
    }

    /**
     * Método para obtener un ítem por su índice
     * @param index Índice del ítem a obtener
     * @return El ítem en la posición especificada
     */
    public Item getItem(int index) {
        return items.get(index); // Devuelve el ítem en el índice dado.
    }

    /**
     * Método para obtener la cantidad de ítems en el inventario
     * @return Cantidad de ítems
     */
    public int getItemCount() {
        return items.size(); // Devuelve el número total de ítems en el inventario.
    }

    /**
     * Método para verificar si el inventario está lleno
     * @return Verdadero si el inventario está lleno, falso en caso contrario
     */
    public boolean isFull() {
        return items.size() >= capacity; // Comprueba si el tamaño de la lista es mayor o igual a la capacidad.
    }

    /**
     * Método para verificar si el inventario está vacío
     * @return Verdadero si el inventario está vacío, falso en caso contrario
     */
    public boolean isEmpty() {
        return items.isEmpty(); // Verifica si la lista de ítems está vacía.
    }

    /**
     * Método para limpiar el inventario
     */
    public void clear() {
        items.clear(); // Elimina todos los ítems del inventario.
    }

    /**
     * Método para aumentar la capacidad del inventario
     * @param amount Cantidad para aumentar la capacidad
     */
    public void increaseCapacity(int amount) {
        capacity += amount; // Aumenta la capacidad del inventario en la cantidad especificada.
    }

    /**
     * Método para listar todas las armaduras en el inventario
     * @return Lista de armaduras
     */
    public ArrayList<Armor> listArmors() {
        ArrayList<Armor> armors = new ArrayList<>(); // Crea una lista para almacenar las armaduras.
        for (Item item : items) { // Itera sobre los ítems en el inventario.
            if (item instanceof Armor) { // Verifica si el ítem es una armadura.
                armors.add((Armor) item); // Agrega la armadura a la lista.
            }
        }
        return armors; // Devuelve la lista de armaduras.
    }

    /**
     * Método para listar todas las armas en el inventario
     * @return Lista de armas
     */
    public ArrayList<Weapon> listWeapons() {
        ArrayList<Weapon> weapons = new ArrayList<>(); // Crea una lista para almacenar las armas.
        for (Item item : items) { // Itera sobre los ítems en el inventario.
            if (item instanceof Weapon) { // Verifica si el ítem es un arma.
                weapons.add((Weapon) item); // Agrega el arma a la lista.
            }
        }
        return weapons; // Devuelve la lista de armas.
    }

    /**
     * Método para listar todos los ítems varios en el inventario
     * @return Lista de ítems varios
     */
    public ArrayList<Misc> listMisc() {
        ArrayList<Misc> miscItems = new ArrayList<>(); // Crea una lista para almacenar ítems varios.
        for (Item item : items) { // Itera sobre los ítems en el inventario.
            if (item instanceof Misc) { // Verifica si el ítem es un ítem variado.
                miscItems.add((Misc) item); // Agrega el ítem a la lista.
            }
        }
        return miscItems; // Devuelve la lista de ítems varios.
    }
}
