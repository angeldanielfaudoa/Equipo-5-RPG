package rpg.gui;

import javax.swing.*;

import static rpg.gui.WindowConstants.WINDOW_SIZE;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel BarraDeEstado;
    private JPanel PanelDeJuego;
    private JPanel BarraDeAccion;

    public MainWindow() {
        setTitle("RPG Game");
        setSize(WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);
    }

    public void main(String[] args) {
        new MainWindow();
    }

}
