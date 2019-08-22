package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.repository.BookRepository;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Parser {

  private static List<Book> booksTemplate;
  ObjectMapper mapper = new ObjectMapper();

  public void parseFileToObjects() {
    BookService bookService = new BookService();
    try {
      booksTemplate = mapper.readValue(new File("books.json"), new TypeReference<List<Book>>() {
      });
    } catch (IOException e) {
      System.out.println("Problem with IO occurred");
    }
    bookService.checkForMaxId();
    bookService.setIdForBooks();
    bookService.setFavouriteForBooks();
  }

  public void saveObjectsToFile() {
    try {
      mapper.writeValue(new File("books.json"), BookRepository.getBooks());
      {
      }
    } catch (IOException e) {
      System.out.println("Problem with IO occurred");
    }
  }

  public static List<Book> getBooksTemplate() {
    return booksTemplate;
  }
}
