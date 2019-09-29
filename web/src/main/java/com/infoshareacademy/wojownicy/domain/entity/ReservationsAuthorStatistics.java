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
@NamedQueries({
    @NamedQuery(
        name = "StatisticsAuthor.findAuthorStatisticsList",
        query = "SELECT r FROM ReservationsAuthorStatistics r ORDER BY r.reservedCounter DESC"
    )
})
@Entity
@Table(name = "reservations_author_statistics")
public class ReservationsAuthorStatistics {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id", unique = true)
  private Author author;

  @Column(name = "reserved_counter")
  private Long reservedCounter = 0L;

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getReservedCounter() {
    return reservedCounter;
  }

  public void setReservedCounter(Long reservedCounter) {
    this.reservedCounter = reservedCounter;
  }
}
