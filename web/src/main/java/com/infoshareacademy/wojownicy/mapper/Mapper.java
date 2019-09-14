package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.dao.AuthorDaoBean;
import com.infoshareacademy.wojownicy.dao.GenreDaoBean;
import com.infoshareacademy.wojownicy.dao.KindDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Genre;
import com.infoshareacademy.wojownicy.domain.entity.Kind;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Mapper {

  @Inject
  private AuthorDaoBean authorDaoBean;

  @Inject
  private KindDaoBean kindDaoBean;

  @Inject
  private GenreDaoBean genreDaoBean;

  public Book mapBooksApiToEntity(com.infoshareacademy.wojownicy.domain.api.Book booksApi) {

    Genre genre = new Genre();

    Book book = new Book();

    Author author = new Author();

    Kind kind = new Kind();

    book.setTitle(booksApi.getTitle());

    author.setAuthorName(booksApi.getAuthor());
    author = authorDaoBean.getOrAddAuthor(author.getAuthorName()).get(0);
    book.setAuthor(author);

    genre.setGenreName(booksApi.getGenre());
    genre = genreDaoBean.getOrAddGenre(genre.getGenreName()).get(0);
    book.getGenres().add(genre);

    kind.setKind(booksApi.getKind());
    kind = kindDaoBean.getOrAddKind(kind.getKind()).get(0);
    book.setKind(kind);

    book.setCoverURL(booksApi.getCover());

    book.setHasAudio(booksApi.getHasAudio());

    return book;
  }
}
