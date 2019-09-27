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

@Transactional
@Stateless
public class BookListService {

  @EJB
  BookDaoBean bookDaoBean;

  @EJB
  BookMapper bookMapper;

  public Map<String, Object> pages(long currentPage, int hasAudio) {
    Map<String, Object> pagesMap = new HashMap<>();
    pagesMap.put("first", 0);
    pagesMap.put("previous-1", currentPage - 2);
    pagesMap.put("previous", currentPage - 1);
    pagesMap.put("current", currentPage);
    pagesMap.put("next", currentPage + 1);
    pagesMap.put("third", currentPage + 2);
    long bookSize = numberOfBooks(hasAudio);
    if (bookSize % 20 == 0) {
      pagesMap.put("last", bookSize / 20 - 1);
    } else {
      pagesMap.put("last", bookSize / 20);
    }
    return pagesMap;
  }

  public List<BookDto> partOfBooks(int from) {
    List<Book> books = bookDaoBean.getPartOfBooks(from);
    List<BookDto> bookDtoList = new ArrayList<>();
    for (Book book : books) {
      bookDtoList.add(bookMapper.mapEntityToDto(book));
    }
    return bookDtoList;
  }

  public List<BookDto> partOfAudioBooks(int from) {
    List<Book> books = bookDaoBean.getPartOfAudioBooks(from);
    List<BookDto> bookDtoList = new ArrayList<>();
    for (Book book : books) {
      bookDtoList.add(bookMapper.mapEntityToDto(book));
    }
    return bookDtoList;
  }

  public BookDto getSingleBook(long id) {

    return bookMapper.mapEntityToDto(bookDaoBean.getBookById(id));
  }

  public boolean hasAudio(long id) {
    Book book = bookDaoBean.getBookById(id);
    return book.isAudio();
  }

  public boolean isReserved(Long id) {
    Book book = bookDaoBean.getBookById(id);
    return book.isReserved();
  }

  public long numberOfBooks(int hasAudio) {
    if (hasAudio == 1) {
      return bookDaoBean.numberOfAudioBooks();
    }
    return bookDaoBean.numberOfBooks();
  }
}