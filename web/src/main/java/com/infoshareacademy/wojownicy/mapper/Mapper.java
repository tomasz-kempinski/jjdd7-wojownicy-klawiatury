package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.dao.AuthorDaoBean;
import com.infoshareacademy.wojownicy.dao.GenreDaoBean;
import com.infoshareacademy.wojownicy.dao.KindDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Genre;
import com.infoshareacademy.wojownicy.domain.entity.Kind;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Mapper {

  @EJB
  private AuthorDaoBean authorDaoBean;

  @EJB
  private KindDaoBean kindDaoBean;

  @EJB
  private GenreDaoBean genreDaoBean;

  public Book mapBooksApiToEntity(com.infoshareacademy.wojownicy.domain.api.Book booksApi) {

    Genre genre = new Genre();

    Book book = new Book();

    Author author = new Author();

    Kind kind = new Kind();

    book.setTitle(booksApi.getTitle());

    author.setAuthorName(booksApi.getAuthor());
    List<Author> authorList = authorDaoBean.getAuthorByName(author.getAuthorName());

    if (authorList.isEmpty()) {
      book.setAuthor(author);
    } else {
      book.setAuthor(authorList.get(0));
    }

    genre.setGenreName(booksApi.getGenre());
    List<Genre> genreList = genreDaoBean.getGenreByName(genre.getGenreName());

    if (genreList.isEmpty()) {
      book.getGenres().add(genre);
    } else {
      book.setGenres(genreList);
    }

    kind.setKind(booksApi.getKind());
    List<Kind> kindList = kindDaoBean.getKindByName(kind.getKind());

    if (kindList.isEmpty()) {
      book.setKind(kind);
    } else {
      book.setKind(kindList.get(0));
    }

    book.setCoverURL(booksApi.getCover());

    book.setThumbnail(booksApi.getThumbnail());

    book.setHasAudio(booksApi.getHasAudio());

    return book;
  }
}
