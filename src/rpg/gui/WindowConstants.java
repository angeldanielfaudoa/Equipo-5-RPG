package rpg.gui;

import rpg.utils.cache.FontCache;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.border.EmptyBorder;


public interface WindowConstants {

    Dimension WINDOW_SIZE = new Dimension(1000, 500);
    Insets WINDOW_INSETS = new Insets(10, 10, 10, 10);
    Font FONT = FontCache.getFont("Arial", Font.PLAIN, 12);
    Font BAR_LABEL_FONT = FontCache.getFont("Arial", Font.PLAIN, 16).deriveFont(16f);
    Font LABEL_FONT = FontCache.getFont("Arial", Font.BOLD, 18).deriveFont(Font.BOLD, 18f);
    int WINDOW_WIDTH = 1200;
    int TOP_HEIGHT = 150;
    int MIDDLE_HEIGHT = 320;
    int BOTTOM_HEIGHT = 350;
    int SIMPLE_MARGIN = 18;
    int CORNER_WIDTH = 52;
    int CORNER_HEIGHT = 77;
    int CENTER_WIDTH = 350 - 2 * CORNER_WIDTH;

    Dimension BAR_ICON = new Dimension(58, 58);
    Dimension BAR_DISPLAY = new Dimension(179, 58);
    Dimension TOP_DIMENSION = new Dimension(WINDOW_WIDTH, TOP_HEIGHT);
    Dimension MIDDLE_DIMENSION = new Dimension(WINDOW_WIDTH, MIDDLE_HEIGHT);
    Dimension BOTTOM_DIMENSION = new Dimension(WINDOW_WIDTH, BOTTOM_HEIGHT);
    Dimension CORNER_DIMENSION = new Dimension(52, 77);
    Dimension CENTER_DIMENSION = new Dimension(CENTER_WIDTH, 77);
    Dimension BAR_LABEL = new Dimension(172, 51);
    EmptyBorder EMPTY_BORDER = new EmptyBorder(14, SIMPLE_MARGIN,
            SIMPLE_MARGIN, SIMPLE_MARGIN);


    Dimension START_WINDOW_DIMENSION = new Dimension(800, 600);
    Dimension FILES_PANEL_DIMENSION = new Dimension(786, 563);
    Dimension NEW_PLAYER_PANEL_DIMENSION = new Dimension(786, 250);



}

