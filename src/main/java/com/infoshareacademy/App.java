package com.infoshareacademy;

import java.util.List;

import static com.infoshareacademy.BookRepository.getBooks;

public class App {
    public static void main(String[] args) {
//        Parser parser = new Parser();
//        parser.parseFileToObjects();
//        Menu menu = new Menu();
//        menu.menu();
        List<Book> books = getBooks();
        Filtration filtration = new Filtration();
        filtration.filtrationByGenre();
    }
}
