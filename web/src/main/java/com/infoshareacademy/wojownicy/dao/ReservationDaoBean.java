package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Reservation;
import com.infoshareacademy.wojownicy.domain.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ReservationDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void addReservation(Reservation reservation) {
    entityManager.persist(reservation);
  }

  public Reservation getReservationById(Long id) {
    return entityManager.find(Reservation.class, id);
  }

  public List<Reservation> getReservationsList() {
    Query query = entityManager.createNamedQuery("Reservation.findReservationsList");
    return query.getResultList();
  }

  public List<Reservation> getReservationsByBookId(Long id) {
    Query query = entityManager.createNamedQuery("Reservation.findReservationsByBookId");
    query.setParameter("id", id);
    return query.getResultList();
  }

  public Book getBookId(Long id) {
    Query queryBookId = entityManager.createNamedQuery("Reservation.getBookId");
    queryBookId.setParameter("id", id);
    return (Book) queryBookId;
  }

  public User getUserId(String userEmail) {
    Query queryUserId = entityManager.createNamedQuery("Reservation.getUserId");
    queryUserId.setParameter("userEmail", userEmail);
    return (User) queryUserId;
  }

  public Reservation editReservation(Reservation reservation) {
    return entityManager.merge(reservation);
  }

  public void deleteReservationById(long id) {
    Reservation reservation = entityManager.find(Reservation.class, id);
    if (reservation != null) {
      entityManager.remove(reservation);
    }
  }
}
