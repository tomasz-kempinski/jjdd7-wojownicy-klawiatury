package com.infoshareacademy;

import com.infoshareacademy.repository.BookRepository;

public class BookService {

  public void setIdForBooks(){
    for (Book book : BookRepository.getBooks()){
      if(book.getId() == null){
        book.setId(BookRepository.getCurrentId());
        BookRepository.increaseCurrentId();
      }
    }
  }

  public void setFavouriteForBooks(){
    for (Book book : BookRepository.getBooks()){
      if(book.getFavourite() == null){
        book.setFavourite(false);
      }
    }
  }
}
