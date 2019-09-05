package com.infoshareacademy.wojownicy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @Column(name = "book_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "book_title")
  private String title;

  @ManyToOne
  @JoinColumn(name = "author_id")
  Author author;

  //todo wstaw gatunek jak ogarniesz relacje wiele do wielu

  @ManyToOne
  @JoinColumn(name = "kind_id")
  Kind kind;

  @Column(name = "is_favourite")
  private boolean isFavourite = false;

  @Column(name = "cover_url")
  private String coverURL;

  @Column(name = "is_reserved")
  private boolean isReserved = false;

  @Column(name = "has_audio")
  private boolean hasAudio = false;

  @ManyToOne
  @JoinColumn(name = "is_reserved_by")
  User user;

}
