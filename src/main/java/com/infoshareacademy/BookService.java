package com.infoshareacademy;

import com.infoshareacademy.repository.BookRepository;

public class BookService {
  public void modifyFavouriteBook() {

    BookRepository.getBooks().get(1).setHasAudio(true);
    System.out.println(BookRepository.getBooks().get(1));

  }

}
