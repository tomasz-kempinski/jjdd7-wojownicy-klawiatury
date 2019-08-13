package com.infoshareacademy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public void loadConfig() throws IOException {
        Properties config = new Properties();
        FileInputStream fileInputStream= new FileInputStream("config.properties");
        config.load(fileInputStream);

    }

}
