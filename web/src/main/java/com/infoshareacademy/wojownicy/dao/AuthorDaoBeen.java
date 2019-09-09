package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Author;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AuthorDaoBeen {

  @PersistenceContext
  EntityManager entityManager;

//  public Author getBookByAuthor(String author) {
//    Query query = entityManager.createNamedQuery("Book.findBookByTitle");
//    query.setParameter("author", author);
//    return (Author) query.getSingleResult();
//  }

  public void addAuthor(Author author) {entityManager.persist(author);}
}
