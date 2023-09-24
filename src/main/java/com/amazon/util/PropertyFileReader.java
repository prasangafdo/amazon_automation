package com.amazon.util;

import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertyFileReader {

    public static String getValue(String keyword) {

        File file = new File("src/main/resources");
        URL[] urls = new URL[0];
        try {
            urls = new URL[]{file.toURI().toURL()};
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("===> File not found");
        }
        ClassLoader loader = new URLClassLoader(urls);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("config", Locale.getDefault(), loader);

        return resourceBundle.getString(keyword);
    }
}
