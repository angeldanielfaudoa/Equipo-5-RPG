package rpg.gui.buttons;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseButton extends JButton {

    public BaseButton(String text) {

        setText(text);
        setUI(new HoverButtonUI());
    }
}