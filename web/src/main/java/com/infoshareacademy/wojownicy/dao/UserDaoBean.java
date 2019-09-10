package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void addUser(User user) {
    entityManager.persist(user);
  }

  public User getUserById(Long id) {
    return entityManager.find(User.class, id);
  }

  public List<User> getUsersList() {
    Query query = entityManager.createNamedQuery("User.findUsersList");
    return query.getResultList();
  }

  public User editUser(User user) {
    return entityManager.merge(user);
  }

  public void deleteUserById(long id) {
    User user = entityManager.find(User.class, id);
    if (user != null) {
      entityManager.remove(user);
    }
  }
}
