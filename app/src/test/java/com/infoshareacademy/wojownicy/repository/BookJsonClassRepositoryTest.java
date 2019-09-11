package com.infoshareacademy.wojownicy.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.infoshareacademy.wojownicy.clas.BookJsonClass;
import java.util.List;
import org.junit.jupiter.api.Test;

class BookJsonClassRepositoryTest {

  private BookJsonClass bookJsonClass1 = new BookJsonClass("drama", "Romeo and Juliet", "William Shakespeare", true,
      "tragedy");
  private BookJsonClass bookJsonClass2 = new BookJsonClass("epic", "The Lord Of The Rings", "J. R. R. Tolkien", false,
      "fantasy");

  @Test
  void getBookRepository_isNotEmpty() {

    BookRepository.bookJsonClassRepository.add(bookJsonClass1);
    BookRepository.bookJsonClassRepository.add(bookJsonClass2);

    List<BookJsonClass> output = BookRepository.getBookJsonClassRepository();

    assertThat(output).isNotEmpty()
        .contains(bookJsonClass1, bookJsonClass2);
  }
}