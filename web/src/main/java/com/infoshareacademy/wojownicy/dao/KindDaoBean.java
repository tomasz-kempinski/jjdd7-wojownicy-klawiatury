package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.entity.Kind;
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

  public List<Kind> getOrAddKind(String name) {
    List<Kind> result = getKindByName(name);
    if (result.isEmpty()) {
      Kind kind = new Kind();
      kind.setKind(name);
      result.add(kind);
      addKind(kind);
      return result;
    }
    return result;
  }

  public Kind getKindById(Long id) {
    return entityManager.find(Kind.class, id);
  }

  public List<Kind> getKindsList() {
    Query query = entityManager.createNamedQuery("Kind.findKindsList");
    return query.getResultList();
  }

  public List<Kind> getKindByName(String name) {

    Query query = entityManager.createNamedQuery("Kind.findKindByName");
    query.setParameter("kind", name);
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
