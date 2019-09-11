package com.infoshareacademy.wojownicy.repository;

import com.infoshareacademy.wojownicy.clas.BookJsonClass;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

  public static List<BookJsonClass> bookJsonClassRepository = new ArrayList<>();

  public static List<BookJsonClass> getBookJsonClassRepository() {
    return bookJsonClassRepository;
  }
}
