package com.amazon.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyFileReader {

    static String filename;
    private static final Logger logger = Logger.getLogger(PropertyFileReader.class.getName());

    public static String getConfigValue(String keyword) {
        filename = "config";
        return getValue(filename,keyword);
    }

    public static String getTestDataValue(String keyword){
        filename = "testdata";
        return getValue(filename,keyword);
    }

    public static String getValue(String filename, String keyword){
        File file = new File("src/main/resources");
        URL[] urls = new URL[0];
        try {
            urls = new URL[]{file.toURI().toURL()};
        } catch (MalformedURLException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "File not found");
        }
        ClassLoader loader = new URLClassLoader(urls);
        ResourceBundle resourceBundle = ResourceBundle.getBundle(filename, Locale.getDefault(), loader);

        return resourceBundle.getString(keyword);
    }
}
