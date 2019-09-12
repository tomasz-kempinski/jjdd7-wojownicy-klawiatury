package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.domain.Genre;
import javax.ejb.Stateless;

@Stateless
public class Mapper {

  public Book mapBooksApiToEntity(com.infoshareacademy.wojownicy.JsonClass.Book booksApi) {

    Genre genre = new Genre();

    Book book = new Book();

    book.setTitle(booksApi.getTitle());

    book.getAuthor().setAuthorName(booksApi.getAuthor());

    genre.setGenreName(booksApi.getGenre());
    book.getGenres().add(genre);

    book.getKind().setKind(booksApi.getKind());

    book.setCoverURL(booksApi.getCover());

    book.setHasAudio(booksApi.getHasAudio());

    return book;
  }
}
