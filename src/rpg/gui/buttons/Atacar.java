package rpg.gui.buttons;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Atacar extends JButton {

    public Atacar() {
        super("Atacar");  // Texto en el botón
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("¡Botón de ataque presionado!");
            }
        });
    }
}
