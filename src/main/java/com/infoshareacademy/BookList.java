package com.infoshareacademy;

import java.util.List;

import static com.infoshareacademy.Parser.getBooks;

class BookList {

  void listBooks() {
    List<Book> books = getBooks();
    BooksPrinter.printListOfBooks(books);
  }
}
