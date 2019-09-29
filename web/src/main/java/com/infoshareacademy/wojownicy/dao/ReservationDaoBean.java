package com.infoshareacademy.wojownicy.dao;

import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Reservation;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ReservationDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  @EJB
  private BookDaoBean bookDaoBean;

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

  public Reservation editReservation(Reservation reservation) {
    return entityManager.merge(reservation);
  }

  public void deleteReservationById(long id) {
    Reservation reservation = entityManager.find(Reservation.class, id);
    Book book = reservation.getBook();
    book.setReserved(false);
    if (reservation != null) {
      entityManager.remove(reservation);
    }
  }
}
