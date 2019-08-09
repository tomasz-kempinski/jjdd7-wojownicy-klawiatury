package com.infoshareacademy;


public class App {
    public static void main(String[] args) {
        Parser parser = new Parser ( );
        parser.parseFileToObjects ("/home/robert/jjdd7-wojownicy-klawiatury/src/main/resources/books.json");

        Menu menu = new Menu();
        menu.menu();
    }
}
