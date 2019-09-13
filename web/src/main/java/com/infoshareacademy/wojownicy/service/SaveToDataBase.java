package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.api.Book;
import com.infoshareacademy.wojownicy.mapper.Mapper;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class SaveToDataBase {

  @Inject
  private ApiConsumerBooks apiConsumerBooks;

  @Inject
  private BookDaoBean bookDaoBean;

  @Inject
  private ParseService parseService;

  @Inject
  Mapper mapper;

  public void saveBooksFromApi() {
    try {
      List<Book> booksList = parseService.parseBooksFromJson();


      booksList.forEach(b -> {
            com.infoshareacademy.wojownicy.domain.entity.Book book = mapper.mapBooksApiToEntity(b);
            bookDaoBean.editBook(book);
          }
      );
    } catch (IOException e) {

    }
  }
}
