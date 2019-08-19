package com.infoshareacademy;

import java.util.Collections;

public class BookSorter {
    private Config config = new Config();

    public void sortByAuthor(){
        config.loadConfig("sortByAuthor");
        config.getProperty();
    }

    public void sortByTitle(){
        config.loadConfig("sortByTitle");
        config.getProperty();
    }
}
