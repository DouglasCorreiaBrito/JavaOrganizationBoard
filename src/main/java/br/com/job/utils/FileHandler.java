package br.com.job.utils;

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
        //return new FileHandler().getClass().getResourceAsStream("images" + sep + name);
    }

}
