package com.infoshareacademy.wojownicy.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookSearchHandlerTest {

  @Test
  void listFoundBooks_testIfNotNull() {
    BookSearchHandler bookSearchHandler = new BookSearchHandler();

    assertNotNull(bookSearchHandler);
  }
}