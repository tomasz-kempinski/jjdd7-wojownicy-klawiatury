package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.dto.BookDto;
import com.infoshareacademy.wojownicy.mapper.BookMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@Stateless
public class BookListService {

  @EJB
  BookDaoBean bookDaoBean;

  @EJB
  BookMapper bookMapper;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  public Map<String, Object> pages(long currentPage) {
    Map<String, Object> pagesMap = new HashMap<>();
    pagesMap.put("first", 1);
    pagesMap.put("previous-1", currentPage - 2);
    pagesMap.put("previous", currentPage - 1);
    pagesMap.put("current", currentPage);
    pagesMap.put("next", currentPage + 1);
    pagesMap.put("third", currentPage + 2);
    int bookSize = bookDaoBean.numberOfBooks();
    if (bookSize % 20 == 0) {
      pagesMap.put("last", bookSize / 20);
    } else {
      pagesMap.put("last", bookSize / 20 + 1);
    }
    return pagesMap;
  }

  public List<BookDto> partOfBooks(long from, long to) {
   List<Book> books = bookDaoBean.getPartOfBooks(from, to);
   List<BookDto> bookDtoList = new ArrayList<>();
   for (Book book : books){
     bookDtoList.add(bookMapper.mapEntityToDto(book));
   }
  return  bookDtoList;
  }

  public List<Book> findBookForLiveSearch (String searchTitle) {
    logger.info("Book with title {} found in database", searchTitle);
    return bookDaoBean.findBookByLiveSearch(searchTitle);
  }

  public BookDto getSingleBook(long id) {

   return bookMapper.mapEntityToDto(bookDaoBean.getBookById(id));

  }

  public boolean hasAudio(long id) {
    Book book = bookDaoBean.getBookById(id);
    return book.isAudio();
  }

  public long numberOfBooks() {
    return bookDaoBean.numberOfBooks();
  }
}

//  List<Book> bookList = bookDaoBean.findBookByLiveSearch(searchTitle);
//  List<BookDto> bookDtoList = new ArrayList<>();
//    for (Book book : bookList) {
//        bookDtoList.add(bookMapper.mapEntityToDto(book));
//        }