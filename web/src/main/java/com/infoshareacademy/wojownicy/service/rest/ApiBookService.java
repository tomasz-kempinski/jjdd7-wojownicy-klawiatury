package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.domain.view.BookLiveSearchView;
import com.infoshareacademy.wojownicy.mapper.BookMapper;
import com.infoshareacademy.wojownicy.service.BookService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ApiBookService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private BookService bookService;

  @EJB
  private BookMapper bookMapper;

  public List<BookLiveSearchView> getLiveSearchBookTitle(String searchParam) {
    logger.info("books with " + searchParam + " in it were mapped");
    List<BookLiveSearchView> bookLiveSearchViews = new ArrayList<>();
    bookService.findBookForLiveSearch(searchParam).forEach(
        i -> bookLiveSearchViews.add(bookMapper.mapBookEntityForLiveSearch(i)));
    return bookLiveSearchViews;
  }
}
