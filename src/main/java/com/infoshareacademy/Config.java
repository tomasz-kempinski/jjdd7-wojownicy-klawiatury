package com.infoshareacademy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public void loadConfig(String property) {
        try {
            Properties config = new Properties();
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            config.load(fileInputStream);
            config.getProperty(property);
        } catch (IOException e) {
            System.out.println("Problem with IO occurred");
        } catch (NullPointerException n) {
            System.out.println("Problem with NullPointerException");
        }
    }
}
