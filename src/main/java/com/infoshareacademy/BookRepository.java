package com.infoshareacademy;

<<<<<<< HEAD
import java.util.List;

class BookRepository {
    static List<Book> books;

    static List<Book> getBooks() {
        return books;
    }
}
=======

import java.util.ArrayList;
import java.util.List;

class BookRepository {

  static List<Book> bookRepository = new ArrayList<>();
  private static BookParseService bookParseService = new BookParseService();

  static List<Book> getBookRepository() {
    bookParseService.parseFileToObjects();
    return bookRepository;
  }
}




>>>>>>> JJDD7WK-9
