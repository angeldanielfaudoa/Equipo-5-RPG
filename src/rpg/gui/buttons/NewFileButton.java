package rpg.gui.buttons;

import rpg.gui.StartWindow;
import rpg.gui.buttons.events.NewPlayerEvent;

public class NewFileButton extends BaseButton {

    int slot;
    StartWindow startWindow;

    public NewFileButton(int slot, StartWindow startWindow) {

        super("Nueva Partida");
        this.slot = slot;
        addActionListener(new NewPlayerEvent(slot, startWindow));
    }
}