package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Book;
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

  public Book findBookById(Long id){
    return bookDaoBean.getBookById(id);
  }

  public void addBook(Book book){
    bookDaoBean.addBook(book);
  }

  public void updateBook(Book book) {
    bookDaoBean.editBook(book);
  }

  public void deleteBook(Long id) {
    bookDaoBean.deleteBookById(id);
  }
}
