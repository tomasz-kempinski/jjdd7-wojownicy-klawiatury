package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.dto.BookDto;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BookMapper {

  @Inject
  private GenreMapper genreMapper;

  public BookDto mapEntityToDto(Book book){

    BookDto bookDto = new BookDto();
    bookDto.setId(book.getId());
    bookDto.setTitle(book.getTitle());

    book.getGenres().forEach(g -> {
      bookDto.getGenresList().add(genreMapper.mapEntityToDto(g));
    });
    return bookDto;
  }

}
