package com.infoshareacademy.wojownicy.repository;

import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.service.DataParseServiceFromJson;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

  public static List<Book> bookRepository = new ArrayList<>();
  public static List<Book> getBookRepository() {
    return bookRepository;
  }

}
