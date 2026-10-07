package com.pm.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {

        String environment = System.getProperty("env", "qa");
        String fileName = "config/" + environment + ".properties";

        try (InputStream inputStream =
                     ConfigManager.class.getClassLoader()
                             .getResourceAsStream(fileName)) {

            if (inputStream == null) {
                throw new IllegalArgumentException(
                        "Configuration file was not found: " + fileName
                );
            }

            properties.load(inputStream);

            System.out.println("======================================");
            System.out.println("Environment : " + environment);
            System.out.println("Config file : " + fileName);
            System.out.println("baseUrl     : " + properties.getProperty("baseUrl"));
            System.out.println("timeout     : " + properties.getProperty("timeout"));
            System.out.println("browser     : " + properties.getProperty("browser"));
            System.out.println("headless    : " + properties.getProperty("headless"));
            System.out.println("======================================");

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load configuration: " + fileName,
                    e
            );
        }
    }

    public static String get(String key) {

        // 1. JVM/System property takes highest priority
        String systemProperty = System.getProperty(key);

        if (systemProperty != null && !systemProperty.isBlank()) {
            return systemProperty.trim();
        }

        // 2. Environment properties file
        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new RuntimeException(
                    "Configuration property not found: " + key
            );
        }

        return value.trim();
    }
}