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

  public List<Book> findBookForLiveSearch (String searchTitle) {
    return bookDaoBean.findBookByLiveSearch(searchTitle);
  }

}
