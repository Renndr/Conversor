package Errores;

import javax.swing.ImageIcon;

public class ImageLoader {

    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ImageLoader.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
