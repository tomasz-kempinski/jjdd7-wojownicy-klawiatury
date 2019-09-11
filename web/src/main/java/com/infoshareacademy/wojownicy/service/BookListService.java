package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class BookListService  {
  @Inject
  BookDaoBean bookDaoBean;

  public List<Book> getBookList(){
   return bookDaoBean.getBooksList();
  }

  private int bookListSize(){
    return bookDaoBean.getBooksList().size();
  }

  public Map<String,Integer> pages(){
    Map<String, Integer> pagesMap = new HashMap<>();
    if (bookListSize()>3){
      pagesMap.put("first",1);
      pagesMap.put("second",2);
      pagesMap.put("third",3);
      pagesMap.put("last",bookListSize());
    }
    return pagesMap;
  }

}
