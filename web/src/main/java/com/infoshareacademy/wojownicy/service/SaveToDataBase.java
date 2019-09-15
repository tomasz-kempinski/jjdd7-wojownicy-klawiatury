package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.api.Book;
import com.infoshareacademy.wojownicy.mapper.Mapper;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class SaveToDataBase {

  private final Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private ApiConsumerBooks apiConsumerBooks;

  @Inject
  private BookDaoBean bookDaoBean;

  @Inject
  Mapper mapper;

  public void saveBooksFromApi() {
    try {
      List<Book> booksList = apiConsumerBooks.consumeBooks();

      booksList.forEach(b -> {
            com.infoshareacademy.wojownicy.domain.entity.Book book = mapper.mapBooksApiToEntity(b);
            bookDaoBean.editBook(book);
          }
      );
    } catch (IOException e) {
      logger.error("Couldn't connect to remote api");
    }
  }
}
