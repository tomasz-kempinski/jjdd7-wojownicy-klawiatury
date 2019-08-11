package com.infoshareacademy;
public class App {
    public static void main(String[] args) {
        Parser parser = new Parser ( );
        parser.parseFileToObjects ();
        Menu menu = new Menu();
        menu.menu();

    }
}
