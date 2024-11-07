package rpg.gui;

import rpg.gui.buttons.BaseButton;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static rpg.gui.WindowConstants.WINDOW_SIZE;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel BarraDeEstado;
    private JPanel PanelDeJuego;
    private JPanel BarraDeAccion;
    private JButton button1;
    private JButton Tienda;
    private JButton Inventario;
    private JButton Atacar;
    private JButton Skills;
    private JButton Huir;
    private JDesktopPane desktopPane;

    public MainWindow() {

        initComponents();
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

    public static void main(String[] args) {
        new MainWindow();
    }

    private void createUIComponents() {
        // Creamos el contenido personalizado de la ventana
        BarraDeEstado = new TopPanel();
        PanelDeJuego = new MiddlePanel();
        BarraDeAccion = new BottomPanel();
        button1 = new BaseButton("Button1");
        Tienda = new BaseButton("Tienda");
        Inventario = new BaseButton("Inventario");
        Atacar = new BaseButton("Atacar");
        Huir = new BaseButton("Huir");
        Skills = new BaseButton("Skills");
    };

}
