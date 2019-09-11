package com.infoshareacademy.wojownicy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.wojownicy.clas.BookJsonClass;
import com.infoshareacademy.wojownicy.repository.BookRepository;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BookParseService {

  private ObjectMapper mapper = new ObjectMapper();

  public void parseFileToObjects() {
    BookService bookService = new BookService();
    try {
      BookRepository.bookJsonClassRepository = mapper
          .readValue(new File("books.json"), new TypeReference<List<BookJsonClass>>() {
          });
    } catch (IOException e) {
      System.out.println("Problem with IO occurred");
    }
  }
}

