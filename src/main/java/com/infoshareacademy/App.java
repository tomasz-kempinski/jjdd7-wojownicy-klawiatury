package com.infoshareacademy;


public class App {
    public static void main(String[] args) {
//        Menu menu = new Menu();
//        menu.menu();

        Parser parser = new Parser ( );
        parser.parseFileToObjects ("books.json");
    }
}
