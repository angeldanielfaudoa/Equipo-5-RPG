package rpg.utils.cache;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FontCache {

    public static final Map<String, Font> cache = new HashMap<>();

    // Constructor estático para cargar "Arial" predeterminada en el cache
    static {
        cache.put("Arial", new Font("Arial", Font.PLAIN, 12));
    }

    public static Font addFont(String fontName, String fontPath) {
        Font font;
        if (!cache.containsKey(fontName)) {
            font = FontLoader.loadFont(fontPath);
            if (font == null) {
                System.err.println("Error al cargar la fuente personalizada. Usando Arial como fuente predeterminada.");
                font = cache.get("Arial"); // Usa Arial ya cargada en el cache
            }
            cache.put(fontName, font);
        } else {
            font = cache.get(fontName);
        }
        return font;
    }

    public static Font getFont(String fontName, int style, int size) {
        Font font = cache.get(fontName);
        if (font == null) {
            System.err.println("Fuente no encontrada en el cache: " + fontName + ". Usando Arial como fuente predeterminada.");
            font = cache.get("Arial"); // Usa Arial ya cargada en el cache
        }
        return font.deriveFont(style, size);
    }

    public static Font getFont(String fontName) {
        return getFont(fontName, Font.PLAIN, 12);
    }

    public static Font getFont(String fontName, int size) {
        return getFont(fontName, Font.PLAIN, size);
    }
}

