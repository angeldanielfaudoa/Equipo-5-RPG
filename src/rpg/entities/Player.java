package rpg.entities;

import RPGmain.src.rpg.enums.Stats;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private Map<Stats, Integer> stats;

    /**
     * Constructor que inicializa el nombre y las estadísticas del jugador
     * @param name
     */
    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();

        /**
         * Inicializa las estadísticas del jugador con valores predeterminados
         */
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
    }

    /**
     * Método para obtener el nombre del jugador
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Método para obtener las estadísticas del jugador
     * @return
     */
    public Map<Stats, Integer> getStats() {
        return stats;
    }

    /**
     * Método que verifica si el jugador está vivo
     * @return
     */
    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }

    /**
    Metodo para atacar a un enemigo
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
