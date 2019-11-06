package br.com.job.utils;

import java.io.InputStream;

public class FileHandler {

    private static String sep = System.getProperty("file.separator");

    public static InputStream getImage(String name) {
        return new FileHandler().getClass().getResourceAsStream("images" + sep + name);
    }

}
