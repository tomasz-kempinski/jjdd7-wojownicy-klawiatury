package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.entity.Author;
import java.util.Arrays;
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

//  public List<Customer> findOrCreate(final String name) {
//    checkNotNull(name);
//    List<Customer> result = this.customerRepository.findByName(name);
//    if (result.isEmpty()) {
//      LOGGER.info("Cannot find customer. Creating a new customer. [name={}]", name);
//      Customer customer = new Customer(name);
//      return Arrays.asList(this.customerRepository.save(customer));
//    }
//    return result;
//  }

  public List<Author> getOrAddAuthor(String name) {
    List<Author> result = getAuthorByName(name);
    if (result.isEmpty()) {
      Author author = new Author();
      author.setAuthorName(name);
      result.add(author);
      addAuthor(author);
      return result;
    }
    return result;
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
