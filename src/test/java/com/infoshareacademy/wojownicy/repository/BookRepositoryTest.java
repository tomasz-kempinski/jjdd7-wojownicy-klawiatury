package com.infoshareacademy.wojownicy.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.infoshareacademy.wojownicy.clas.Book;
import java.util.List;
import org.junit.jupiter.api.Test;

class BookRepositoryTest {

  private Book book1 = new Book("drama", "Romeo and Juliet", "William Shakespeare", true,
      "tragedy");
  private Book book2 = new Book("epic", "The Lord Of The Rings", "J. R. R. Tolkien", false,
      "fantasy");

  @Test
  void getBookRepository_isNotEmpty() {

    BookRepository.bookRepository.add(book1);
    BookRepository.bookRepository.add(book2);

    List<Book> output = BookRepository.getBookRepository();

    assertThat(output).isNotEmpty()
        .contains(book1, book2);
  }
}