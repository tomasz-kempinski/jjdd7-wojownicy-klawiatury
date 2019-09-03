package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookRepositoryDao;
import com.infoshareacademy.wojownicy.domain.Book;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BookService {

  @EJB
  private BookRepositoryDao bookRepositoryDao;

  public Book findBookByTitle(String title) {
    return bookRepositoryDao.getBookByTitle(title);
  }

  public Book findBookByAuthor(String author) {
    return bookRepositoryDao.getBookByTitle(author);
  }
}
