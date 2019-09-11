package com.infoshareacademy.wojownicy.service;

import static org.junit.jupiter.api.Assertions.*;

import com.infoshareacademy.wojownicy.clas.BookJsonClass;
import com.infoshareacademy.wojownicy.repository.BookRepository;
import java.util.List;
import org.junit.jupiter.api.Test;

class BookJsonClassParseServiceTest {

  @Test
  void parseFileToObjects_TestIfBooksListIsNotNull() {
    BookParseService parseBookList = new BookParseService();
    parseBookList.parseFileToObjects();
    List<BookJsonClass> bookJsonClasses = BookRepository.getBookJsonClassRepository();

    assertNotNull(bookJsonClasses);
  }
}