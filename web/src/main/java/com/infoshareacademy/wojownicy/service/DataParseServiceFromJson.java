package com.infoshareacademy.wojownicy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.wojownicy.domain.Author;
import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.repository.AuthorRepository;
import com.infoshareacademy.wojownicy.repository.BookRepository;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DataParseServiceFromJson {

  private ObjectMapper mapper = new ObjectMapper();

  public void parseBookToObjects() {
    try {
      BookRepository.bookRepository = mapper
          .readValue(new File("books.json"), new TypeReference<List<Book>>() {
          });
    } catch (IOException e) {
      System.out.println("Problem with IO occurred");
    }
  }

  public void parseAuthorToObjects() {
    try {
      AuthorRepository.authorRepository = mapper
          .readValue(new File("books.json"), new TypeReference<List<Author>>() {
          });
    } catch (IOException e) {
      System.out.println("Problem with IO occurred");
    }
  }

}