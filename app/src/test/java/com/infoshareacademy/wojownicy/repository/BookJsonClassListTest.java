package com.infoshareacademy.wojownicy.repository;

import static com.infoshareacademy.wojownicy.repository.BookRepository.getBookJsonClassRepository;
import static org.junit.jupiter.api.Assertions.*;

import com.infoshareacademy.wojownicy.clas.BookJsonClass;
import java.util.List;
import org.junit.jupiter.api.Test;

class BookJsonClassListTest {

  @Test
  void listBooks() {
    List<BookJsonClass> booksList = getBookJsonClassRepository();

    assertNotNull(booksList);
  }
}