package com.infoshareacademy.wojownicy.repository;

import static com.infoshareacademy.wojownicy.repository.BookRepository.getBookJsonClassRepository;

import com.infoshareacademy.wojownicy.service.BooksPrinter;


public class BookList {

  public void listBooks() {
    BooksPrinter.printListOfBooks(getBookJsonClassRepository());
  }
}

