package com.infoshareacademy.wojownicy.repository;

import static com.infoshareacademy.wojownicy.repository.BookRepository.getBookRepository;
import static org.junit.jupiter.api.Assertions.*;

import com.infoshareacademy.wojownicy.clas.Book;
import java.util.List;
import org.junit.jupiter.api.Test;

class BookListTest {

  @Test
  void listBooks() {
    List<Book> booksList = getBookRepository();

    assertNotNull(booksList);
  }
}