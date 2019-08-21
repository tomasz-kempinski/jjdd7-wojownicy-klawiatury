package com.infoshareacademy;

import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        BookFilterService bookFilterService = new BookFilterService();
        bookFilterService.filterByCategory();
        //Menu menu = new Menu();
        //menu.menu();
    }
}
