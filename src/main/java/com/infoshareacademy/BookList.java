package com.infoshareacademy;

class BookList {

  void listBooks() {
    BooksPrinter.printListOfBooks(BookDAO.getBooks());
  }
}
