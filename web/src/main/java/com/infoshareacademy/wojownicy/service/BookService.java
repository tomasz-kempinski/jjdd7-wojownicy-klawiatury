package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.AuthorDaoBean;
import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.dto.BookDto;
import com.infoshareacademy.wojownicy.mapper.BookMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BookService {

  @EJB
  private BookDaoBean bookDaoBean;

  public List<Book> findBookForLiveSearch(String searchParam) {
    return bookDaoBean.findBookByLiveSearch(searchParam);
  }
}
