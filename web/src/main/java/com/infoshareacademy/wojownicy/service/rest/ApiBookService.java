package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.domain.view.BookLiveSearchView;
import com.infoshareacademy.wojownicy.mapper.BookMapper;
import com.infoshareacademy.wojownicy.service.BookService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ApiBookService {

  @EJB
  private BookService bookService;

  @EJB
  private BookMapper bookMapper;

  public List<BookLiveSearchView> getLiveSearchBook (String bookTitle) {
    List<BookLiveSearchView> bookLiveSearchViews = new ArrayList<>();
    bookService.findBookBySearchParam(bookTitle).forEach(
        i -> bookLiveSearchViews.add(bookMapper.mapBookForLiveSearch(i)));
    return bookLiveSearchViews;
  }
}
