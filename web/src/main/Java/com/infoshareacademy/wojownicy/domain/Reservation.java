package com.infoshareacademy.wojownicy.domain;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "reservation")
  List<Book> books = new ArrayList<>();

  @OneToMany(mappedBy = "reservation")
  List<User> users = new ArrayList<>();

  @Column(name = "reservation_date")
  private LocalDate reservationDate;


}
