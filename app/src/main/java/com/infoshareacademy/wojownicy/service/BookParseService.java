package com.infoshareacademy.wojownicy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.wojownicy.clas.Book;
import com.infoshareacademy.wojownicy.repository.BookRepository;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BookParseService {

  private ObjectMapper mapper = new ObjectMapper();

  public void parseFileToObjects() {
    BookService bookService = new BookService();
    try {
      BookRepository.bookRepository = mapper
          .readValue(new File("books.json"), new TypeReference<List<Book>>() {
          });
      bookService.setIdForBooks();
      bookService.checkForMaxId();
      bookService.setFavouriteForBooks();
    } catch (IOException e) {
      System.out.println("Problem with IO occurred");
    }
  }

  public void saveObjectsToFile() {
    try {
      mapper.writeValue(new File("books.json"), BookRepository.getBookRepository());
    } catch (IOException e) {
      System.out.println("Problem with IO occurred");
    }
  }
}

