package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

  public static List<Book> bookRepository = new ArrayList<>();

  public static List<Book> getBookRepository() {
    return bookRepository;
  }
}
