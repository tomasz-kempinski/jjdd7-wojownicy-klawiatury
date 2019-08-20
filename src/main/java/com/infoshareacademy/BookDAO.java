package com.infoshareacademy;

import static com.infoshareacademy.Parser.getBooksTemplate;

import java.util.List;

public class BookDAO {

  private static List<Book> books = getBooksTemplate();

  public static List<Book> getBooks() {
    return books;
  }
}
