package com.infoshareacademy.wojownicy.service.rest;

import com.infoshareacademy.wojownicy.dto.BookDto;
import com.infoshareacademy.wojownicy.mapper.BookMapper;
import com.infoshareacademy.wojownicy.service.BookListService;
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
  private BookListService bookListService;

  @EJB
  private BookMapper bookMapper;

  public List<BookDto> getLiveSearchBook(String searchTitle) {
    logger.info("books with " + searchTitle + " in it were mapped");
    List<BookDto> bookLiveSearchList = new ArrayList<>();
    bookListService.findBookForLiveSearch(searchTitle).forEach(
        i -> bookLiveSearchList.add(bookMapper.mapEntityToDto(i)));
    return bookLiveSearchList;
  }
}
