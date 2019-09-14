package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.entity.Genre;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GenreDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void addGenre(Genre genre) {
    entityManager.persist(genre);
  }

  public Genre getGenreById(Long id) {
    return entityManager.find(Genre.class, id);
  }

  public List<Genre> getGenresList() {
    Query query = entityManager.createNamedQuery("Genre.findGenresList");
    return query.getResultList();
  }

  public List<Genre> getGenreByName(String name) {
    Query query = entityManager.createNamedQuery("Genre.findGenreByName");
    query.setParameter("genreName", name);
    return query.getResultList();
  }

  public Genre editGenre(Genre genre) {
    return entityManager.merge(genre);
  }

  public void deleteGenreById(long id) {
    Genre genre = entityManager.find(Genre.class, id);
    if (genre != null) {
      entityManager.remove(genre);
    }
  }

}
