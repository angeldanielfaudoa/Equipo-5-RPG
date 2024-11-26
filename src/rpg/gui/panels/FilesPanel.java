package rpg.gui.panels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;

public class FilesPanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("borderPanel",
                "Paneles/borderPanel.png"));
        setDimension(WindowConstants.FILES_PANEL_DIMENSION);
    }
}