package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BookDaoBeen {

  @PersistenceContext
  EntityManager entityManager;


  public Book getBookByTitle(String title) {
    return entityManager.find(Book.class, title);
  }

  public List<Book> getBookList(String title) {
    Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.title LIKE '%" + title + "'");
    return query.getResultList();
  }


  public void addBook(Book book) {
    entityManager.persist(book);
  }

}
