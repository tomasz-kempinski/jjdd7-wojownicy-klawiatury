package com.infoshareacademy.wojownicy.repository;

import com.infoshareacademy.wojownicy.domain.Author;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

  public static List<Author> authorRepository = new ArrayList<>();
  public static List<Author> getAuthorRepository() {
    return authorRepository;
  }

}

