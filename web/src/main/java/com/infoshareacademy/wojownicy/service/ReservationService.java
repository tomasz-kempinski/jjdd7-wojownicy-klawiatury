package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.ReservationDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Reservation;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ReservationService {

  @EJB
  ReservationDaoBean reservationDaoBean;

  public List<Reservation> findReservationByBookId(Long id) {
    return reservationDaoBean.getReservationsByBookId(id);
  }

  public void newReservation(Reservation reservation) {
    reservationDaoBean.addReservation(reservation);
  }
}
