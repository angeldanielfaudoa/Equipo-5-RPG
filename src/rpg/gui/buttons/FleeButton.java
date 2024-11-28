package rpg.gui.buttons;

import rpg.gui.MainWindow;

public class FleeButton extends BaseButton {

    public FleeButton(MainWindow game) {

        super("Huir");
        addActionListener(e -> game.tryToFlee());
    }
}