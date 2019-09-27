package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.api.Book;
import com.infoshareacademy.wojownicy.mapper.Mapper;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class SaveToDataBase {

  private final Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private ApiConsumerBooks apiConsumerBooks;

  @EJB
  private BookDaoBean bookDaoBean;

  @EJB
  private ParseService parseService;

  @EJB
  private Mapper mapper;

  public void saveBooksFromApi() {
    try {
      List<Book> booksList = apiConsumerBooks.consumeBooks();

      booksList.forEach(b -> {
            com.infoshareacademy.wojownicy.domain.entity.Book book = mapper.mapBooksApiToEntity(b);
            bookDaoBean.addBook(book);
          }
      );
    } catch (IOException e) {
      logger.error("Couldn't connect to remote api");
    }
  }

  public void saveBooksFromFile() {
    try {
      List<Book> booksList = parseService.parseBooksFromJson();

      booksList.forEach(b -> {
            com.infoshareacademy.wojownicy.domain.entity.Book book = mapper.mapBooksApiToEntity(b);
            bookDaoBean.editBook(book);
          }
      );
    } catch (IOException e) {
      logger.error("File with books not found");
    }
  }
}
