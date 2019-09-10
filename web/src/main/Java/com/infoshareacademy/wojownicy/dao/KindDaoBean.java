package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Kind;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class KindDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void addKind(Kind kind) {
    entityManager.persist(kind);
  }

  public Kind getKindById(Long id) {
    return entityManager.find(Kind.class, id);
  }

  public List<Kind> getKindsList() {
    Query query = entityManager.createQuery("SELECT u FROM kind u");
    return query.getResultList();
  }

  public Kind editKind(Kind kind) {
    return entityManager.merge(kind);
  }

  public void deleteKindById(long id) {
    Kind kind = entityManager.find(Kind.class, id);
    if (kind != null) {
      entityManager.remove(kind);
    }
  }
}
