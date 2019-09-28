package com.infoshareacademy.wojownicy.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservations_author_statistics")
public class ReservationsAuthorStatistics {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "reserved_counter")
  private Long reservedCounter;

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
