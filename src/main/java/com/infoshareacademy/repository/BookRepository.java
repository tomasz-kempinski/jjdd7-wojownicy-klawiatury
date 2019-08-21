package com.infoshareacademy.repository;

import static com.infoshareacademy.Parser.getBooksTemplate;

import com.infoshareacademy.Book;
import java.util.List;

public class BookRepository {

  private static List<Book> books = getBooksTemplate();

  public static List<Book> getBooks() {
    return books;
  }
}
