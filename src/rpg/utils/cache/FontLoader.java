package rpg.utils.cache;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {

    public static Font loadFont(String path) {
        File fontFile = new File(path);
        if (!fontFile.exists()) {
            JOptionPane.showMessageDialog(null, "La fuente no se encontró en la ruta: " + path,
                    "Error", JOptionPane.ERROR_MESSAGE);
            return new Font("Arial", Font.PLAIN, 12); // Fuente Arial como predeterminada en caso de error
        }

        try (InputStream is = new FileInputStream(fontFile)) {
            return Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la fuente: " + path,
                    "Error", JOptionPane.ERROR_MESSAGE);
            return new Font("Arial", Font.PLAIN, 12); // Fuente Arial como predeterminada en caso de error
        }
    }
}

