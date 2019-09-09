package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Book;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BookDaoBeen {

  @PersistenceContext
  EntityManager entityManager;


  public Book searchBook(String title, String order) {
    Query query = entityManager.createNativeQuery(
        "SELECT * FROM book WHERE book_title LIKE '%" + title + "%' ORDER BY " + order);
    return (Book) query.getResultList();
  }


  public void addBook(Book book) {
    entityManager.persist(book);
  }

}
