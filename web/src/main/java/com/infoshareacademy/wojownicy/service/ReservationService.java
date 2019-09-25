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

  private User findUserId(String userEmail) {
    return reservationDaoBean.getUserId(userEmail);
  }

  private Book findBookId(Long id) {
    return reservationDaoBean.getBookId(id);
  }

  public void newReservation(Long bookId, String userEmail) {
    Reservation reservation = new Reservation();
    reservation.setBook(findBookId(bookId));
    reservation.setUser(findUserId(userEmail));
    reservationDaoBean.addReservation(reservation);
  }
}
