package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.ReservationDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Reservation;
import com.infoshareacademy.wojownicy.domain.entity.User;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ReservationService {

  @EJB
  private ReservationDaoBean reservationDaoBean;

  public List<Reservation> findReservationByBookId(Long id) {
    return reservationDaoBean.getReservationsByBookId(id);
  }

  private User findUserId(Long userId) {
    return reservationDaoBean.getUserId(userId);
  }

  private Book findBookId(Long id) {
    return reservationDaoBean.getBookId(id);
  }

  public void newReservation(Reservation reservation, Long bookId, Long userId) {
    reservation.setBook(findBookId(bookId));
    reservation.setUser(findUserId(userId));
    reservationDaoBean.addReservation(reservation);
  }
}
