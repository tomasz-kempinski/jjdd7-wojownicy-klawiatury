package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Book;
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

  public Book getBookById(Long id) {
    return entityManager.find(Book.class, id);
  }

  public List<Book> getBooksList() {
    Query query = entityManager.createNamedQuery("Book.findBookList");
    return query.getResultList();
  }

  public List<Book> getBooksByParam(String searchParam) {
    Query query = entityManager.createNamedQuery("Book.findBooksByParam")
            .setParameter("searchParam", '%' + searchParam + '%');
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
