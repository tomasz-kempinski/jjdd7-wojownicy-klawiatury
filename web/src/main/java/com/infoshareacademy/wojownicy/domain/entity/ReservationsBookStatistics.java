package com.infoshareacademy.wojownicy.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@NamedQueries(
    @NamedQuery(
        name = "StatisticsBook.findBookStatistics",
        query = "SELECT s FROM ReservationsBookStatistics s ORDER BY s.reservedCounter DESC"
    )
)
@Entity
@Table(name = "reservations_book_statistics")
public class ReservationsBookStatistics {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "book_id")
  Book book;

  @Column(name = "reserved_counter")
  private Long reservedCounter;

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

  public Long getReservedCounter() {
    return reservedCounter;
  }

  public void setReservedCounter(Long reservedCounter) {
    this.reservedCounter = reservedCounter;
  }
}
