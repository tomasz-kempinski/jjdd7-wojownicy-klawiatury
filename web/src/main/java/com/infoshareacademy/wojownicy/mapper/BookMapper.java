package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.domain.entity.Author;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.view.BookLiveSearchView;
import javax.ejb.Stateless;

@Stateless
public class BookMapper {

  public BookLiveSearchView mapBookForLiveSearch(Book book) {
    Author author = new Author();
    BookLiveSearchView bookLiveSearchView = new BookLiveSearchView();
    bookLiveSearchView.setTitle(book.getTitle());
    bookLiveSearchView.setAuthor(book.getAuthor(author));
    return bookLiveSearchView;
  }

}
