package com.infoshareacademy.repository;

import static com.infoshareacademy.Parser.getBooksTemplate;

import com.infoshareacademy.Book;
import java.util.List;

public class BookRepository {

  private static Long maxId = 0L;

  private static List<Book> books = getBooksTemplate();

  public static List<Book> getBooks() {
    return books;
  }

  public static Long getCurrentId() {
    return maxId;
  }

  public static void setCurrentId(Long currentId) {
    BookRepository.maxId = currentId;
  }
}
