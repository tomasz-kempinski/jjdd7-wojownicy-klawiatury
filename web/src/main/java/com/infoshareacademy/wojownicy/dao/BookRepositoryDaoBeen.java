package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.repository.BookRepository;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class BookRepositoryDaoBeen implements BookRepositoryDao {

  @Override
  public Book getBookByTitle(String title) {
    return BookRepository.getBookRepository().stream()
        .filter(u -> u.getTitle().equals(title))
        .findFirst().get();
  }

  @Override
  public Book getBookByAuthor(String author) {
    return BookRepository.getBookRepository().stream()
        .filter(u -> u.getAuthor().equals(author))
        .findFirst().get();
  }

  @Override
  public List<Book> getBookList() {
    return BookRepository.getBookRepository();
  }

}
