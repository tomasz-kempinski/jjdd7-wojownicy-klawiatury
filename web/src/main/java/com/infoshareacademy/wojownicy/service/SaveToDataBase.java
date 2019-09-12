package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.api.Book;
import com.infoshareacademy.wojownicy.mapper.Mapper;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;

public class SaveToDataBase {

  @Inject
  private ApiConsumerBooks apiConsumerBooks;

  @Inject
  private BookDaoBean bookDaoBean;

  @Inject
  Mapper mapper;

  public void saveBooksFromApi() {
    try {
      List<Book> booksList = apiConsumerBooks.consumeBooks();
      booksList.forEach(books -> {
            com.infoshareacademy.wojownicy.domain.entity.Book book = mapper.mapBooksApiToEntity(books);
            bookDaoBean.addBook(book);
          }
      );
    } catch (IOException e) {
    }
  }
}
