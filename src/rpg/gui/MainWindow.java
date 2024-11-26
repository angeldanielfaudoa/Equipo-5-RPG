package rpg.gui;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.Goblin.Goblin;
import rpg.enums.BarType;
import rpg.enums.Stats;
import rpg.factory.EnemyFactory;
import rpg.gui.buttons.BaseButton;
import rpg.gui.labels.*;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JDesktopPane desktopPane;
    private JButton button1;
    private JButton Atacar;
    private JButton Huir;
    private JButton Skills;
    private JLabel portraitLabel;
    private JButton button2;
    private JButton button3;
    private JLabel LifeLabel;
    private JLabel MagicLabel;
    private JLabel ExpLabel;
    private JLabel nameLabel;
    private JLabel goldLabel;
    private JScrollPane textScroll;
    private JTextArea textDisplay;
    private JLabel playerSprite;
    private JLabel enemyNameLabel;
    private JLabel enemyLifeLabel;
    private JLabel enemySprite;
    private JButton button4;

    Player player;
    Enemy enemy;
    int slot;

    public MainWindow(Player player, int slot) {

        this.player = player;
        this.slot = slot;
        initComponents();
        ((BarLabel) LifeLabel).updateBar(player.getStats().get(Stats.HP), player.getStats().get(Stats.MAX_HP));
        ((BarLabel) MagicLabel).updateBar(player.getStats().get(Stats.MP), player.getStats().get(Stats.MAX_MP));
        ((BarLabel) ExpLabel).updateBar(player.getStats().get(Stats.EXPERIENCE), player.getStats().get(Stats.NEEDED_EXPERIENCE));
        //statusFrame = new StatusFrame(this);
        //inventoryFrame = new InventoryFrame(this);
        //desktopPane.add(statusFrame, JLayeredPane.PALETTE_LAYER);
       // desktopPane.add(inventoryFrame, JLayeredPane.PALETTE_LAYER);
        // Colocamos los InternalFrames en la posición deseada
       // statusFrame.setLocation((desktopPane.getWidth() - statusFrame.getWidth()) / 2,
         //       (desktopPane.getHeight() - statusFrame.getHeight()) / 2);
       // inventoryFrame.setLocation((desktopPane.getWidth() - inventoryFrame.getWidth()) / 2,
             //   (desktopPane.getHeight() - inventoryFrame.getHeight()) / 2);
        // Añadimos un mensaje al textDisplay de bienvenida
        appendText("¡Bienvenido a RPG Game!\n");
        appendText("¡Prepárate para la aventura!\n");
        appendText("Aparece un nuevo enemigo: " + enemy.getName() + "\n");
    }

    private void initComponents() {
        // Creamos un DesktopPane para poder agregar los componentes
        desktopPane = new JDesktopPane();
        // Hacemos que el tamaño del DesktopPane sea igual al
        // tamaño del panel principal
        desktopPane.setPreferredSize(mainPanel != null ?
                mainPanel.getPreferredSize() : null);
        // Definimos los Bounds del panel principal
        mainPanel.setBounds(0, 0, mainPanel.getPreferredSize().width,
                mainPanel.getPreferredSize().height);
        // Agregamos el panel principal al DesktopPane
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
        // Agregamos el panel principal a la ventana
        setContentPane(desktopPane);
        // Definimos el título de la ventana
        setTitle("RPG Game");
        // Definimos la operación por defecto al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Tomamos el tamaño de los componentes
        pack();
        // Centramos la ventana
        setLocationRelativeTo(null);
        // Hacemos visible la ventana
        setVisible(true);
        // Definimos que la ventana no se pueda redimensionar
        setResizable(false);

        // Acciones previas en el panel
        textScroll.getViewport().setOpaque(false);
        textScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textDisplay.setFont(WindowConstants.FONT.deriveFont(22f));
        textDisplay.setBorder(new EmptyBorder(10, 10, 10, 10));
        textDisplay.setForeground(Color.WHITE);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
    }

    public void appendText(String text) {
        // Añadimos el texto al textDisplay
        textDisplay.append(text);
        // Hacemos que el textDisplay se posicione en la última línea
        textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }

    private void createUIComponents() {
        // Paneles principales
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();

        // Botones
        button1=new BaseButton("Guardar");
        button2=new BaseButton("Inventario");
        button3=new BaseButton("Tienda");
        button4=new BaseButton("Salir");


        // Botones adicionales en español
        Atacar = new BaseButton("Atacar");
        Huir = new BaseButton("Huir");
        Skills = new BaseButton("Skills");


        // Etiqueta adicional
        portraitLabel = new PortraitLabel();


        // Otros componentes de la interfaz
        LifeLabel = new BarLabel(100, 100, BarType.LIFE);
        MagicLabel = new BarLabel(30, 100, BarType.MAGIC);
        ExpLabel = new BarLabel(100, 100, BarType.EXPERIENCE);


        goldLabel = new GoldLabel();
        nameLabel = new NameLabel("Andrew LVL. 1");

        // Componentes del enemigo
        portraitLabel = new PortraitLabel();
        playerSprite = new PlayerSpriteLabel();

        Enemy enemy = new Goblin("Goblin");
        enemyNameLabel = new NameLabel(enemy.getName());
        enemyLifeLabel = new BarLabel(100, 100, BarType.LIFE);
        enemySprite = new EnemySpriteLabel(enemy);
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void checkGameStatus() {

        // Verificamos si el jugador o el enemigo han muerto
        if (!player.isAlive()) {
            // En caso de que el jugador haya muerto
            // Añadimos un mensaje al textDisplay de que el jugador ha muerto
            appendText("Has muerto.\n");
            appendText("GAME OVER\n");
        } else if (!enemy.isAlive()) {
            // En caso de que el enemigo haya muerto
            // Recuperamos la experiencia y el oro del jugador y del enemigo
            int playerExp = player.getStats().get(Stats.EXPERIENCE);
            int enemyExp = enemy.getStats().get(Stats.EXPERIENCE);
            int promotionExp = player.getStats().get(Stats.NEEDED_EXPERIENCE);
            int playerGold = player.getStats().get(Stats.GOLD);
            int enemyGold = enemy.getStats().get(Stats.GOLD);
            // Calculamos el total de experiencia y oro
            int totalExp = playerExp + enemyExp;
            int totalGold = playerGold + enemyGold;
            // Añadimos un mensaje al textDisplay de que se ha derrotado al enemigo
            // y se ha ganado experiencia y oro.
            appendText("""
                    Has derrotado a %s
                    Has ganado %d puntos de experiencia.
                    Has ganado %d monedas de oro.
                    """.formatted(enemy.getName(), enemyExp, enemyGold));
            // Asignamos la nueva experiencia y oro al jugador
            player.getStats().put(Stats.EXPERIENCE, totalExp);
            player.getStats().put(Stats.GOLD, totalGold);
            goldLabel.setText(totalGold + "G");
            goldLabel.repaint();
            // Evaluamos si el jugador ha subido de nivel
            if (totalExp >= promotionExp)
                updatePlayer();
            // Creamos un nuevo enemigo en cualquier caso
            createEnemy();
        }
        updateBars();
    }

    private void updatePlayer() {

        // Actualizamos al jugador
        player.levelUp();
        // Obtenemos el nivel, vida, magia y experiencia del jugador
        int level = player.getStats().get(Stats.LEVEL);
        int hp = player.getStats().get(Stats.HP);
        int mp = player.getStats().get(Stats.MP);
        int neededExp = player.getStats().get(Stats.NEEDED_EXPERIENCE);
        // Añadimos un mensaje al textDisplay de que el jugador ha subido de nivel
        appendText("Has subido de nivel.\n");
        // Actualizamos las barras de estado del jugador
        ((BarLabel) LifeLabel).updateBar(hp, hp);
        ((BarLabel) MagicLabel).updateBar(mp, mp);
        ((BarLabel) ExpLabel).updateBar(0, neededExp);
        // Actualizamos el nombre del jugador
        ((NameLabel) nameLabel).updateLabel(
                "%s LVL. %d".formatted(player.getName(), level));
    }

    private void createEnemy() {

        enemy = EnemyFactory.getEnemy();
        if (enemy != null) {

            enemyNameLabel.setText(enemy.getName());
            appendText("Aparece un nuevo enemigo: " + enemy.getName() + "\n");
            ((EnemySpriteLabel) enemySprite).setEnemy(enemy);
            ((NameLabel) enemyNameLabel).updateLabel(enemy.getName());
            ((BarLabel) enemyLifeLabel).updateBar(enemy.getStats().get(Stats.HP),
                    enemy.getStats().get(Stats.MAX_HP));
        }
    }

    private void updateBars() {

        ((BarLabel) LifeLabel).setBarValue(player.getStats().get(Stats.HP));
        ((BarLabel) ExpLabel).setBarValue(player.getStats().get(Stats.EXPERIENCE));
        ((BarLabel) enemyLifeLabel).setBarValue(enemy.getStats().get(Stats.HP));
    }

}