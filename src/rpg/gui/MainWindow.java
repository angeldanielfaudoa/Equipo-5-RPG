package rpg.gui;

import rpg.entities.enemies.Enemy;
import rpg.enums.BarType;
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
    private JButton Tienda;
    private JButton Inventario;
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

    public MainWindow() {
        initComponents();
        createUIComponents();
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

        // Botones específicos de acción
        Atacar = new  BaseButton("Atacar");

        // Botones adicionales en español
        Tienda = new BaseButton("Tienda");
        Inventario = new BaseButton("Inventario");
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
        nameLabel = new NameLabel("{Andrew} LVL. 1");

        // Componentes del enemigo
        exampleLabel = new PortraitLabel();
        playerSprite = new PlayerSpriteLabel();

        Enemy enemy = new RookieGoblin();
        enemyNameLabel = new NameLabel(enemy.getName());
        enemyLifeLabel = new BarLabel(100, 100, BarType.LIFE);
        enemySprite = new EnemySpriteLabel(enemy);
    }

    public static void main(String[] args) {
        new MainWindow();
    }

}
