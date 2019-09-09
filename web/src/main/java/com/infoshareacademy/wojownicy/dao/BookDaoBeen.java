package com.infoshareacademy.wojownicy.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BookDaoBeen {

  @PersistenceContext
  EntityManager entityManager;

  public Book getBookByTitle(String title) {
    Query query = entityManager.createNamedQuery("Book.findBookByTitle");
    query.setParameter("title", title);
    return (Book) query.getSingleResult();
  }
}
