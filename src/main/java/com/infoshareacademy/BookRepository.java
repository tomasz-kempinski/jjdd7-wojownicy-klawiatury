package com.infoshareacademy;


import java.util.ArrayList;
import java.util.List;

class BookRepository {

    public static List<Book> bookRepository = new ArrayList<>();
    private static BookParseService bookParseService = new BookParseService();

    public static List<Book> getBookRepository() {
        bookParseService.parseFileToObjects();
        return bookRepository;
    }
}




