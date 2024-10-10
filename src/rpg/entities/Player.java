package rpg.entities;

import rpg.enums.Stats;  // Importa el enumerado que define las estadísticas del juego.
import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;  // Almacena el nombre del jugador.
    private Map<Stats, Integer> stats;  // Mapa que almacena las estadísticas del jugador donde la clave es del tipo Stats y el valor es un entero.

    /**
     * Constructor que inicializa el nombre y las estadísticas del jugador
     * @param name Nombre del jugador
     */
    public Player(String name) {
        this.name = name;  // Asigna el nombre del jugador.
        this.stats = new HashMap<>();  // Inicializa el mapa de estadísticas para el jugador.

        /**
         * Inicializa las estadísticas del jugador con valores predeterminados
         */
        this.stats.put(Stats.MAX_HP, 100);  // Asigna el valor predeterminado para la vida máxima del jugador.
        this.stats.put(Stats.HP, 100);  // Inicializa los puntos de vida actuales igual a la vida máxima.
        this.stats.put(Stats.ATTACK, 10);  // Asigna los puntos de ataque predeterminados del jugador.
        this.stats.put(Stats.DEFENSE, 5);  // Asigna los puntos de defensa predeterminados del jugador.
    }

    /**
     * Método para obtener el nombre del jugador
     * @return El nombre del jugador
     */
    public String getName() {
        return name;  // Devuelve el nombre del jugador.
    }

    /**
     * Método para obtener las estadísticas del jugador
     * @return Mapa de estadísticas del jugador
     */
    public Map<Stats, Integer> getStats() {
        return stats;  // Devuelve el mapa de estadísticas del jugador.
    }

    /**
     * Método que verifica si el jugador está vivo
     * @return Verdadero si el jugador tiene más de 0 puntos de vida, falso en caso contrario
     */
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;  // Verifica si los puntos de vida del jugador son mayores que 0.
    }

    /**
     * Método para atacar a un enemigo
     */
    public void attack(Enemy enemy) {
        /**
         * Calcula el daño como el ataque del jugador menos la defensa del enemigo
         */
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);

        /**
         * Si el daño es mayor que 0, aplica el daño al enemigo
         */
        if (damage > 0) {
            /**
             * Reduce los puntos de vida del enemigo en función del daño infligido
             */
            enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        }
    }
}
