package rpg.gui.labels;

import rpg.entities.enemies.Enemy;
import rpg.gui.ui.EnemyLabelUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class EnemySpriteLabel extends JLabel {

    ImageIcon icon;
    Enemy enemy;

    public EnemySpriteLabel(Enemy enemy) {

        this.enemy = enemy;
        initComponents();
        setUI(new EnemyLabelUI(icon));
    }

    public void initComponents() {

        icon = enemy.getSprite();
        setPreferredSize(getMinDimension());
        setSize(getMinDimension());
        setIcon(icon);
    }

    private Dimension getMinDimension() {

        if (icon.getIconWidth() > 250 || icon.getIconHeight() > 150) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
        }
        return new Dimension(icon.getIconWidth(), icon.getIconHeight());
    }
}