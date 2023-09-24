package com.amazon.util;

import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertyFileReader {

    public static String getValue(String keyword) throws MalformedURLException {

        File file = new File("src/main/resources");
        URL[] urls = {file.toURI().toURL()};
        ClassLoader loader = new URLClassLoader(urls);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("test", Locale.getDefault(), loader);

        return resourceBundle.getString(keyword);
    }
}
