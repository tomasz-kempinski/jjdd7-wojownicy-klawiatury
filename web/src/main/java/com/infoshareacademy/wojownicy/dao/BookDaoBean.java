package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BookDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void addBook(Book book) {
    entityManager.persist(book);
  }

  public Book getBookById(long id) {
    return entityManager.find(Book.class, id);
  }

  public List<Book> getBooksList() {
    Query query = entityManager.createNamedQuery("Book.findBookList");
    return query.getResultList();
  }

  public int numberOfBooks() {
    Query query = entityManager.createNamedQuery("Book.listCount");
    Long fromQuery = (Long) query.getSingleResult();
    return fromQuery.intValue();
  }

  public List<Book> getPartOfBooks(long from, long to) {
    Query query = entityManager.createNamedQuery("Book.getPartOfBookList")
        .setParameter(1, from)
        .setParameter(2, to);
    return query.getResultList();
  }

  public List<Book> findBookByLiveSearch(String searchTitle) {

    Query query = entityManager.createNamedQuery("Book.findBookByTitle");
    query.setParameter("searchTitle", "%" + searchTitle + "%");

    return query.getResultList();
  }

  public Book editBook(Book book) {
    return entityManager.merge(book);
  }

  public void deleteBookById(long id) {
    Book book = entityManager.find(Book.class, id);
    if (book != null) {
      entityManager.remove(book);
    }
  }
}
