package com.infoshareacademy;

public class BookSorter {
    private Config config = new Config();

    public void sortByAuthor() {
        config.loadConfig("sortByAuthor");
        String property = config.getProperty();
        if (property.equals("ASC")){

        } else if (property.equals("DSC")){

        }
    }

    public void sortByTitle() {
        config.loadConfig("sortByTitle");
        String property = config.getProperty();
        if (property.equals("ASC")){

        } else if (property.equals("DSC")){

        }
    }
}
