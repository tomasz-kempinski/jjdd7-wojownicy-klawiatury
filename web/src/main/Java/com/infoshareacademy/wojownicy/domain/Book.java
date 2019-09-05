package com.infoshareacademy.wojownicy.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @Column(name = "book_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "book_title")
  private String title;

  @ManyToOne
  @JoinColumn(name = "author_id")
  Author author;

  //todo wstaw gatunek jak ogarniesz relacje wiele do wielu

  @ManyToMany
  @JoinTable(
      name = "book_genre",
      joinColumns = {@JoinColumn(name = "book_id")},
      inverseJoinColumns = {@JoinColumn(name = "genre_id")})
  Set<Genre> genres = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "kind_id")
  Kind kind;

  @NotNull
  @Column(name = "is_favourite")
  private boolean isFavourite = false;

  @NotNull
  @Column(name = "cover_url")
  private String coverURL;

  @NotNull
  @Column(name = "is_reserved")
  private boolean isReserved = false;

  @NotNull
  @Column(name = "has_audio")
  private boolean hasAudio = false;

  @ManyToOne
  @JoinColumn(name = "is_reserved_by")
  User user;

}
