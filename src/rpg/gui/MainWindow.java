package rpg.gui;

import rpg.enums.BarType;
import rpg.gui.buttons.BaseButton;
import rpg.gui.labels.BarLabel;
import rpg.gui.labels.GoldLabel;
import rpg.gui.labels.NameLabel;
import rpg.gui.labels.PortraitLabel;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;

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


    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
