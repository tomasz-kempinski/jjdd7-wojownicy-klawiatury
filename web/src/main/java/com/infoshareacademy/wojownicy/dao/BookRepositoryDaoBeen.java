package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Author;
import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.repository.AuthorRepository;
import com.infoshareacademy.wojownicy.repository.BookRepository;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class BookRepositoryDaoBeen implements BookRepositoryDao {

  @Override
  public Book getBookByTitle(String title) {
    return BookRepository.getBookRepository().stream()
        .filter(b -> b.getTitle().equals(title))
        .findFirst().get();
  }

  @Override
  public Author getBookByAuthor(String authorName) {
    return AuthorRepository.getAuthorRepository().stream()
        .filter(a -> a.getAuthorName().equals(authorName))
        .findFirst().get();
  }

  @Override
  public List<Book> getBookList() {
    return BookRepository.getBookRepository();
  }

}
