package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

class BookParseService {

  void parseFileToObjects() {
    ObjectMapper mapper = new ObjectMapper();
    try {
      BookRepository.bookRepository = mapper
          .readValue(new File("books.json"), new TypeReference<List<Book>>() {
          });
    } catch (IOException e) {
      System.out.println("Problem with IO occurred");
    }
  }
}

