package rpg.entities.enemies.Dragon;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class Dragon extends Enemy {

    /**
     * Agregar constructor para Dragon
     */

    public Dragon(String name) {
            super("Dragon Imponente");
            ImageCache.addImage("Dragón", "Enemies/dragon.png");
        }

        @Override
        protected void initCharacter () {
            this.type = EnemyType.BASIC;
            this.stats.put(Stats.MAX_HP, 50);
            this.stats.put(Stats.HP, 50);
            this.stats.put(Stats.ATTACK, 8);
            this.stats.put(Stats.DEFENSE, 4);
            this.stats.put(Stats.EXPERIENCE, 30);
            this.stats.put(Stats.GOLD, 20);
        }

        @Override
        public ImageIcon getSprite () {
            return ImageCache.getImageIcon("dragon");
        }
    }

