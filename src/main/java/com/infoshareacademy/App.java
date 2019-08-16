package com.infoshareacademy;

public class App {
    public static void main(String[] args) {
        BookParseService parser = new BookParseService();
        parser.parseFileToObjects();
        Menu menu = new Menu();
        menu.menu();
    }
}
