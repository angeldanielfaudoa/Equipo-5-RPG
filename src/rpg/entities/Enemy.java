package rpg.entities;

import RPGmain.src.rpg.enums.Stats;

import java.util.HashMap;
import java.util.Map;

public class Enemy {
    private String name;
    private Map<Stats, Integer> stats;

    /**
     * Constructor que inicializa el nombre y las estadísticas del enemigo
     * @param name Nombre del enemigo
     * @param maxHP Puntos de vida máxima
     * @param attack Puntos de ataque
     * @param defense Puntos de defensa
     */
    public Enemy(String name, int maxHP, int attack, int defense) {
        this.name = name;
        this.stats = new HashMap<>();

        /**
         * Inicializa las estadísticas del enemigo con valores pasados como parámetros
         */
        this.stats.put(Stats.MAX_HP, maxHP);
        this.stats.put(Stats.HP, maxHP);
        this.stats.put(Stats.ATTACK, attack);
        this.stats.put(Stats.DEFENSE, defense);
    }

    public String getName() {
        return name;
    }

    public Map<Stats, Integer> getStats() {
        return stats;
    }

    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }

    public void attack(Player player) {
        int damage = this.stats.get(Stats.ATTACK) - player.getStats().get(Stats.DEFENSE);
        if (damage > 0) {
            player.getStats().put(Stats.HP, player.getStats().get(Stats.HP) - damage);
        }
    }
}
