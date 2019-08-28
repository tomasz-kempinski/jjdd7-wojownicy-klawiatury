package com.infoshareacademy.wojownicy.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookFilterServiceTest {

  @Test
  void filterByCategory() {
    BookFilterService bookFilterService = new BookFilterService();

    assertNotNull(bookFilterService);
  }
}