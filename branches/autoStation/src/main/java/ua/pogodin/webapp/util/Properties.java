package ua.pogodin.webapp.util;

import java.io.IOException;

/**
 * Project Properties. Loads properties from project.properties file.<br/>
 * Usage: <code>Properties.get("database.username")</code>
 */
public class Properties extends java.util.Properties {
    private static final String PROJECT_PROPERTY_FILE_PATH = "/project.properties";

    private static Properties properties = new Properties();

    private Properties() {
        try {
            load(getClass().getResourceAsStream(PROJECT_PROPERTY_FILE_PATH));
        } catch (IOException e) {
            throw new Error("Can't read project property file " + PROJECT_PROPERTY_FILE_PATH, e);
        }
    }

    public static String get(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
