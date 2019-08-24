package com.infoshareacademy;

import static com.infoshareacademy.BookRepository.getBookRepository;


public class BookList {

  public void listBooks() {
    BooksPrinter.printListOfBooks(getBookRepository());
  }
}

