package rpg.gui.labels;

import rpg.gui.ui.GameLabelUI;
import rpg.gui.ui.LabelUI;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class PortraitLabel extends JLabel {

    protected ImageIcon icon;


    public PortraitLabel() {
        initComponents();
        setUI(new GameLabelUI(getPreferredSize(), icon));
    }

    public void initComponents() {
        ImageCache.addImage("portrait",
                "Personajes/Personaje.png");  // Ruta absoluta añadida
        icon = ImageCache.getImageIcon("portrait");
        setPreferredSize(
                new Dimension(117, 117));
        setIcon(icon);
    }
}
