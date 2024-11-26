package rpg.gui.buttons;

import rpg.gui.MainWindow;
import rpg.gui.buttons.events.AttackEvent;



public class Atacar extends BaseButton {

    public Atacar(MainWindow game) {

        super("Atacar");
        addActionListener(new AttackEvent(game));
    }
}