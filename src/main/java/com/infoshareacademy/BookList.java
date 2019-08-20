package com.infoshareacademy;

import static com.infoshareacademy.Parser.getBooks;

import java.util.List;

class BookList {

  void listBooks() {
    List<Book> books = getBooks();
    BooksPrinter.printListOfBooks(books);
  }
}
