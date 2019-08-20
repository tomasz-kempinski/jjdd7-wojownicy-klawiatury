package com.infoshareacademy;

import java.util.List;

import static com.infoshareacademy.Parser.*;

class BookList {

  void listBooks() {
    BooksPrinter.printListOfBooks(BookDAO.getBooks());
  }
}
