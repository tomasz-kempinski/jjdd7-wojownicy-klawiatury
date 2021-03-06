package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.entity.Author;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AuthorDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void addAuthor(Author author) {
    entityManager.persist(author);
  }

  public Author getAuthorById(Long id) {
    return entityManager.find(Author.class, id);
  }

  public List<Author> getAuthorsList() {
    Query query = entityManager.createNamedQuery("Author.findAuthorsList");
    return query.getResultList();
  }

  public List<Author> getAuthorByName(String name) {

    Query query = entityManager.createNamedQuery("Author.findAuthorByName");
    query.setParameter("authorName", name);
    return query.getResultList();
  }

  public Author editAuthor(Author author) {
    return entityManager.merge(author);
  }

  public void deleteAuthorById(long id) {
    Author author = entityManager.find(Author.class, id);
    if (author != null) {
      entityManager.remove(author);
    }
  }
}
