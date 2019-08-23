package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

class BookParseService {
  private ObjectMapper mapper = new ObjectMapper();
  void parseFileToObjects() {
    BookService bookService = new BookService();
    try {
      BookRepository.bookRepository = mapper
          .readValue(new File("books.json"), new TypeReference<List<Book>>() {
          });
      bookService.checkForMaxId();
    } catch (IOException e) {
      System.out.println("Problem with IO occurred");
    }
  }
    void saveObjectsToFile() {
      try {
        mapper.writeValue(new File("books.json"), BookRepository.getBookRepository());
      } catch (IOException e) {
        System.out.println("Problem with IO occurred");
      }
    }
  }

