package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.AuthorDaoBeen;
import com.infoshareacademy.wojownicy.domain.Author;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AuthorService {

  @EJB
  private AuthorDaoBeen authorDaoBeen;

  public Author findBookByAuthor(String author) {
    return authorDaoBeen.getBookByAuthor(author);
  }
}