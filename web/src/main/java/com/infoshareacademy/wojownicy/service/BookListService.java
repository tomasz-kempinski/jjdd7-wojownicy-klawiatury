package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class BookListService {

  @Inject
  BookDaoBean bookDaoBean;

  public Map<String, Object> pages(long currentPage) {
    Map<String, Object> pagesMap = new HashMap<>();
    pagesMap.put("first", 1);
    pagesMap.put("previous-1", currentPage - 2);
    pagesMap.put("previous", currentPage - 1);
    pagesMap.put("current", currentPage);
    pagesMap.put("next", currentPage + 1);
    pagesMap.put("third", currentPage + 2);
    int bookSize = bookDaoBean.numberOfBooks();
    if (bookSize % 10 == 0) {
      pagesMap.put("last", bookSize / 10);
    } else {
      pagesMap.put("last", bookSize / 10 + 1);
    }
    return pagesMap;
  }

  public List<Book> partOfBooks(long from, long to) {
    return bookDaoBean.getPartOfBooks(from, to);
  }
}