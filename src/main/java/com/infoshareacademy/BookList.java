package com.infoshareacademy;

import com.infoshareacademy.repository.BookRepository;

class BookList {

  void listBooks() {
    BooksPrinter.printListOfBooks(BookRepository.getBooks());
  }
}
