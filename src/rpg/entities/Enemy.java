package rpg.entities;

import rpg.enums.Stats;  // Importa un enumerado que contiene las diferentes estadísticas del juego.
import java.util.HashMap;
import java.util.Map;

public class Enemy {
    private String name;  // Almacena el nombre del enemigo.
    private Map<Stats, Integer> stats;  // Almacena un mapa de estadísticas donde la clave es del tipo Stats y el valor es un entero.

    /**
     * Constructor que inicializa el nombre y las estadísticas del enemigo
     * @param name Nombre del enemigo
     * @param maxHP Puntos de vida máxima
     * @param attack Puntos de ataque
     * @param defense Puntos de defensa
     */
    public Enemy(String name, int maxHP, int attack, int defense) {
        this.name = name;  // Asigna el nombre del enemigo.
        this.stats = new HashMap<>();  // Inicializa el mapa de estadísticas.

        /**
         * Inicializa las estadísticas del enemigo con valores pasados como parámetros
         */
        this.stats.put(Stats.MAX_HP, maxHP);  // Asigna el valor de vida máxima.
        this.stats.put(Stats.HP, maxHP);  // Inicializa los puntos de vida actuales igual a la vida máxima.
        this.stats.put(Stats.ATTACK, attack);  // Asigna los puntos de ataque.
        this.stats.put(Stats.DEFENSE, defense);  // Asigna los puntos de defensa.
    }

    public String getName() {
        return name;  // Devuelve el nombre del enemigo.
    }

    public Map<Stats, Integer> getStats() {
        return stats;  // Devuelve el mapa de estadísticas del enemigo.
    }

    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;  // Verifica si el enemigo sigue vivo comprobando que sus puntos de vida sean mayores que 0.
    }

    public void attack(Player player) {
        // Calcula el daño restando la defensa del jugador al ataque del enemigo.
        int damage = this.stats.get(Stats.ATTACK) - player.getStats().get(Stats.DEFENSE);
        if (damage > 0) {
            // Si el daño es positivo, reduce los puntos de vida del jugador.
            player.getStats().put(Stats.HP, player.getStats().get(Stats.HP) - damage);
        }
    }
}
