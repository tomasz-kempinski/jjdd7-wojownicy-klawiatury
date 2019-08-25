package com.infoshareacademy.wojownicy.repository;

import com.infoshareacademy.wojownicy.clas.Book;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

  public static List<Book> bookRepository = new ArrayList<>();

  public static List<Book> getBookRepository() {
    return bookRepository;
  }
}
