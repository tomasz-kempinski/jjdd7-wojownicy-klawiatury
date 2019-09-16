package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.dto.BookDto;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.view.BookLiveSearchView;
import javax.ejb.Stateless;

@Stateless
public class BookMapper {

  @Inject
  private GenreMapper genreMapper;

  public BookDto mapEntityToDto(Book book) {

    BookDto bookDto = new BookDto();
    bookDto.setId(book.getId());
    bookDto.setTitle(book.getTitle());

    book.getGenres().forEach(g -> {
      bookDto.getGenresList().add(genreMapper.mapEntityToDto(g));
    });
    return bookDto;
  }
  public BookLiveSearchView mapBookForLiveSearch(Book book) {
    BookLiveSearchView bookLiveSearchView = new BookLiveSearchView();
    bookLiveSearchView.setTitle(book.getTitle());
    bookLiveSearchView.setAuthor(book.getAuthor());
    return bookLiveSearchView;
  }

}
