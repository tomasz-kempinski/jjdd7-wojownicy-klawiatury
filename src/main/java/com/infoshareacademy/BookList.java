package com.infoshareacademy;

import com.infoshareacademy.repository.BookRepository;

public class BookList {

  public void listBooks() {
    BooksPrinter.printListOfBooks(BookRepository.getBooks());
  }
}