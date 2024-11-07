package rpg.gui.labels;

import rpg.gui.ui.LabelUI;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class PortraitLabel extends JLabel {

    protected ImageIcon icon;

    public PortraitLabel() {
        initComponents();
        setSize(new Dimension(117, 117));
        setPreferredSize(getSize());
        setMaximumSize(getSize());
        setMinimumSize(getSize());
    }

    public void initComponents() {
        ImageCache.addImage("portrait",
                "Personajes/Personaje.png");  // Ruta absoluta añadida
        icon = ImageCache.getImageIcon("portrait");
        setIcon(icon);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(icon.getImage(), 0, 0, 117, 117, this);
    }
}
