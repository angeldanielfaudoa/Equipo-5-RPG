package rpg.gui.buttons;

import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class BaseButton extends JButton {

    public BaseButton(String text) {

        setText(text);
        setUI(new HoverButtonUI());
    }
}