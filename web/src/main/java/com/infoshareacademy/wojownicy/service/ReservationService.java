package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.dao.ReservationDaoBean;
import com.infoshareacademy.wojownicy.dao.UserDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Book;
import com.infoshareacademy.wojownicy.domain.entity.Reservation;
import com.infoshareacademy.wojownicy.domain.entity.User;
import com.infoshareacademy.wojownicy.mapper.ReservationMapper;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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

  private Long findUserByEmail(String userEmail) {
    User user = new User();
    logger.info("User with " + userEmail + "Email has been found");
    userDaoBean.findUserByEmail(userEmail);
    return user.getUserId();
  }

  public List<Reservation> findReservationForUser (String userEmail) {
    return reservationDaoBean.getReservationsForUser(findUserByEmail(userEmail));
  }

  private Book findBookId(Long id) {
    logger.info("Book with " + id + "ID has been found");
    return bookDaoBean.getBookById(id);
  }

  public void newReservation(Long bookId, String userEmail) {
    Reservation reservation = new Reservation();
    reservation.setBook(findBookId(bookId));
    reservation.setUser(userDaoBean.findUserByEmail(userEmail));
    reservation.setReservationDate(LocalDateTime.now());
    reservationDaoBean.addReservation(reservation);
    Book book = bookDaoBean.getBookById(bookId);
    book.setReserved(true);
    bookDaoBean.editBook(book);
  }
}
