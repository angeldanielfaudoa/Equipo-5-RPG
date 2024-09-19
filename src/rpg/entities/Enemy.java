package rpg.entities;

import rpg.enums.Stats;
import java.util.HashMap;
import java.util.Map;

public class Enemy {
    private String name;
    private Map<Stats, Integer> stats;

    /**
     * Constructor que inicializa el nombre y las estadísticas del enemigo
     * @param name
     */
    public Enemy(String name) {
        this.name = name;
        this.stats = new HashMap<>();

        /**
         * Inicializa las estadísticas del enemigo con valores predeterminados
         */
        this.stats.put(Stats.MAX_HP, 50);
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 5);
        this.stats.put(Stats.DEFENSE, 2);
    }

    /**
     * Método para obtener el nombre del enemigo
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Método para obtener las estadísticas del enemigo
     * @return
     */
    public Map<Stats, Integer> getStats() {
        return stats;
    }

    /**
     * Método que verifica si el enemigo está vivo
     * @return
     */
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }

    /**
     * Método para atacar a un jugador
     * @param player
     */
    public void attack(Player player) {
        /**
         * Calcula el daño como el ataque del enemigo menos la defensa del jugador
         */
        int damage = this.stats.get(Stats.ATTACK) - player.getStats().get(Stats.DEFENSE);

        /**
         * Si el daño es mayor que 0, aplica el daño al jugador
         */
        if (damage > 0) {
            /**
             * Reduce los puntos de vida del jugador en función del daño infligido
             */
            player.getStats().put(Stats.HP, player.getStats().get(Stats.HP) - damage);
        }
    }
}
