package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.clas.Book;
import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;

public class SaveToDataBase {

  @Inject
  private ApiConsumer apiConsumer;

  @Inject
  private BookDaoBean bookDaoBean;

//  @Inject
//  todo inject mapper when ready


  public void saveBooksFromApi() {
//    try {
//      List<Book> booksList = apiConsumer.consumeBooks();
//      booksList.forEach(books -> {
//        com.infoshareacademy.wojownicy.domain.Book book = booksMapper
//            .mapBooks(books);   //todo change to our proper method when ready
//        bookDaoBean.addBook(book);
//      });
//    } catch (IOException e) {
//    }
  }

}
