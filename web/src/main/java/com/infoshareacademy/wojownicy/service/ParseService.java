package com.infoshareacademy.wojownicy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.wojownicy.clas.Book;
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
}
