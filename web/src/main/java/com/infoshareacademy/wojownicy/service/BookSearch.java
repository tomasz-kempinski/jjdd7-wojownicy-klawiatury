package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBeen;
import com.infoshareacademy.wojownicy.domain.Book;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BookSearch {

  @EJB
  BookDaoBeen bookDaoBeen;

  public List<Book> findBooks(String title) {
    return bookDaoBeen.getBookList(title);
  }
}
