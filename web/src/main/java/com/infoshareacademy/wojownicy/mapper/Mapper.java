package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.dao.AuthorDaoBean;
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
  AuthorDaoBean authorDaoBean;

  @Inject
  KindDaoBean kindDaoBean;

  public Book mapBooksApiToEntity(com.infoshareacademy.wojownicy.domain.api.Book booksApi) {

    Genre genre = new Genre();

    Book book = new Book();

    Author author = new Author();

    Kind kind = new Kind();

    book.setTitle(booksApi.getTitle());

    author.setAuthorName(booksApi.getAuthor());
    authorDaoBean.getOrAddAuthor(author.getAuthorName());

    if(authorDaoBean.getAuthorByName(author.getAuthorName()) == null) {
      book.setAuthor(author);
    } else {
      book.setAuthor(authorDaoBean.getAuthorByName(author.getAuthorName()).get(0));
    }

    genre.setGenreName(booksApi.getGenre());
    book.getGenres().add(genre);

    kind.setKind(booksApi.getKind());
    kindDaoBean.getOrAddKind(kind.getKind());

    if (kindDaoBean.getKindByName(kind.getKind()) == null){
      book.setKind(kind);
    } else {
      book.setKind(kindDaoBean.getKindByName(kind.getKind()).get(0));
    }

    book.setCoverURL(booksApi.getCover());

    book.setHasAudio(booksApi.getHasAudio());

    return book;
  }
}
