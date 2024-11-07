package rpg.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.border.EmptyBorder;


public interface WindowConstants {

    Dimension WINDOW_SIZE = new Dimension(1500, 600);
    Insets WINDOW_INSETS = new Insets(10, 10, 10, 10);

        /**
         * Ancho de la ventana.
         */
        int WINDOW_WIDTH = 1500;
        /**
         * Alto de la parte superior de la ventana.
         */
        int TOP_HEIGHT = 150;
        /**
         * Alto de la parte media de la ventana.
         */
        int MIDDLE_HEIGHT = 300;
        /**
         * Alto de la parte inferior de la ventana.
         */
        int BOTTOM_HEIGHT = 150;
        /**
         * Margen simple.
         */
        int SIMPLE_MARGIN = 18;
        /**
         * Dimensión de la parte superior de la ventana.
         */
        Dimension TOP_DIMENSION = new Dimension(WINDOW_WIDTH, TOP_HEIGHT);
        /**
         * Dimensión de la parte media de la ventana.
         */
        Dimension MIDDLE_DIMENSION = new Dimension(WINDOW_WIDTH, MIDDLE_HEIGHT);
        /**
         * Dimensión de la parte inferior de la ventana.
         */
        Dimension BOTTOM_DIMENSION = new Dimension(WINDOW_WIDTH, BOTTOM_HEIGHT);
        /**
         * Borde vacío de margen simple. Que se puede usar para dar un margen a los paneles.
         */
        EmptyBorder EMPTY_BORDER = new EmptyBorder(SIMPLE_MARGIN, SIMPLE_MARGIN, SIMPLE_MARGIN, SIMPLE_MARGIN);
    }

