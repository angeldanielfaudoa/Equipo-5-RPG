package rpg.entities;

import rpg.enums.Stats;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private Map<Stats, Integer> stats;

    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
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

    public void attack(Enemy enemy) {
        int damage = this.stats.get(Stats.ATTACK) - enemy.getStats().get(Stats.DEFENSE);
        if (damage > 0) {
            enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
        }
    }
}