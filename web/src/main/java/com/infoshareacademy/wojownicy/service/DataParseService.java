package com.infoshareacademy.wojownicy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.wojownicy.domain.Book;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DataParseService {

  private ObjectMapper objectMapper = new ObjectMapper();

  public List<Book> parseBook (String bookPath) throws IOException {

    return objectMapper.readValue(new File(bookPath), new TypeReference<List<Book>>() {
    });
  }
}