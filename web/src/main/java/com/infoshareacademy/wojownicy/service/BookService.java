package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.Book;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BookService {

  @EJB
  private BookDaoBean bookDaoBean;


  public void saveBook(Book book) {
    bookDaoBean.addBook(book);
  }

  public List<Book> findBooks(String title) {
    return bookDaoBean.getBookList(title);
  }
}
