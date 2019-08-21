package com.infoshareacademy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private String property;

    public void loadConfig(String cfg) {
        try {
            Properties config = new Properties();
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            config.load(fileInputStream);
            property = config.getProperty(cfg);
        } catch (IOException e) {
            System.out.println("Problem with IO occurred");
        }
    }

    public String getProperty() {
        return property;
    }
}
