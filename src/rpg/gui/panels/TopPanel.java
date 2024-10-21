package rpg.gui.panels;

import rpg.utils.cache.ImageCache;
import rpg.gui.WindowConstants;
import javax.swing.*;

public class TopPanel extends BackgroundPanel{
    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("topPanel",
                "panels/statusPanel.png"));
        setDimension(WindowConstants.TOP_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }
}
