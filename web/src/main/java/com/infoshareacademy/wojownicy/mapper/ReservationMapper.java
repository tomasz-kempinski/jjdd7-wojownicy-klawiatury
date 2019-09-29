package com.infoshareacademy.wojownicy.mapper;

import com.infoshareacademy.wojownicy.domain.entity.Reservation;
import com.infoshareacademy.wojownicy.dto.ReservationDto;
import javax.ejb.Stateless;

@Stateless
public class ReservationMapper {

  public Reservation mapDtoToEntity(ReservationDto reservationDto) {

    Reservation reservation = new Reservation();
    reservation.setId(reservationDto.getId());
    reservation.setBook(reservationDto.getBook());
    reservation.setUser(reservationDto.getUser());
    return reservation;
  }

  public ReservationDto mapEntityToDto(Reservation reservation) {

    ReservationDto reservationDto = new ReservationDto();
    reservationDto.setId(reservation.getId());
    reservationDto.setBook(reservation.getBook());
    reservationDto.setUser(reservation.getUser());
    return reservationDto;
  }
}
