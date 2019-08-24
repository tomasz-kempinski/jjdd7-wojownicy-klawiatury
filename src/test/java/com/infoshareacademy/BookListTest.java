package com.infoshareacademy;

import static com.infoshareacademy.BookRepository.getBookRepository;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BookListTest {

  @Test
  void listBooks() {
    List<Book> booksList = getBookRepository();

    assertNotNull(booksList);
  }
}