package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.view.AuthorLiveSearchView;
import com.infoshareacademy.wojownicy.domain.view.BookLiveSearchView;
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
    bookDto.setAuthor(book.getAuthor());
    bookDto.setCover(book.getCoverURL());
    bookDto.setKind(book.getKind());
    bookDto.setThumbnail(book.getThumbnail());

    book.getGenres().forEach(g -> {
      bookDto.getGenresList().add(genreMapper.mapEntityToDto(g));
    });

    bookDto.setGenreName(bookDto.getGenresList().get(0).getName());
    return bookDto;
  }

  public BookLiveSearchView mapBookEntityForLiveSearch(Book book) {
    BookLiveSearchView bookLiveSearchView = new BookLiveSearchView();
    bookLiveSearchView.setId(book.getId());
    bookLiveSearchView.setTitle(book.getTitle());
    return bookLiveSearchView;
  }

  public AuthorLiveSearchView mapBookEntityForLiveSearchAuthor(Book book) {
    AuthorLiveSearchView authorLiveSearchView = new AuthorLiveSearchView();
    authorLiveSearchView.setId(book.getId());
    authorLiveSearchView.setTitle(book.getTitle());
    authorLiveSearchView.setAuthorId(book.getAuthor().getAuthorId());
    authorLiveSearchView.setAuthorName(book.getAuthor().getAuthorName());
    return authorLiveSearchView;
  }
}
