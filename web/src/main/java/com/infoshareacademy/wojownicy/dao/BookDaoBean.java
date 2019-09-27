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

  public int numberOfBooks(long kind) {
    if (kind == 1) {
      Query query = entityManager.createNamedQuery("Book.LirykaBookListCount");
      Long fromQuery = (Long) query.getSingleResult();
      return fromQuery.intValue();
    } else if (kind == 2) {
      Query query = entityManager.createNamedQuery("Book.EpikaBookListCount");
      Long fromQuery = (Long) query.getSingleResult();
      return fromQuery.intValue();
    } else if (kind == 3) {
      Query query = entityManager.createNamedQuery("Book.DramatBookListCount");
      Long fromQuery = (Long) query.getSingleResult();
      return fromQuery.intValue();
    }
    Query query = entityManager.createNamedQuery("Book.listCount");
    Long fromQuery = (Long) query.getSingleResult();
    return fromQuery.intValue();
  }

  public int numberOfAudioBooks(long kind) {
    if (kind == 1) {
      Query query = entityManager.createNamedQuery("Book.LirykaAudioBookListCount");
      Long fromQuery = (Long) query.getSingleResult();
      return fromQuery.intValue();
    } else if (kind == 2) {
      Query query = entityManager.createNamedQuery("Book.EpikaAudioBookListCount");
      Long fromQuery = (Long) query.getSingleResult();
      return fromQuery.intValue();
    } else if (kind == 3) {
      Query query = entityManager.createNamedQuery("Book.DramatAudioBookListCount");
      Long fromQuery = (Long) query.getSingleResult();
      return fromQuery.intValue();
    }
    Query query = entityManager.createNamedQuery("Book.AudioBookListCount");
    Long fromQuery = (Long) query.getSingleResult();
    return fromQuery.intValue();
  }

  public List<Book> getPartOfBooks(int from, long kind) {
    if (kind == 1) {
      Query query = entityManager.createNamedQuery("Book.getLirykaPartOfBookList")
          .setFirstResult(from)
          .setMaxResults(20);
      return query.getResultList();
    } else if (kind == 2) {
      Query query = entityManager.createNamedQuery("Book.getEpikaPartOfBookList")
          .setFirstResult(from)
          .setMaxResults(20);
      return query.getResultList();
    } else if (kind == 3) {
      Query query = entityManager.createNamedQuery("Book.getDramatPartOfBookList")
          .setFirstResult(from)
          .setMaxResults(20);
      return query.getResultList();
    }
    Query query = entityManager.createNamedQuery("Book.getPartOfBookList")
        .setFirstResult(from)
        .setMaxResults(20);
    return query.getResultList();
  }

  public List<Book> getPartOfAudioBooks(int from, long kind) {
    Query query;
    if (kind == 1) {
      query = entityManager.createNamedQuery("Book.EpikaAudioBookList")
          .setFirstResult(from)
          .setMaxResults(20);
    } else if (kind == 2) {
      query = entityManager.createNamedQuery("Book.LirykaAudioBookList")
          .setFirstResult(from)
          .setMaxResults(20);
    } else if (kind == 3) {
      query = entityManager.createNamedQuery("Book.DramatAudioBookList")
          .setFirstResult(from)
          .setMaxResults(20);
    } else {
      query = entityManager.createNamedQuery("Book.getPartOfAudioBooks")
          .setFirstResult(from)
          .setMaxResults(20);
    }
    return query.getResultList();
  }

  public List findBookByLiveSearch(String searchParam) {

    Query query = entityManager.createNamedQuery("Book.LiveSearch");
    query.setParameter("searchParam", "%" + searchParam + "%");

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
