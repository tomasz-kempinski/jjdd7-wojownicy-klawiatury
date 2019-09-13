package com.infoshareacademy.wojownicy.mapper;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.infoshareacademy.wojownicy.domain.api.Book;
import org.junit.Test;

public class MapperTest {

  @Test
  public void mapJsonBookToBook() {
    Mapper mapper = new Mapper();

    Book book = new Book();
    book.setTitle("qwe");
    book.setAuthor("qwe");
    book.setGenre("qwe");
    book.setKind("qwe");
    book.setCover("qwe");
    book.setHasAudio(true);

    com.infoshareacademy.wojownicy.domain.entity.Book resultBook = mapper.mapBooksApiToEntity(book);

    assertThat(resultBook.getAuthor().getAuthorName(), is("qwe"));
  }
}
