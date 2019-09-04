package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookRepositoryDao;
import com.infoshareacademy.wojownicy.domain.Author;
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

  public Author findBookByAuthor(String authorName) {
    return bookRepositoryDao.getBookByAuthor(authorName);
  }
}
