package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Book;
import com.infoshareacademy.wojownicy.domain.Genre;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GenreDaoBean {
  @PersistenceContext
  EntityManager entityManager;

  public void addGenre (Genre genre){
    entityManager.persist(genre);
  }

  public Genre getGenreById(Long id){return entityManager.find(Genre.class,id);}

  public List<Genre> getGenreList(){
    Query query = entityManager.createQuery("SELECT u FROM genre u");
    return query.getResultList();
  }
  public Genre editGenre (Genre genre){
    return entityManager.merge(genre);
  }

  public void deleteGenreById (long id){
    Genre genre = entityManager.find(Genre.class,id);
    if(genre != null){
      entityManager.remove(genre);
    }
  }

}
