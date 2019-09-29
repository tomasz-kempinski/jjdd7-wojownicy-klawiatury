package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.dao.ReservationDaoBean;
import com.infoshareacademy.wojownicy.dao.UserDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Reservation;
import com.infoshareacademy.wojownicy.domain.entity.User;
import java.time.LocalDateTime;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ReservationService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private ReservationDaoBean reservationDaoBean;

  @EJB
  private BookDaoBean bookDaoBean;

  @EJB
  private UserDaoBean userDaoBean;

  @Inject
  StatisticsService statisticsService;

  private User findUserByEmail(String userEmail) {
    logger.info("User with " + userEmail + "Email has been found");
    return userDaoBean.findUserByEmail(userEmail);

  }

  private Book findBookId(Long id) {
    logger.info("Book with " + id + "ID has been found");
    return bookDaoBean.getBookById(id);
  }

  public void newReservation(Long bookId, String userEmail) {
    Reservation reservation = new Reservation();
    reservation.setBook(findBookId(bookId));
    reservation.setUser(findUserByEmail(userEmail));
    reservation.setReservationDate(LocalDateTime.now());
    reservationDaoBean.addReservation(reservation);
    Book book = bookDaoBean.getBookById(bookId);
    statisticsService.addStatistic(bookId);
    book.setReserved(true);
    bookDaoBean.editBook(book);
  }
}
