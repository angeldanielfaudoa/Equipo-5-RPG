package rpg.gui.buttons;

import rpg.gui.buttons.events.NewFileEvent;
import rpg.NewFileWindow;
import rpg.gui.StartWindow;

public class CreateButton extends BaseButton {

    public CreateButton(int slot, NewFileWindow window) {

        super("¡A la aventura!");
        addActionListener(new NewFileEvent(slot, window));
    }
}