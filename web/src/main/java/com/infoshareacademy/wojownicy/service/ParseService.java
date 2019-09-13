package com.infoshareacademy.wojownicy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.wojownicy.domain.api.Book;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ParseService {

  private ObjectMapper objectMapper = new ObjectMapper();

  public List<Book> parseBooksFromApi(String books) throws IOException {
    JsonNode jsonNode = objectMapper.readTree(books);

    return objectMapper.readValue(jsonNode.toString(),
        new TypeReference<List<Book>>() {
        });
  }

  public List<Book> parseBooksFromJson() throws IOException {
    return objectMapper
        .readValue(new File("/home/robert/jjdd7-wojownicy-klawiatury/books.json"),
            new TypeReference<List<Book>>() {
        });
  }
}

//  public List<Event> parseEvents(String placePathName) throws IOException {
//    return objectMapper.readValue(new File(placePathName), new TypeReference<List<Event>>() {
//    });
//  }

//  public void parseFileToObjects() {
//    BookService bookService = new BookService();
//    try {
//      BookRepository.bookRepository = mapper
//          .readValue(new File("books.json"), new TypeReference<List<Book>>() {
//          });
//      bookService.setIdForBooks();
//      bookService.checkForMaxId();
//      bookService.setFavouriteForBooks();
//    } catch (IOException e) {
//      System.out.println("Problem with IO occurred");
//    }
//  }