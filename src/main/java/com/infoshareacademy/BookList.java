package com.infoshareacademy;

import java.util.List;

import static com.infoshareacademy.BookRepository.getBookRepository;

class BookList {

  void listBooks() {
    List<Book> books = getBookRepository();
    BooksPrinter.printListOfBooks(books);
  }
}
