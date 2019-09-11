package com.infoshareacademy.wojownicy.mapper;


import com.infoshareacademy.wojownicy.clas.BookJsonClass;
import com.infoshareacademy.wojownicy.domain.Book;
import javax.ejb.Stateless;

@Stateless
public class Mapper {

  public Book mapBooksApiToEntity(BookJsonClass apiAdress){

    Book book = new Book();
    book.setTitle(apiAdress.getTitle());
    book.getAuthor().setAuthorName(apiAdress.getAuthor());
    book.getGenres().add()
    book.getKind().setKind(apiAdress.getKind());
    book.setHasAudio(apiAdress.getHasAudio());
  }

}
