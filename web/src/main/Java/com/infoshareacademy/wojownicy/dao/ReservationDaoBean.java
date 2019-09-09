package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.Reservation;
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

  public List<Reservation> getReservationList() {
    Query query = entityManager.createQuery("SELECT u FROM reservation u");
    return query.getResultList();
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
