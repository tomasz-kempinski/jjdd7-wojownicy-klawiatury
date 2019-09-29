package com.infoshareacademy.wojownicy.domain.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(
        name = "Reservation.findReservationsList",
        query = "SELECT r FROM Reservation r"
    ),
    @NamedQuery(
        name = "Reservation.findReservationsByBookId",
        query = "SELECT r FROM Reservation AS r JOIN r.book AS b WHERE b.id IN :id"
    ),
    @NamedQuery(
        name = "Reservation.findReservationsForUser",
        query = "SELECT r FROM Reservation AS r INNER JOIN r.user AS u WHERE u.userId IN :userId"
    )
})
@Entity
@Table(name = "reservation")
public class Reservation {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "book_id")
  private Book book;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @NotNull
  @Column(name = "reservation_date")
  private LocalDateTime reservationDate;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public LocalDateTime getReservationDate() {
    return reservationDate;
  }

  public void setReservationDate(LocalDateTime reservationDate) {
    this.reservationDate = reservationDate;
  }
}
