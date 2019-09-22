package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BookService {

  @EJB
  private BookDaoBean bookDaoBean;

  public List<Book> findBookForLiveSearchTitle(String searchTitle) {
    return bookDaoBean.findBookByLiveSearchTitle(searchTitle);
  }
  public List<Book> findBookForLiveSearchAuthor(String searchAuthor) {
    return bookDaoBean.findBookByLiveSearchAuthor(searchAuthor);
  }
}
