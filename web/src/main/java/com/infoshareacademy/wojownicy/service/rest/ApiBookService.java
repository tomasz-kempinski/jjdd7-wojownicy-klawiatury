package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.domain.view.AuthorLiveSearchView;
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

  public List<BookLiveSearchView> getLiveSearchBookTitle(String searchTitle) {
    logger.info("books with " + searchTitle + " in it were mapped");
    List<BookLiveSearchView> bookLiveSearchViews = new ArrayList<>();
    bookService.findBookForLiveSearchTitle(searchTitle).forEach(
        i -> bookLiveSearchViews.add(bookMapper.mapBookEntityForLiveSearch(i)));
    return bookLiveSearchViews;
  }

  public List<AuthorLiveSearchView> getLiveSearchBookAuthor(String searchAuthor) {
    logger.info("books with " + searchAuthor + " in it were mapped");
    List<AuthorLiveSearchView> authorLiveSearchViews = new ArrayList<>();
    bookService.findBookForLiveSearchAuthor(searchAuthor).forEach(
        i -> authorLiveSearchViews.add(bookMapper.mapBookEntityForLiveSearchAuthor(i)));
    return authorLiveSearchViews;
  }
}
