package rpg.gui.labels;

import rpg.utils.cache.ImageCache;

import javax.swing.border.LineBorder;
import java.awt.*;

public class PlayerSpriteLabel extends PortraitLabel {

    public PlayerSpriteLabel() {
        super();
    }

    @Override
    public void initComponents() {
        ImageCache.addImage("playerSprite", "personajes/personaje.png");
        icon = ImageCache.getImageIcon("playerSprite");
        setPreferredSize(new Dimension(150,
                150));
        setSize(new Dimension(150, 150));
        setMaximumSize(new Dimension(150, 150));
        setMinimumSize(new Dimension(150, 150));
        setIcon(icon);
    }
}
