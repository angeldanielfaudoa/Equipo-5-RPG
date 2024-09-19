package rpg;

import rpg.entities.Player;
import rpg.entities.Enemy;
import rpg.enums.Stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private Player player;
    private Enemy enemy;
    private JTextArea statusArea;
    private JButton attackButton;

    public Game() {
        // Configurar la ventana
        this.setTitle("Juego de Combate RPG");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Crear jugador y enemigo
        this.player = new Player("Héroe");
        this.enemy = new Enemy("Goblin");

        // Crear área de texto para mostrar el estado del juego
        statusArea = new JTextArea();
        statusArea.setEditable(false); // Evitar que el jugador edite el área de texto
        JScrollPane scrollPane = new JScrollPane(statusArea);
        this.add(scrollPane, BorderLayout.CENTER);

        // Crear botón de ataque
        attackButton = new JButton("Atacar");
        this.add(attackButton, BorderLayout.SOUTH);

        // Agregar acción al botón de ataque
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.isAlive() && enemy.isAlive()) {
                    player.attack(enemy); // El jugador ataca al enemigo
                    printStatus(); // Actualizar el estado del juego en la ventana

                    if (enemy.isAlive()) {
                        enemy.attack(player); // El enemigo ataca si sigue vivo
                        printStatus(); // Actualizar el estado del juego en la ventana
                    }

                    if (!player.isAlive() || !enemy.isAlive()) {
                        attackButton.setEnabled(false); // Desactivar el botón si alguien muere
                        if (player.isAlive()) {
                            statusArea.append("\n¡Has derrotado al enemigo!");
                        } else {
                            statusArea.append("\nFin del juego. El enemigo te ha derrotado.");
                        }
                    }
                }
            }
        });
    }

    // Método para actualizar el estado del juego en la ventana
    public void printStatus() {
        statusArea.setText(""); // Limpiar el área de texto antes de actualizar
        statusArea.append("Estado del jugador:\n");
        statusArea.append("Nombre: " + player.getName() + "\n");
        statusArea.append("HP: " + player.getStats().get(Stats.HP) + "/" + player.getStats().get(Stats.MAX_HP) + "\n");

        statusArea.append("\nEstado del enemigo:\n");
        statusArea.append("Nombre: " + enemy.getName() + "\n");
        statusArea.append("HP: " + enemy.getStats().get(Stats.HP) + "/" + enemy.getStats().get(Stats.MAX_HP) + "\n");
    }
}