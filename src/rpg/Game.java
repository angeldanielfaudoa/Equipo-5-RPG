package rpg;



import javax.swing.JFrame;
import rpg.entities.Enemy;
import rpg.entities.Player;
import rpg.enums.Stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rpg.inventory.InventoryWindow;
import rpg.items.Item;
import rpg.enums.ItemType;



public class Game extends JFrame {
    private Player player;
    private Enemy enemy;
    private JTextArea statusArea;
    private JButton attackButton;

    public Game() {
        /**
         * Configurar la ventana
         */
        this.setTitle("Juego de Combate RPG");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        /**
         * Crear jugador
         */
        this.player = new Player("Héroe");

        /**
         * Crear enemigos y seleccionar uno aleatoriamente
         */
        this.enemy = selectRandomEnemy();

        /**
         * Crear área de texto para mostrar el estado del juego
         */
        statusArea = new JTextArea();
        statusArea.setEditable(false); // Evitar que el jugador edite el área de texto
        JScrollPane scrollPane = new JScrollPane(statusArea);
        this.add(scrollPane, BorderLayout.CENTER);

        /**
         * Crear botón de ataque
         */
        attackButton = new JButton("Atacar");
        this.add(attackButton, BorderLayout.SOUTH);

        /**
         * Agregar acción al botón de ataque
         */
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.isAlive() && enemy.isAlive()) {
                    player.attack(enemy);
                    printStatus();

                    if (enemy.isAlive()) {
                        enemy.attack(player);
                        printStatus();
                    }

                    if (!player.isAlive() || !enemy.isAlive()) {
                        attackButton.setEnabled(false);
                        if (player.isAlive()) {
                            statusArea.append("\n¡Has derrotado al enemigo!");
                        } else {
                            statusArea.append("\nFin del juego. El enemigo te ha derrotado.");
                        }
                    }
                }
            }
        });

        /**
         * Mostrar el estado inicial del juego
         */
        printStatus();
    }

    /**
     * Selecciona un enemigo aleatoriamente de una lista de 5 enemigos
     * @return Enemigo seleccionado aleatoriamente
     */
    private Enemy selectRandomEnemy() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Goblin", 50, 5, 2));
        enemies.add(new Enemy("Ogro", 80, 10, 4));
        enemies.add(new Enemy("Dragón Acorazado", 150, 20, 10));
        enemies.add(new Enemy("Esqueleto Normal", 40, 8, 1));
        enemies.add(new Enemy("Zombie", 60, 7, 3));

        Random rand = new Random();
        return enemies.get(rand.nextInt(enemies.size()));
    }

    /**
     * Método para actualizar el estado del juego en la ventana
     */
    public void printStatus() {
        statusArea.setText("");
        statusArea.append("Estado del jugador:\n");
        statusArea.append("Nombre: " + player.getName() + "\n");
        statusArea.append("HP: " + player.getStats().get(Stats.HP) + "/" + player.getStats().get(Stats.MAX_HP) + "\n");

        statusArea.append("\nEstado del enemigo:\n");
        statusArea.append("Nombre: " + enemy.getName() + "\n");
        statusArea.append("HP: " + enemy.getStats().get(Stats.HP) + "/" + enemy.getStats().get(Stats.MAX_HP) + "\n");
    }




        public static void main(String[] args) {
            // Crear una lista de ítems para mostrar
            List<Item> items = new ArrayList<>();
            items.add(new Item("Espada", "Una espada afilada.", 100, ItemType.WEAPON));
            items.add(new Item("Armadura", "Una armadura resistente.", 200, ItemType.ARMOR));
            items.add(new Item("Poción", "Una poción de curación.", 50, ItemType.MISC));

            // Mostrar ventana del inventario
            SwingUtilities.invokeLater(() -> new InventoryWindow(items));
        }




    }





