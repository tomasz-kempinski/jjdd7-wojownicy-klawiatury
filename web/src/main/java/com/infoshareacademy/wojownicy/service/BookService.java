package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBeen;
import com.infoshareacademy.wojownicy.domain.Book;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BookService {

  @EJB
  private BookDaoBeen bookDaoBeen;

  public Book findBookByTitle(String title, String order) {
    return bookDaoBeen.searchBook(title, order);
  }

  public void saveBook(Book book) {
    bookDaoBeen.addBook(book);
  }
}
