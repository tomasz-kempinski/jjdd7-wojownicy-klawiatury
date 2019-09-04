package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Author;
import com.infoshareacademy.wojownicy.domain.Book;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BookRepositoryDao {

  Book getBookByTitle(String title);
  Author getBookByAuthor(String authorName);

  List<Book> getBookList();

}
