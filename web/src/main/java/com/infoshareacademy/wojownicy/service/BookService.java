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

  @EJB
  private AuthorDaoBean authorDaoBean;

  @EJB
  private BookMapper bookMapper;

  public List<Book> findBookForLiveSearchTitle(String searchTitle) {
    return bookDaoBean.findBookByLiveSearchTitle(searchTitle);
  }

  public List<Author> findBookForLiveSearchAuthor(String searchAuthor) {
    return authorDaoBean.findAuthorByLiveSearchAuthor(searchAuthor);
  }

  public List<BookDto> findBookForLiveSearchAuthorId(Long id) {
    List<Book> booksByAuthorId = bookDaoBean.findBookByLiveSearchAuthorId(id);
    List<BookDto> bookDtoList = new ArrayList<>();
    for (Book book : booksByAuthorId) {
      bookDtoList.add(bookMapper.mapEntityToDto(book));
    }
    return bookDtoList;
  }
}
