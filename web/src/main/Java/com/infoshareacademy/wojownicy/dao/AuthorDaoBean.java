package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Author;
import com.infoshareacademy.wojownicy.domain.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AuthorDaoBean {
  @PersistenceContext
  EntityManager entityManager;

  public void addAuthor (Author author){
    entityManager.persist(author);
  }

  public Author getAuthorById(Long id){return entityManager.find(Author.class,id);}

  public List<Author> getAuthorList(){
    Query query = entityManager.createQuery("SELECT u FROM author u");
    return query.getResultList();
  }

  public Author editAuthor (Author author){
    return entityManager.merge(author);
  }

  public void deleteAuthorById (long id){
    Author author = entityManager.find(Author.class,id);
    if(author != null){
      entityManager.remove(author);
    }
  }


}
