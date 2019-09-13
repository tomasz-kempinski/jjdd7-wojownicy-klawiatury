package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Genre;
import com.infoshareacademy.wojownicy.domain.entity.Kind;
import javax.ejb.Stateless;

@Stateless
public class Mapper {

  public Book mapBooksApiToEntity(com.infoshareacademy.wojownicy.domain.api.Book booksApi) {

    Genre genre = new Genre();

    Book book = new Book();

    Author author = new Author();

    Kind kind = new Kind();

    book.setTitle(booksApi.getTitle());

    author.setAuthorName(booksApi.getAuthor());
    book.setAuthor(author);

    genre.setGenreName(booksApi.getGenre());
    book.getGenres().add(genre);

    kind.setKind(booksApi.getKind());
    book.setKind(kind);

    book.setCoverURL(booksApi.getCover());

    book.setHasAudio(booksApi.getHasAudio());

    return book;
  }
}
