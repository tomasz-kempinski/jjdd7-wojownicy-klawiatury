package com.infoshareacademy.wojownicy.service;

import static org.junit.jupiter.api.Assertions.*;

import com.infoshareacademy.wojownicy.clas.Book;
import com.infoshareacademy.wojownicy.repository.BookRepository;
import java.util.List;
import org.junit.jupiter.api.Test;

class BookParseServiceTest {

  @Test
  void parseFileToObjects_TestIfBooksListIsNotNull() {
    BookParseService parseBookList = new BookParseService();
    parseBookList.parseFileToObjects();
    List<Book> books = BookRepository.getBookRepository();

    assertNotNull(books);
  }
}