package br.com.job.utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class FileHandler {

    private static String sep = System.getProperty("file.separator");
    private static String dir = System.getProperty("user.dir");

    public static InputStream getImage(String name) {
        try {
            return new FileInputStream(dir + sep + "images" + sep + name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveImage(Image image, String name) {
        File outputFile = new File(dir + sep + "images" + sep + name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
