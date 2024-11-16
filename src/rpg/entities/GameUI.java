package rpg.entities;

import javax.swing.ImageIcon;

import rpg.Game;
import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.Goblin.Goblin;
import rpg.entities.enemies.Dragon.Dragon;
import rpg.entities.enemies.Orc.Orc;
import rpg.entities.enemies.Troll.Troll;
import rpg.entities.enemies.Skeleton.Skeleton;
import rpg.enums.ItemType;
import rpg.enums.Stats;
import rpg.enums.WeaponType;
import rpg.inventory.Inventory;
import rpg.items.Armors.Armor;
import rpg.items.Armors.IronArmor;
import rpg.items.Armors.WoodArmor;
import rpg.items.Miscs.Misc;
import rpg.items.weapons.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameUI extends JFrame {
    private JTextArea gameLog;
    private JButton attackButton;
    private Player player;
    private Enemy enemy;
    private Game game;

    private JProgressBar playerHealthBar;
    private JProgressBar enemyHealthBar;

    public GameUI(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;

        // Configuración de la ventana
        setTitle("Rise of the Warlords");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear área de texto para mostrar el registro del juego
        gameLog = new JTextArea();
        gameLog.setEditable(false);
        gameLog.setFont(new Font("Serif", Font.PLAIN, 16)); // Configurar la fuente del JTextArea
        JScrollPane scrollPane = new JScrollPane(gameLog);

        // Crear botón de Ataque
        attackButton = new JButton("Atacar");
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerAttack();
            }
        });

        // Crear las imágenes y redimensionarlas
        ImageIcon playerIcon = new ImageIcon("resources/images/player.png");
        Image playerImage = playerIcon.getImage(); // Obtener la imagen de ImageIcon
        Image resizedPlayerImage = playerImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionar
        JLabel playerImageLabel = new JLabel(new ImageIcon(resizedPlayerImage));

        ImageIcon enemyIcon = new ImageIcon("resources/images/enemy.png");
        Image enemyImage = enemyIcon.getImage();
        Image resizedEnemyImage = enemyImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionar
        JLabel enemyImageLabel = new JLabel(new ImageIcon(resizedEnemyImage));

        // Crear las barras de vida para cada personaje
        playerHealthBar = new JProgressBar(0, player.getLife());  // Configura el rango de la barra
        playerHealthBar.setValue(player.getLife());  // Establece el valor inicial
        playerHealthBar.setStringPainted(true);  // Mostrar el porcentaje en la barra
        playerHealthBar.setForeground(Color.GREEN);  // Color verde para vida

        enemyHealthBar = new JProgressBar(0, enemy.stats.get(Stats.HP));  // Configura el rango de la barra
        enemyHealthBar.setValue(enemy.stats.get(Stats.HP));  // Establece el valor inicial
        enemyHealthBar.setStringPainted(true);  // Mostrar el porcentaje en la barra
        enemyHealthBar.setForeground(Color.RED);  // Color rojo para vida

        // Crear un panel para las imágenes con espacio personalizado
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0)); // Ajusta el espaciado horizontal (50 píxeles)

        // Agregar las imágenes al panel
        imagePanel.add(playerImageLabel);
        imagePanel.add(enemyImageLabel);

        // Crear un panel para las barras de vida
        JPanel healthPanel = new JPanel();
        healthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10)); // Espaciado vertical de 10 píxeles

        // Agregar las barras de vida al panel
        healthPanel.add(playerHealthBar);
        healthPanel.add(enemyHealthBar);

        // Establecer el layout y agregar los componentes
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(attackButton, BorderLayout.SOUTH);
        add(imagePanel, BorderLayout.NORTH); // Mostrar las imágenes en la parte superior
        add(healthPanel, BorderLayout.CENTER); // Mostrar las barras de vida en el centro

        // Iniciar el juego
        game = new Game(player, enemy, this);
    }




    /**
     * Función para mostrar el mensaje de bienvenida
     */
    private void showWelcomeMessage() {
        appendToLog("¡Bienvenido a Rise of the Warlords!");
        appendToLog("Tu aventura comienza entre " + player.getName() + " y " + enemy.getName() + ".");
        appendToLog(player.getName() + " empieza con " + player.getLife() + " puntos de vida.");
        appendToLog(enemy.getName() + " empieza con " + enemy.stats.get(Stats.HP) + " puntos de vida.");
    }

    /**
     * Función para controlar el ataque del jugador
     */
    private void playerAttack() {
        // Verificar si el jugador o el enemigo están muertos antes de atacar
        if (player.isDead()) {
            displayGameOverMessage(player.getName() + " está derrotado! El juego ha terminado.");
            attackButton.setEnabled(false);
            return;
        }

        // Ataque del jugador
        int playerDamage = player.attack(enemy, 10);
        enemy.takeDamage(playerDamage);  // Aplicar daño al enemigo
        appendToLog(player.getName() + " ataca a " + enemy.getName() + " generando " + playerDamage + " puntos de daño. " +
                enemy.getName() + " tiene " + enemy.stats.get(Stats.HP) + " puntos de vida restantes.");

        // Verificar si el enemigo está muerto después del ataque
        if (enemy.isDead()) {
            appendToLog(enemy.getName() + " está derrotado.");
            attackButton.setEnabled(false);  // Desactivar el botón
            displayGameOverMessage(player.getName() + " ha ganado el juego!");
            return;  // No continuar con el resto del código si el enemigo está muerto
        }

        // Actualizar la barra de vida del enemigo
        enemyHealthBar.setValue(enemy.stats.get(Stats.HP));  // Actualizar la barra de vida del enemigo

        // Retrasar el contraataque del enemigo
        Timer enemyAttackTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enemyAttack();
            }
        });
        enemyAttackTimer.setRepeats(false);
        enemyAttackTimer.start();
    }


    private void enemyAttack() {
        // Verificar si el jugador está muerto antes de atacar
        if (enemy.isDead()) {
            displayGameOverMessage("El juego ha terminado.");
            attackButton.setEnabled(false);
            return;
        }

        // Ataque del enemigo
        int enemyDamage = enemy.attack(player);
        player.takeDamage(enemyDamage);
        appendToLog(enemy.getName() + " ataca a " + player.getName() + " generando " + enemyDamage + " puntos de daño. " +
                player.getName() + " tiene " + player.getLife() + " puntos de vida restantes.");

        // Actualizar la barra de vida del jugador
        playerHealthBar.setValue(player.getLife());  // Actualizar la barra de vida del jugador

        // Verificar si el jugador está muerto
        if (player.isDead()) {
            appendToLog(player.getName() + " está derrotado! El juego ha terminado.");
            attackButton.setEnabled(false);  // Desactivar el botón
            displayGameOverMessage(enemy.getName() + " ha ganado el juego!");
        }
    }


    /**
     * Función para mostrar el mensaje de fin del juego
     * @param message
     */

    private void displayGameOverMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Función para comenzar el juego y mostrar su ventana
     */

    public void startGame() {
        setVisible(true);
        showWelcomeMessage();
    }

    public void displayMessage(String message) {
        appendToLog(message);
    }

    /**
     * Función para agregar texto al log del juego
     * @param text
     */

    public void appendToLog(String text) {
        SwingUtilities.invokeLater(() -> gameLog.append(text + "\n"));
    }


    /**
     *  Función para crear un enemigo aleatorio
     * @return
     */

    private static Enemy createRandomEnemy() {
        Random rand = new Random();
        int enemyType = rand.nextInt(5);

        switch (enemyType) {
            case 0:
                return new Goblin("Goblin Guerrero");
            case 1:
                return new Orc("Orc Salvaje");
            case 2:
                return new Dragon("Dragón Imponente");
            case 3:
                return new Troll("Troll Feroz");
            case 4:
                return new Skeleton("Esqueleto Oscuro");
            default:
                return null;
        }
    }

    /**
     * Función principal
     * @param args
     */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear enemigo aleatorio
            Enemy enemy = createRandomEnemy();

            // Configuración de inventario y personajes
            Inventory inventory = new Inventory(10);
            Armor armor = new IronArmor("Bronce", "Armadura básica", 450, 34, 32, "Defensa");
            inventory.addItem(armor);

            Weapon weapon = new Weapon("Pistola", "Arma de distancia", 555, WeaponType.CROSSBOW);
            inventory.addItem(weapon);

            Misc misc = new Misc("Poción", "Curación", 455, "Curación rápida", 10, 1, ItemType.MISC);
            inventory.addItem(misc);

            Player player = new Player("Andrew");
            player.usePotion(misc.getPotency());
            player.equipWeapon(20);
            player.equipArmor(3);

            // Crear la interfaz de usuario del juego
            assert enemy != null;
            GameUI gameUI = new GameUI(player, enemy);

            // Iniciar el juego
            gameUI.startGame();  // Asegúrate de que esto se llame después de configurar la UI
        });
    }
}
