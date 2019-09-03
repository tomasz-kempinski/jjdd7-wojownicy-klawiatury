package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Book;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BookRepositoryDao {

  Book getBookByTitle(String title);
  Book getBookByAuthor(String author);

  List<Book> getBookList();

}
